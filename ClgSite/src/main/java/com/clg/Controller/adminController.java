package com.clg.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clg.Entities.Colleges;
import com.clg.Forms.CollegeForm;
import com.clg.services.CollegeService;

@Controller
@RequestMapping("/admin")
public class adminController {


    @Autowired
    private CollegeService collegeService;

    @GetMapping("/addClg")
    public String adminHome(Model model)
    {
        // System.out.println("heyy");
        CollegeForm collegeForm = new CollegeForm();
        model.addAttribute("form", collegeForm);
        return "/Admin/addClg";
    }

    @PostMapping("/add")
    public String processClg(@ModelAttribute CollegeForm form)
    {

        // process. 
        System.out.println(form);

        Colleges colleges = new Colleges();

        // colleges.setClgId(form.getClgId());
        colleges.setClgName(form.getClgName());
        colleges.setAddress(form.getAddress());
        colleges.setClgContact(form.getClgContact());
        colleges.setClgEmail(form.getClgEmail());
        colleges.setDescription(form.getDescription());
        colleges.setClgLocation(form.getClgLocation());
        colleges.setRatings(form.getRatings());
        colleges.setStreamsAvail(form.getStreamsAvail());


        collegeService.save(colleges);

        

        return "redirect:/admin/addClg";
    }
   
}
