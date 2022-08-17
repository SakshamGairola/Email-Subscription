package com.emailScheduler.emailScheduler.Model;

import java.util.Map;

public class MailModel {

    private String senderEmail;
    private String senderName;
    private String receiverEmail;
    private String emailSubject;
    private Map<String, Object> properties;

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "MailModel{" +
                "senderEmail='" + senderEmail + '\'' +
                ", senderName='" + senderName + '\'' +
                ", receiverEmail='" + receiverEmail + '\'' +
                ", emailSubject='" + emailSubject + '\'' +
                ", properties=" + properties +
                '}';
    }
}
