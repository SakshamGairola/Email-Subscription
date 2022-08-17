package com.emailScheduler.emailScheduler.Controller;

import com.emailScheduler.emailScheduler.Model.UserModel;
import com.emailScheduler.emailScheduler.Repository.MailModelRepository;
import com.emailScheduler.emailScheduler.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@RestController
public class TestingController {

    @Autowired
    MailService mailService;

    @Autowired
    MailModelRepository mailModelRepository;

    //make it ModelAndView type to test on browser and not send emails
   /* @GetMapping("test")
    public void test(UserModel email){
        email.setUserEmail("saksham.gairola06@gmail.com");
        email.setUserFirstName("Saksham");
        email.setUserLastName("Gairola");
        String msg = "Hello Saksham";
        try {
            try {
                mailService.sendMail2(email.getUserEmail(), email.getUserFirstName(),msg);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        System.out.print("Sent");
    }*/
}
