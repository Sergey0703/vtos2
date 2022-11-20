package local.vtos2.controllers;

//import local.vtos2.dao.ItemDao;

import local.vtos2.models.Item;
import local.vtos2.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
   //     model.addAttribute("item",itemDao.showItem(id));
      return "items/item";
    }

    @GetMapping("/new")
    public String newItem(Model model){
    //    model.addAttribute("item", new Item());
        return "items/new";
    }

    //@PostMapping()
    //public String create(@ModelAttribute("item") Item item){
     //   itemDao.save(item);
     //  return "redirect:/items";
       // return null;
    //}

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
       // model.addAttribute("item", itemDao.showItem(id));
        return "items/edit";
    }

    //@PatchMapping("/{id}")
   // public String update(@ModelAttribute("item") Item item, @PathVariable("id") int id){
     // itemDao.update(id, item);
   //   return "redirect:/items";
   // }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
     //   itemDao.delete(id);
        return "redirect:/items";
    }
}
