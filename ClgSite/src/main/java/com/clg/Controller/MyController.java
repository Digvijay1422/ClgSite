package com.clg.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clg.Entities.Admin;
import com.clg.Entities.Colleges;
import com.clg.Entities.Streams;
import com.clg.Forms.AdminForm;
import com.clg.Forms.CollegeSearchForm;
import com.clg.Helper.Message;
import com.clg.Helper.MessageType;
import com.clg.services.CollegeService;
import com.clg.services.StreamService;
import com.clg.services.Impl.AdminServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {

    @Autowired
    private CollegeService collegeService;

     @Autowired
    private AdminServiceImpl adminServiceImpl;

    @Autowired
    private StreamService streamService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String adminForm(Model model) {
        return "login";
    }

   
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

        String inputStream = searchForm.getStream();
        List<Streams> streams = null;

        if (searchForm.getStream().equalsIgnoreCase("all") && searchForm.getLocation().equalsIgnoreCase("all")) {

            if (qouta.equalsIgnoreCase("openQuotaCuttOff")) {

                streams = streamService.findByCutOffGenaral(searchForm.getCetMarks() + 1);

            } else if (qouta.equalsIgnoreCase("obcQuotaCuttOff")) {

                streams = streamService.findByCutOffObc(searchForm.getCetMarks() + 1);

            } else if (qouta.equalsIgnoreCase("scQuotaCuttOff")) {

                streams = streamService.findByCutOffSc(searchForm.getCetMarks() + 1);

            } else if (qouta.equalsIgnoreCase("vjQuotaCuttOff")) {

                streams = streamService.findByCutOffVj(searchForm.getCetMarks() + 1);

            } else if (qouta.equalsIgnoreCase("nt1QuotaCuttOff")) {

                streams = streamService.findByCutOffNt1(searchForm.getCetMarks() + 1);

            } else if (qouta.equalsIgnoreCase("nt2QuotaCuttOff")) {

                streams = streamService.findByCutOffNt2(searchForm.getCetMarks() + 1);

            } else if (qouta.equalsIgnoreCase("nt3QuotaCuttOff")) {

                streams = streamService.findByCutOffNt3(searchForm.getCetMarks() + 1);

            } else if (qouta.equalsIgnoreCase("tfwsQuotaCuttOff")) {
                // System.out.println("Inloop");
                streams = streamService.findByCutOffTfws(searchForm.getCetMarks() + 1);

            }

        } else if (searchForm.getStream() != "all" && searchForm.getLocation().equalsIgnoreCase("all")) {

            if (qouta.equalsIgnoreCase("openQuotaCuttOff")) {

                streams = streamService.findByCutOffGenaralStreams(searchForm.getCetMarks() + 1, inputStream);

            } else if (qouta.equalsIgnoreCase("obcQuotaCuttOff")) {

                streams = streamService.findByCutOffObcStreams(searchForm.getCetMarks() + 1, inputStream);

            } else if (qouta.equalsIgnoreCase("scQuotaCuttOff")) {

                streams = streamService.findByCutOffScStreams(searchForm.getCetMarks() + 1, inputStream);

            } else if (qouta.equalsIgnoreCase("vjQuotaCuttOff")) {

                streams = streamService.findByCutOffVjStreams(searchForm.getCetMarks() + 1, inputStream);

            } else if (qouta.equalsIgnoreCase("nt1QuotaCuttOff")) {

                streams = streamService.findByCutOffNt1Streams(searchForm.getCetMarks() + 1, inputStream);

            } else if (qouta.equalsIgnoreCase("nt2QuotaCuttOff")) {

                streams = streamService.findByCutOffNt2Streams(searchForm.getCetMarks() + 1, inputStream);

            } else if (qouta.equalsIgnoreCase("nt3QuotaCuttOff")) {

                streams = streamService.findByCutOffNt3Streams(searchForm.getCetMarks() + 1, inputStream);

            } else if (qouta.equalsIgnoreCase("tfwsQuotaCuttOff")) {
                streams = streamService.findByCutOffTfwsStreams(searchForm.getCetMarks() + 1, inputStream);

            }

        }
         else if (searchForm.getStream() != "all" && searchForm.getLocation() != "all") {

                if(qouta.equalsIgnoreCase("openQuotaCuttOff"))
                {
                    streams= streamService.findByCuttOffGeneralLocation(searchForm.getCetMarks(),searchForm.getStream(), searchForm.getLocation());
                }
                else if(qouta.equalsIgnoreCase("scQuotaCuttOff"))
                {
                    streams = streamService.findByCuttOffScLocation(searchForm.getCetMarks(), inputStream, searchForm.getLocation());
                }
                 else if(qouta.equalsIgnoreCase("vjQuotaCuttOff"))
                {
                    streams = streamService.findByCuttOffVjLocation(searchForm.getCetMarks(), inputStream, searchForm.getLocation());
                }
                else if(qouta.equalsIgnoreCase("nt1QuotaCuttOff"))
                {
                    streams = streamService.findByCuttOffNt1Location(searchForm.getCetMarks(), inputStream, searchForm.getLocation());
                }
                else if(qouta.equalsIgnoreCase("nt2QuotaCuttOff"))
                {
                    streams = streamService.findByCuttOffNt2Location(searchForm.getCetMarks(), inputStream, searchForm.getLocation());
                }
                else if(qouta.equalsIgnoreCase("nt3QuotaCuttOff"))
                {
                    streams = streamService.findByCuttOffNt2Location(searchForm.getCetMarks(), inputStream, searchForm.getLocation());
                }
                else if(qouta.equalsIgnoreCase("obcQuotaCuttOff"))
                {
                    streamService.findByCuttOffObcLocation(searchForm.getCetMarks(), inputStream, searchForm.getLocation());
                }
                else if(qouta.equalsIgnoreCase("tfwsQuotaCuttOff"))
                {
                    streams = streamService.findByCuttOffTfwsLocation(searchForm.getCetMarks(), inputStream, searchForm.getLocation());
                }
        }

        model.addAttribute("streams", streams);
        model.addAttribute("searchForm", searchForm);
        return "/searchPage";
    }

    @GetMapping("/feedback")
    public String feedBack()
    {
        return "feedBack";
    }


    
    @GetMapping("/reg")
    public String registration(Model model)
    {
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        return "AdminReg";
    }

    @PostMapping("/reg")
    public String registration(@ModelAttribute AdminForm adminForm,Model model,HttpSession session)
    {

        Admin admin = new Admin();
        String id = UUID.randomUUID().toString();

        admin.setUsername(adminForm.getUsername());
        admin.setPassword(adminForm.getPassword());
        admin.setId(id);
        Message message = Message.builder().message("Registration Successful").type(MessageType.green).build();
        session.setAttribute("message", message);


        adminServiceImpl.save(admin);
        return "redirect:/reg";
    }
}


