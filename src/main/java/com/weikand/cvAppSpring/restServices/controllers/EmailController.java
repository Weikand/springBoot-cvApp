package com.weikand.cvAppSpring.restServices.controllers;

import com.weikand.cvAppSpring.dto.EmailDTO;
import com.weikand.cvAppSpring.dto.EmailResponseDTO;
import com.weikand.cvAppSpring.email.interfaces.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    private EmailService emailService;

    @PostMapping(path = "sendEmail",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public EmailResponseDTO sendEmail(@RequestBody EmailDTO emailDTO) {
        logger.info("Sending mail");
        return this.emailService.sendEmail(emailDTO);
    }

}
