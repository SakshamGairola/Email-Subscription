package com.emailScheduler.emailScheduler.Service;

import com.emailScheduler.emailScheduler.Model.MailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    @Value("${spring.mail.username}")
    String senderEmail;

    final String SenderName= "Saksham Gairola";

    //Simple mail sender method
    public void sendSimpleMail(String to, String sub, String msg){
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("Saksham Gairola");
        mailMessage.setTo(to);
        mailMessage.setSubject(sub);
        mailMessage.setText(msg);

        javaMailSender.send(mailMessage);
    }

    //HTML mail sender method
    public void sendHTMLMail (MailModel mailModel, String template) throws MessagingException, UnsupportedEncodingException {

        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        //MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage);
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        //messageHelper.addAttachment("attachmentFileName", new ClassPathResource("don't know for now"));

        Context context = new Context();
        context.setVariables(mailModel.getProperties());

        String html = springTemplateEngine.process(template, context);

        messageHelper.setFrom(senderEmail, SenderName);
        messageHelper.setTo(mailModel.getReceiverEmail());
        messageHelper.setSubject(mailModel.getEmailSubject());
        messageHelper.setText(html, true);

        javaMailSender.send(mailMessage);
    }
}
