package com.emailScheduler.emailScheduler.Controller;

import com.emailScheduler.emailScheduler.Model.MailModel;
import com.emailScheduler.emailScheduler.Model.UserModel;
import com.emailScheduler.emailScheduler.Repository.UserModelRepository;
import com.emailScheduler.emailScheduler.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestingController {

    @Autowired
    MailService mailService;

    //For CURD ops
    @Autowired
    UserModelRepository userModelRepository;

    @GetMapping("")
    public void test0(){

        System.out.println(userModelRepository.existsById("someString"));
        if(userModelRepository.existsById("someString")){
            System.out.println("empty");
        }else{
            System.out.println("NOt");}
    }

    //make it ModelAndView type to test on browser and not send emails
    @GetMapping("test")
    public ModelAndView test(UserModel userModel) {
        ModelAndView mav = new ModelAndView("getEmail");
        mav.addObject("user",userModel);
        return mav;
    }

    @GetMapping("test2")
    public ModelAndView test2(@ModelAttribute UserModel userModel, MailModel mailModel) throws MessagingException, UnsupportedEncodingException {
        ModelAndView mav = new ModelAndView("confirmationEmailTemplate");
        mav.addObject("user",userModel);

        Map<String, Object> map = new HashMap<>();
        map.put("userFirstName", userModel.getUserFirstName());
        map.put("userLastName", userModel.getUserLastName());
        map.put("userEmail", userModel.getUserEmail());

        map.put("senderEmail", "saksham.gairola00");
        map.put("senderName", "Saksham");
        map.put("receiverEmail", userModel.getUserEmail());
        map.put("emailSubject", "Test1");
        mailModel.setProperties(map);

        mailModel.setReceiverEmail(userModel.getUserEmail());
        mailModel.setEmailSubject("mailing HTML template");

        System.out.println(userModel);
        System.out.println(mailModel);

        mailService.sendHTMLMail(mailModel, "getEmail");
        return mav;
    }

    @GetMapping("unsubscribeTest/{email}")
    public ModelAndView unsubscribe(@PathVariable String email){
        ModelAndView mav = new ModelAndView("unsubscribe");
        return mav;
    }
}
