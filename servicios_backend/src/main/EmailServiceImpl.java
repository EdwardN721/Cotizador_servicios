package aurora.servicios.servicios_backend.services.interfaces.command;

import aurora.servicios.servicios_backend.dtos.EmailDto;
import aurora.servicios.servicios_backend.services.interfaces.email.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class EmailServiceImpl implements EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);
    private final JavaMailSender mailSender;
    private final TemplateEngine template;

    public EmailServiceImpl(JavaMailSender javaMailSender, TemplateEngine templateEngine){
        this.mailSender = javaMailSender;
        this.template = templateEngine;
    }

    @Override
    @Retryable(value = {MessagingException.class}, maxAttempts = 3)
    public String enviarCorreo(EmailDto email) throws MessagingException {
        try{
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(email.destinatario());
            helper.setSubject(email.asunto());

            String nombre = email.nombre();
            String correo = email.correo();
            String servicio = email.servicios();
            String mensaje = email.mensaje();

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String formateada = now.format(formatter);

            String mensajeCompleto = String.format("Hola buen día, soy %s, estoy interesad@ por los servicios ofertados de: %s. <br> Mi dirección de correo eléctronico es: %s <br> *Adicional: %s. <br> Espero atentamente tu respuesta. Gracias, saludos cordiales.",
                    nombre, correo, servicio, mensaje);
            String fecha = "Mensaje enviado el: " + formateada;

            Context context = new Context();
            context.setVariable("mensajeCompleto", mensajeCompleto);
            context.setVariable("fecha", fecha);

            String contentHtml = template.process("email", context);
            helper.setText(contentHtml, true);

            mailSender.send(message);
            return "Correo enviado éxitosamente!.";
        } catch (MessagingException ex) {
            logger.error("Error al enviar correo a {}: {}", email.destinatario(), ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            logger.error("Error inesperado al enviar correo a {}: {}", email.destinatario(), ex.getMessage());
            return "Error inesperado: " + ex.getMessage();
        }
    }
}
