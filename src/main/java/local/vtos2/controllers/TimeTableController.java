package local.vtos2.controllers;
//import local.vtos.models.Item;
//import local.vtos.dao.TimeTableDao;
//import local.vtos.dao.ItemDao;

import local.vtos2.models.Item;
import local.vtos2.models.TimeTable;
import local.vtos2.repositories.ItemRepository;
import local.vtos2.repositories.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/timetable")
public class TimeTableController {


  //  private final TimeTableDao timeTableDao;
  //  private final ItemDao itemDao;
    @Autowired
    private TimeTableRepository timeTableRepo;
    @Autowired
    private ItemRepository itemRepo;


    @GetMapping("/new")
    public String showNewTimeTable(Model model){
        List<Item> itemList=itemRepo.findAll();
        model.addAttribute("items",itemList);
        model.addAttribute("timeTable", new TimeTable());
        return "timetable/new";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute("timeTable") TimeTable timeTable){
        timeTableRepo.save(timeTable);
        return "redirect:/new";
        // return null;
    }

}
