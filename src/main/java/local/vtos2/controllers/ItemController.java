package local.vtos2.controllers;

//import local.vtos2.dao.ItemDao;

import local.vtos2.models.Item;
import local.vtos2.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {

  //  private final ItemDao itemDao;

    @Autowired
    private ItemRepository repo;

    @GetMapping()
    public String allItems(Model model){
     //   model.addAttribute("items",itemDao.index());
        List<Item> itemList=repo.findAll();
        model.addAttribute("items",itemList);
        System.out.println("index");
        return "items/items";
    }

    @GetMapping("/{id}")
     public String item(@PathVariable("id") int id, Model model){
        System.out.println("id");
        model.addAttribute("item",repo.findById(id).get());
      return "items/item";
    }

    @GetMapping("/new")
    public String newItem(Model model){
        model.addAttribute("item", new Item());
        return "items/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("item") Item item){
        repo.save(item);
        System.out.println("Save!!!It");
      return "redirect:/items";
     // return null;
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("item", repo.findById(id).get());
        return "items/edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("item") Item item, @PathVariable("id") int id){
     repo.save(item);
     System.out.println("update!!!");
      return "redirect:/items";
    }

    @PostMapping("/delete/{id}")
   // public String delete(@PathVariable("id") int id){
    public String delete(@ModelAttribute("item") Item item){
        System.out.println("delete");
        repo.delete(item);
        return "redirect:/items";
    }

}
