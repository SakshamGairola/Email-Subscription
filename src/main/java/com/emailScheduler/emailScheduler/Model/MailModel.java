package com.emailScheduler.emailScheduler.Model;

import java.util.Map;

public class MailModel {

    private String receiverEmail;
    private String emailSubject;

    public MailModel(String receiverEmail, String emailSubject, Map<String, Object> properties) {
        this.receiverEmail = receiverEmail;
        this.emailSubject = emailSubject;
        this.properties = properties;
    }

    private Map<String, Object> properties;

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
                ", receiverEmail='" + receiverEmail + '\'' +
                ", emailSubject='" + emailSubject + '\'' +
                ", properties=" + properties +
                '}';
    }
}
