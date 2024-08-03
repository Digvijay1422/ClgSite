package com.clg.Controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clg.Entities.Colleges;
import com.clg.Entities.Streams;
import com.clg.Forms.CollegeForm;
import com.clg.Forms.StreamForm;
import com.clg.Helper.Message;
import com.clg.Helper.MessageType;
import com.clg.services.CollegeService;
import com.clg.services.ImageService;
import com.clg.services.StreamService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private StreamService streamService;

     @Autowired
     private ImageService imageService;

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

    @PostMapping("/addClg")
    public String processClg ( @ModelAttribute CollegeForm form, HttpSession session)
    {

        // if(bindingResult.hasErrors()){
        //     System.out.println("has error");
        //     return "/admin/addClg";
		// }
        // process. 
        System.out.println(form);

        String fileName = UUID.randomUUID().toString();

        Colleges colleges = new Colleges();

        // colleges.setClgId(form.getClgId());
        colleges.setClgName(form.getClgName());
        colleges.setAddress(form.getAddress());
        colleges.setClgContact(form.getClgContact());
        colleges.setAutonomous(form.isAutonomous());
        colleges.setClgEmail(form.getClgEmail());
        colleges.setFees(form.getFees());
        colleges.setMedianSalary(form.getMedianSalary());
        colleges.setLink(form.getLink());
        colleges.setDescription(form.getDescription());
        colleges.setClgLocation(form.getClgLocation());
        colleges.setRatings(form.getRatings());
        colleges.setStreamsAvail(form.getStreamsAvail());

             String fileUrl = imageService.uploadImage(form.getPicture(),fileName);
             colleges.setPicture(fileUrl);
        

        Message message = Message.builder().message("Registration Successful").type(MessageType.green).build();
        session.setAttribute("message", message);


        collegeService.save(colleges);

        

        return "redirect:/admin/addClg";
    }

    @GetMapping("/addStream")
    public String addStream(Model model)
    {
       StreamForm  streamsForm = new StreamForm();
       model.addAttribute("form", streamsForm);
       return "/admin/addStream";
    }
   

    @PostMapping("/addStream")
    public String addStream(@ModelAttribute StreamForm form, HttpSession session)
    {
        // System.out.println(form);

        String id = form.getCollegeId();
        Colleges colleges = collegeService.getCollegesById(id);

        Streams streams = new Streams();
        streams.setStreamName(form.getStreamName());
        streams.setStreamDuration(form.getStreamDuration());
        streams.setNt1QuotaCuttOff(form.getNt1QuotaCuttOff());
        streams.setNt2QuotaCuttOff(form.getNt2QuotaCuttOff());
        streams.setNt3QuotaCuttOff(form.getNt3QuotaCuttOff());
        streams.setOpenQuotaCuttOff(form.getOpenQuotaCuttOff());
        streams.setObcQuotaCuttOff(form.getObcQuotaCuttOff());
        streams.setScQuotaCuttOff(form.getScQuotaCuttOff());
        streams.setTfwsQuotaCuttOff(form.getTfwsQuotaCuttOff());
        streams.setColleges(colleges);
        streamService.save(streams);

        Message message = Message.builder().message("Registration Successful").type(MessageType.green).build();
        session.setAttribute("message", message);

        return "redirect:/admin/addStream";
    }
}
