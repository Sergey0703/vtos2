package local.vtos2.controllers;
//import local.vtos.models.Item;
//import local.vtos.dao.TimeTableDao;
//import local.vtos.dao.ItemDao;

import local.vtos2.models.Item;
import local.vtos2.models.TimeTable;
import local.vtos2.repositories.ItemRepository;
import local.vtos2.repositories.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
     //   List<TimeTable> listTimeTable=timeTableRepo.findAllByOrderByIdAsc();
        List<TimeTable> listTimeTable=timeTableRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
        model.addAttribute("listTimeTable",listTimeTable);
        System.out.println("index");
        return "index";
    }

    @GetMapping("/index_admin")
    public String showTimeTableAdmin(Model model){
        //   List<TimeTable> listTimeTable=timeTableRepo.findAllByOrderByIdAsc();
        List<Item> itemList=itemRepo.findAll();
        model.addAttribute("items",itemList);
        List<TimeTable> listTimeTable=timeTableRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
        model.addAttribute("listTimeTable",listTimeTable);
        System.out.println("indexAdmin");
        return "index_admin";
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
        System.out.println("Save!!!");
        return "redirect:/";
        // return null;
    }

    @PostMapping("/timetable/savelist")
    public String saveList(TimeTable timeTable, HttpServletRequest request){
        String[] itemsArray= request.getParameterValues("item");
        String[] idArray= request.getParameterValues("id");
        for(int i=0; i<itemsArray.length;i++){
            System.out.println("id0=" + idArray[i] + " itemA0=" + itemsArray[i]);
            if(!itemsArray[i].equals("")) {
             Item it=itemRepo.findById(Integer.valueOf(itemsArray[i])).get();
                try {
                    TimeTable timeT = timeTableRepo.findById(Integer.valueOf(idArray[i])).get();
                    //timeTable.saveTimeTable(i, it);
                    timeT.setItem(it);
                    //timeT.item=;
                    timeTableRepo.save(timeT);
                }catch (Exception e) {
                      System.out.println("Exception!!!");
                }

                 System.out.println("id=" + i + " itemA=" + itemsArray[i]);
             }
        }
        //timeTableRepo.save(timeTable);
        System.out.println("Save!!!");
        return "redirect:/index_admin";
        // return null;
    }
}
