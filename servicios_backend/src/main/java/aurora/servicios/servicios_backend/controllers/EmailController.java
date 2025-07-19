package aurora.servicios.servicios_backend.controllers;

import aurora.servicios.servicios_backend.dtos.EmailDto;
import aurora.servicios.servicios_backend.services.interfaces.email.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/correo")
public class EmailController {
    EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<String> enviarEmail(@RequestBody EmailDto emailDto) throws MessagingException {
        emailService.enviarCorreo(emailDto);
        return new  ResponseEntity<>("Correo enviado correctamente", HttpStatus.OK);
    }
}
