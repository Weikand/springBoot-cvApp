package com.weikand.cvAppSpring.email.interfaces;

import com.weikand.cvAppSpring.dto.EmailDTO;
import com.weikand.cvAppSpring.dto.EmailResponseDTO;

public interface EmailService {
    /**
     * Send email to a recipient
     * @param emailDTO contains receiver, subject and message
     * @return EmailResponseDTO with status and message
     */
    EmailResponseDTO sendEmail(EmailDTO emailDTO);
}
