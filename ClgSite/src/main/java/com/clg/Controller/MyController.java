package com.clg.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.clg.Entities.Colleges;
import com.clg.Entities.Streams;
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
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String adminForm() {
        return "login";
    }

    // @PostMapping("/login")
    // public String adminLogin()
    // {
    // return "/Admin/AdminPage";
    // }

    @GetMapping("allColleges")
    public String allColleges(Model model) {

        List<Colleges> colleges = collegeService.getAllColleges();
        // System.out.println(colleges);
        model.addAttribute("colleges", colleges);

        return "allColleges";
    }

    @RequestMapping("/CollegeInfo/{clgId}")
    public String collegeInfo(Model model, @PathVariable("clgId") String clgId) {
        // System.out.println(clgId);
        Colleges college = collegeService.getCollegesById(clgId);
        model.addAttribute("college", college);

        List<Streams> streams = streamService.getStreamsByCollegeIdList(clgId);

        // System.out.println(streams);

        model.addAttribute("streams", streams);
        return "/CollegeInfo";
    }

    @GetMapping("/search")
    public String searchCollege(@ModelAttribute CollegeSearchForm searchForm, Model model, HttpSession session) {

        // System.out.println(searchForm);

        if (searchForm.getPcmMarks() < 150) {
            Message message = Message.builder()
                    .message("You are not qualified to get admission, You need minimum 150 marks to in PCM to qualify")
                    .type(MessageType.red).build();
            session.setAttribute("message", message);
            return "redirect:/search";
        }

        String qouta = searchForm.getQouta();
        model.addAttribute("qouta", qouta);

        System.out.println(searchForm.getStream());
        if (searchForm.getStream().equalsIgnoreCase("all")) {

            // System.out.println("Inloop");

            if (qouta.equalsIgnoreCase("openQuotaCuttOff")) {

                List<Streams> streams = streamService.findByCutOffGenaral(searchForm.getCetMarks()+1);
                model.addAttribute("streams", streams);
                
            } else if (qouta.equalsIgnoreCase("obcQuotaCuttOff")) {

                // System.out.println("Inloop");
                List<Streams> streams = streamService.findByCutOffObc(searchForm.getCetMarks()+1);
                model.addAttribute("streams", streams);

            } else if (qouta.equalsIgnoreCase("scQuotaCuttOff")) {

                // System.out.println("Inloop");
                List<Streams> streams = streamService.findByCutOffSc(searchForm.getCetMarks()+1);
                model.addAttribute("streams", streams);

            } else if (qouta.equalsIgnoreCase("vjQuotaCuttOff")) {

                // System.out.println("Inloop");
                List<Streams> streams = streamService.findByCutOffVj(searchForm.getCetMarks()+1);
                model.addAttribute("streams", streams);

            } else if (qouta.equalsIgnoreCase("nt1QuotaCuttOff")) {

                // System.out.println("Inloop");
                List<Streams> streams = streamService.findByCutOffNt1(searchForm.getCetMarks()+1);
                model.addAttribute("streams", streams);

            }
            else if (qouta.equalsIgnoreCase("nt2QuotaCuttOff")) {

                // System.out.println("Inloop");
                List<Streams> streams = streamService.findByCutOffNt2(searchForm.getCetMarks()+1);
                model.addAttribute("streams", streams);

            } else if (qouta.equalsIgnoreCase("nt3QuotaCuttOff")) {

                // System.out.println("Inloop");
                List<Streams> streams = streamService.findByCutOffNt3(searchForm.getCetMarks()+1);
                model.addAttribute("streams", streams);

            } else if (qouta.equalsIgnoreCase("tfwsQuotaCuttOff")) {
                // System.out.println("Inloop");
                List<Streams> streams = streamService.findByCutOffTfws(searchForm.getCetMarks()+1);
                model.addAttribute("streams", streams);

            }

        }
        model.addAttribute("searchForm", searchForm);
        return "/searchPage";
    }
}
