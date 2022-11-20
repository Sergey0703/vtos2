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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class TimeTableController {


  //  private final TimeTableDao timeTableDao;
  //  private final ItemDao itemDao;
    @Autowired
    private TimeTableRepository timeTableRepo;
    @Autowired
    private ItemRepository itemRepo;


    @GetMapping()
    public String showTimeTable(Model model){
        List<TimeTable> listTimeTable=timeTableRepo.findAll();
        model.addAttribute("listTimeTable",listTimeTable);
        System.out.println("index");
        return "index";
    }

    @GetMapping("/timetable/edit/{id}")
    public String editTimeTable(@PathVariable("id") Integer id, Model model){
        List<Item> itemList=itemRepo.findAll();
        model.addAttribute("items",itemList);
        TimeTable timeTable=timeTableRepo.findById(id).get();
        model.addAttribute("timeTable",timeTable);
        System.out.println("timetable/edit");
        return "timetable/new";
    }


    @GetMapping("/timetable/new")
    public String showNewTimeTable(Model model){
        List<Item> itemList=itemRepo.findAll();
        model.addAttribute("items",itemList);
        model.addAttribute("timeTable", new TimeTable());
        return "timetable/new";
    }

    @PostMapping("/timetable/save")
    public String create(@ModelAttribute("timeTable") TimeTable timeTable){
        timeTableRepo.save(timeTable);
        return "redirect:/index";
        // return null;
    }

}
