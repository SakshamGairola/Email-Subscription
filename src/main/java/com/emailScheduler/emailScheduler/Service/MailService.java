package com.emailScheduler.emailScheduler.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    //Simple mail sender method
    public void sendMail(String to, String sub, String msg){
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("Saksham Gairola");
        mailMessage.setTo(to);
        mailMessage.setSubject(sub);
        mailMessage.setText(msg);

        javaMailSender.send(mailMessage);
    }

    //HTML mail sender method
    public void sendMail2 (String to, String sub, String msg) throws MessagingException, UnsupportedEncodingException {

        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage);

        String unsubscribeURL= "http://localhost:8080/unsubscribe/" + to;
        String html = "<a href= \"" + unsubscribeURL +"\">unsubscribe</a>";

        messageHelper.setFrom("saksham.gairola00@gmail.com", "Saksham Gairola");
        messageHelper.setTo(to);
        messageHelper.setSubject(sub);
        messageHelper.setText(html, true);

        javaMailSender.send(mailMessage);
    }
}
