package com.emailScheduler.emailScheduler.Controller;

import com.emailScheduler.emailScheduler.Model.UserModel;
import com.emailScheduler.emailScheduler.Repository.MailModelRepository;
import com.emailScheduler.emailScheduler.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
public class MailController {

    @Autowired
    MailService mailService;

    @Autowired
    MailModelRepository mailModelRepository;

    @GetMapping("getEmail")
    public ModelAndView getEmail(UserModel userModel){
        ModelAndView mav = new ModelAndView("getEmail");
        mav.addObject("user", userModel);
        return mav;
    }

    @GetMapping("showResult")
    public ModelAndView showEmail(@ModelAttribute UserModel userModel){
        ModelAndView mav = new ModelAndView("show");
        mav.addObject("user", userModel);
        mailService.sendMail(userModel.getUserEmail(), userModel.getUserFirstName(),"Hello");
        return mav;
    }

    @GetMapping("unsubscribe/{email}")
    public ModelAndView unsubscribe(@PathVariable String email){
        ModelAndView mav = new ModelAndView("unsubscribe");
        mailModelRepository.deleteById(email);
        return mav;
    }

    //@GetMapping("")
    //@Scheduled(cron="0 0 10 */ * * *")
    /*public void sendMails(){
        List<UserModel> allMails = mailModelRepository.findAll();
        for(UserModel eachMail : allMails){
            String msg = "Hello " + eachMail.getUserFirstName();
            try {
                mailService.sendMail2(eachMail.getUserEmail(), eachMail.getUserFirstName(), msg);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
    }*/
}
