package com.indianbank.service;

import com.indianbank.dto.EmailDetails;

public interface EmailService {
    public void sendEmailAlert(EmailDetails emailDetails);
}
