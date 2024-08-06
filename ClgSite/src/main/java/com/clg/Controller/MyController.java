package com.clg.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clg.Entities.Colleges;
import com.clg.Entities.Streams;
import com.clg.Forms.CollegeForm;
import com.clg.Forms.CollegeSearchForm;
import com.clg.Helper.Message;
import com.clg.Helper.MessageType;
import com.clg.services.CollegeService;
import com.clg.services.StreamService;

import jakarta.servlet.http.HttpSession;



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

    @GetMapping("/search")
    public String searchCollege(@ModelAttribute CollegeSearchForm searchForm,Model model,HttpSession session)
    {

        // System.out.println(searchForm);

        if(searchForm.getPcmMarks()<150){
            Message message = Message.builder().message("You are not qualified to get admission, You need minimum 150 marks to in PCM to qualify").type(MessageType.red).build();
             session.setAttribute("message", message); 
             return "redirect:/search";     
        }

        List<Streams> streams = streamService.findAll();
        model.addAttribute("streams", streams);
        // System.out.println(streams);

        model.addAttribute("searchForm", searchForm);


        return "/searchPage";
    }
}
