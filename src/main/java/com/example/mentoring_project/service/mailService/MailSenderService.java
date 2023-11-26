package com.example.mentoring_project.service.mailService;

public interface MailSenderService {
    boolean sendMailByAddMember(String mailTo) throws Exception;

    String getConfirmKey();
}
