package com.emailScheduler.emailScheduler.Controller;

import com.emailScheduler.emailScheduler.Model.MailModel;
import com.emailScheduler.emailScheduler.Repository.MailModelRepository;
import com.emailScheduler.emailScheduler.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class MailController {

    @Autowired
    MailService mailService;

    @Autowired
    MailModelRepository mailModelRepository;

    @GetMapping("getEmail")
    public ModelAndView getEmail(MailModel email){
        ModelAndView mav = new ModelAndView("getEmail");
        mav.addObject("email", email);

        return mav;
    }

    @GetMapping("showResult")
    public ModelAndView showEmail(@ModelAttribute MailModel email){
        ModelAndView mav = new ModelAndView("show");
        mav.addObject("email", email);
        mailService.sendMail(email.getUserEmail(), email.getUserName(),"Hello");
        return mav;
    }
    @GetMapping("")
    public void sendMails(){
        List<MailModel> allMails = mailModelRepository.findAll();
        for(MailModel eachMail : allMails){
            String msg = "Hello " + eachMail.getUserName();
            mailService.sendMail(eachMail.getUserEmail(), eachMail.getUserName(), msg);
        }
    }
}
