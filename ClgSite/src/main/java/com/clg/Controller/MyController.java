package com.clg.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clg.Entities.Colleges;
import com.clg.Entities.Streams;
import com.clg.Forms.CollegeForm;
import com.clg.services.CollegeService;
import com.clg.services.StreamService;



@Controller
public class MyController {
    
    @Autowired
    private CollegeService collegeService;

    @Autowired
    private StreamService streamService;

    @GetMapping("/")
    public String home()
    {
        return "home";
    }

    @GetMapping("/login")
    public String adminForm()
    {
        return "login";
    }

    // @PostMapping("/login")
    // public String adminLogin()
    // {
    //     return "/Admin/AdminPage";
    // }

    @GetMapping("allColleges")
    public String allColleges(Model model)
    {

        
        List<Colleges> colleges = collegeService.getAllColleges();
        // System.out.println(colleges);
        model.addAttribute("colleges", colleges);

        return "allColleges";
    }
   

    @RequestMapping("/CollegeInfo/{clgId}")
    public String collegeInfo(Model model, @PathVariable("clgId") String clgId) 
    {
        // System.out.println(clgId);
        Colleges college =  collegeService.getCollegesById(clgId);
        model.addAttribute("college", college);

        List<Streams> streams = streamService.getStreamsByCollegeIdList(clgId);
        
        // System.out.println(streams);


        model.addAttribute("streams", streams);
        return "/CollegeInfo";
    }
}
