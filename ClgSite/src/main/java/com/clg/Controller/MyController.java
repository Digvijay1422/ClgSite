package com.clg.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.clg.Entities.Colleges;
import com.clg.Forms.CollegeForm;
import com.clg.services.CollegeService;



@Controller
public class MyController {
    
    @Autowired
    private CollegeService collegeService;

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

    @PostMapping("/login")
    public String adminLogin(Model model)
    {
        CollegeForm collegeForm = new CollegeForm();
        model.addAttribute("form", collegeForm);
        return "/Admin/addClg";
    }

    @GetMapping("allColleges")
    public String allColleges(Model model)
    {

        
        List<Colleges> colleges = collegeService.getAllColleges();
        // System.out.println(colleges);
        model.addAttribute("colleges", colleges);

        return "allColleges";
    }
   
}
