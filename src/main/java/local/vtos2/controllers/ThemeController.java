package local.vtos2.controllers;

import local.vtos2.models.Theme;
import local.vtos2.repositories.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/themes")
public class ThemeController {

    @Autowired
    private ThemeRepository repo;

    @GetMapping("/{id}")
    public String allThemes(Model model){

        List<Theme> themeList=repo.findAll();
        model.addAttribute("themelist",themeList);
        System.out.println("themes");
        return "themes/themes";
    }
    @GetMapping("/new")
    public String newItem(Model model){
        model.addAttribute("theme", new Theme());
        return "themes/theme_form";
    }


}
