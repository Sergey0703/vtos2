package local.vtos2.controllers;

import local.vtos2.models.Theme;
import local.vtos2.repositories.ItemRepository;
import local.vtos2.repositories.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/themes")
public class ThemeController {

    @Autowired
    private ThemeRepository repo;

    @Autowired
    private ItemRepository itemRepo;

    @GetMapping("/{id}")
    public String allThemes(Model model,@PathVariable("id") int id){

        List<Theme> themeList=repo.findAll();
        model.addAttribute("themelist",themeList);
      //  model.addAttribute("item",itemRepo.findById(id).get());
        model.addAttribute("item_id",id);
        System.out.println("themes");
        return "themes/themes";
    }
    @GetMapping("/new/{id}")
    public String newTheme(Model model,@PathVariable("id") int id){
        model.addAttribute("item",itemRepo.findById(id).get());
        model.addAttribute("item_id",id);
        model.addAttribute("theme", new Theme());
        return "themes/theme_form";
    }

    @GetMapping("/edit/{id}")
    public String editTheme(Model model,@PathVariable("id") int id){
      //  model.addAttribute("item",itemRepo.findById(id).get());
        model.addAttribute("tid",id);
        model.addAttribute("theme", repo.findById(id).get());
        return "themes/theme_form";
    }
    @PostMapping("/save/{id}")
    public String create(@ModelAttribute("theme") Theme theme,@PathVariable("id") int id){
       // int idInt=theme.getId();
        System.out.println("id="+id);
        if(id!=0){

        Theme th=repo.findById(id).get();
        th.setName(theme.getName());
        th.setText(theme.getText());
            repo.save(th);
            System.out.println("upd");
        }else{
            repo.save(theme);
            System.out.println("save");
        }

        int item_id=theme.getItem().getId();
        System.out.println("Save!!!");
        return "redirect:/themes/"+item_id;
        // return null;
    }

    @PostMapping("/delete/{id}")
    // public String delete(@PathVariable("id") int id){
    public String delete(@ModelAttribute("theme") Theme theme,  @PathVariable("id") int id){
        int id_theme=theme.getItem().getId();
        System.out.println("delete");
        repo.delete(theme);
        return "redirect:/themes/"+id_theme;
    }
    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("theme") Theme theme, @PathVariable("id") int id){
        repo.save(theme);
        System.out.println("update!!!");
        return "redirect:/themes/"+theme.getItem().getId();
    }


}
