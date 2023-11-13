package com.example.mentoring_project.service;

public interface MailSendService {
    boolean sendMailByAddMember(String mailTo) throws Exception;
    String getConfirmKey();
}
