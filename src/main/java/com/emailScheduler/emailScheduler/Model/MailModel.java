package com.emailScheduler.emailScheduler.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("subcribedUsers")
public class MailModel {

    @Id
    private String userEmail;
    private String userName;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "MailModel{" +
                "userEmail='" + userEmail + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
