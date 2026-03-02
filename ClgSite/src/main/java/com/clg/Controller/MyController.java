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
import org.springframework.web.bind.annotation.RequestParam;

import com.clg.Entities.Admin;
import com.clg.Entities.Colleges;
import com.clg.Entities.Feedback;
import com.clg.Entities.Streams;
import com.clg.Forms.AdminForm;
import com.clg.Forms.CollegeSearchForm;
import com.clg.Forms.FeedbackForm;
import com.clg.Helper.Message;
import com.clg.Helper.MessageType;
import com.clg.services.CollegeService;
import com.clg.services.FeedbackService;
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

    @Autowired
    private FeedbackService fbService;


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
    public String searchCollege( Model model, HttpSession session) {

        // System.out.println(searchForm);

        CollegeSearchForm searchForm = new CollegeSearchForm();
        List<Streams> streams = null;

        model.addAttribute("streams", streams);
        model.addAttribute("searchForm", searchForm);

        return "/searchPage";
     

    }


    @PostMapping("/searchProcess")
    public String searchProcess(@ModelAttribute CollegeSearchForm searchForm,Model model, HttpSession session)
    {
        try {
            // Null safety checks
            if (searchForm == null) {
                searchForm = new CollegeSearchForm();
            }
            
            if (searchForm.getPcmMarks() < 150) {
                Message message = Message.builder()
                        .message("You are not qualified to get admission, You need minimum 150 marks to in PCM to qualify")
                        .type(MessageType.red).build();
                session.setAttribute("message", message);
                return "redirect:/search";
            }

            // Safe null checks
            String stream = searchForm.getStream() != null ? searchForm.getStream().trim() : "all";
            String location = searchForm.getLocation() != null ? searchForm.getLocation().trim() : "all";
            String qouta = searchForm.getQouta() != null ? searchForm.getQouta().trim() : "";
            
            if (qouta.isEmpty()) {
                Message message = Message.builder()
                        .message("Please select a quota.")
                        .type(MessageType.red).build();
                session.setAttribute("message", message);
                return "redirect:/search";
            }

            model.addAttribute("qouta", qouta);

            float cetMarks = searchForm.getCetMarks() + 1;
            List<Streams> streams = new java.util.ArrayList<>();

            // Query logic based on stream and location
            if (stream.equalsIgnoreCase("all") && location.equalsIgnoreCase("all")) {
                streams = queryByQuotaOnly(qouta, (int)cetMarks);
            } 
            else if (!stream.equalsIgnoreCase("all") && location.equalsIgnoreCase("all")) {
                streams = queryByQuotaAndStream(qouta, (int)cetMarks, stream);
            } 
            else if (!stream.equalsIgnoreCase("all") && !location.equalsIgnoreCase("all")) {
                streams = queryByQuotaStreamLocation(qouta, searchForm.getCetMarks(), stream, location);
            }
            else if (stream.equalsIgnoreCase("all") && !location.equalsIgnoreCase("all")) {
                // Handle all streams with specific location
                streams = queryByQuotaStreamLocation(qouta, searchForm.getCetMarks(), "", location);
            }

            if (streams == null) {
                streams = new java.util.ArrayList<>();
            }
            
            if (streams.isEmpty()) {
                Message message = Message.builder()
                        .message("No colleges found matching your criteria. Please adjust your search filters.")
                        .type(MessageType.red).build();
                session.setAttribute("message", message);
            }

            model.addAttribute("streams", streams);
            model.addAttribute("searchForm", searchForm);
            return "/searchPage";
            
        } catch (Exception e) {
            System.err.println("Error in searchProcess: " + e.getMessage());
            e.printStackTrace();
            
            Message message = Message.builder()
                    .message("An error occurred while searching. Please try again.")
                    .type(MessageType.red).build();
            session.setAttribute("message", message);
            
            model.addAttribute("streams", new java.util.ArrayList<>());
            model.addAttribute("searchForm", searchForm != null ? searchForm : new CollegeSearchForm());
            return "/searchPage";
        }
    }

    // Helper method: Query by quota only (all streams, all locations)
    private List<Streams> queryByQuotaOnly(String qouta, int marks) {
        switch(qouta) {
            case "openQuotaCuttOff":
                return streamService.findByCutOffGenaral(marks);
            case "obcQuotaCuttOff":
                return streamService.findByCutOffObc(marks);
            case "scQuotaCuttOff":
                return streamService.findByCutOffSc(marks);
            case "vjQuotaCuttOff":
                return streamService.findByCutOffVj(marks);
            case "nt1QuotaCuttOff":
                return streamService.findByCutOffNt1(marks);
            case "nt2QuotaCuttOff":
                return streamService.findByCutOffNt2(marks);
            case "nt3QuotaCuttOff":
                return streamService.findByCutOffNt3(marks);
            case "tfwsQuotaCuttOff":
                return streamService.findByCutOffTfws(marks);
            default:
                return new java.util.ArrayList<>();
        }
    }

    // Helper method: Query by quota and stream
    private List<Streams> queryByQuotaAndStream(String qouta, int marks, String stream) {
        switch(qouta) {
            case "openQuotaCuttOff":
                return streamService.findByCutOffGenaralStreams(marks, stream);
            case "obcQuotaCuttOff":
                return streamService.findByCutOffObcStreams(marks, stream);
            case "scQuotaCuttOff":
                return streamService.findByCutOffScStreams(marks, stream);
            case "vjQuotaCuttOff":
                return streamService.findByCutOffVjStreams(marks, stream);
            case "nt1QuotaCuttOff":
                return streamService.findByCutOffNt1Streams(marks, stream);
            case "nt2QuotaCuttOff":
                return streamService.findByCutOffNt2Streams(marks, stream);
            case "nt3QuotaCuttOff":
                return streamService.findByCutOffNt3Streams(marks, stream);
            case "tfwsQuotaCuttOff":
                return streamService.findByCutOffTfwsStreams(marks, stream);
            default:
                return new java.util.ArrayList<>();
        }
    }

    // Helper method: Query by quota, stream, and location
    private List<Streams> queryByQuotaStreamLocation(String qouta, float marks, String stream, String location) {
        switch(qouta) {
            case "openQuotaCuttOff":
                return streamService.findByCuttOffGeneralLocation(marks, stream, location);
            case "scQuotaCuttOff":
                return streamService.findByCuttOffScLocation(marks, stream, location);
            case "vjQuotaCuttOff":
                return streamService.findByCuttOffVjLocation(marks, stream, location);
            case "nt1QuotaCuttOff":
                return streamService.findByCuttOffNt1Location(marks, stream, location);
            case "nt2QuotaCuttOff":
                return streamService.findByCuttOffNt2Location(marks, stream, location);
            case "nt3QuotaCuttOff":
                return streamService.findByCuttOffNt2Location(marks, stream, location);
            case "obcQuotaCuttOff":
                return streamService.findByCuttOffObcLocation(marks, stream, location);
            case "tfwsQuotaCuttOff":
                return streamService.findByCuttOffTfwsLocation(marks, stream, location);
            default:
                return new java.util.ArrayList<>();
        }
    }

    @GetMapping("/feedback")
    public String feedBack(Model model)
    {
        return "feedBack";
    }
    @PostMapping("/feedback")
    public String feedBackProcess(@RequestParam("rating") int rating, 
                             @RequestParam("feedback") String feedback ,Model model)
    {
        Feedback fb = new Feedback();
        fb.setContent(feedback);
        fb.setRating(rating);
        fbService.save(fb);
        model.addAttribute("feedback", fb);
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


