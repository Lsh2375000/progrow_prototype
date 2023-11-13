package com.example.mentoring_project.service;

public interface MailSenderService {
    boolean sendMailByAddMember(String mailTo) throws Exception;

    String getConfirmKey();
}
