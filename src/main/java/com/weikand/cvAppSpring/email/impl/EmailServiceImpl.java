package com.weikand.cvAppSpring.email.impl;

import com.weikand.cvAppSpring.dto.EmailDTO;
import com.weikand.cvAppSpring.dto.EmailResponseDTO;
import com.weikand.cvAppSpring.email.interfaces.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);
    @Autowired
    private JavaMailSender javaMailSender;

    public EmailResponseDTO sendEmail(EmailDTO emailDTO) {
        logger.info("-> SendEmail - EmailServiceImpl");
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(emailDTO.getReceiver());
        msg.setSubject(emailDTO.getSubject());
        msg.setText(emailDTO.getMessage());

        try {
            javaMailSender.send(msg);
            logger.info("<- SendEmail - EmailServiceImpl");
            return new EmailResponseDTO("Mail Sended", "200");
        } catch (Exception e) {
            return new EmailResponseDTO("Mail Error", "500");
        }
    }

}
