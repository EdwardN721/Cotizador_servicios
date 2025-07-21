package aurora.servicios.servicios_backend.services.impl.email;

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
import java.util.List;

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
            List<String> servicio = email.servicios();
            String mensaje = email.mensaje();

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String formateada = now.format(formatter);

            String mensajeCompleto = generarMensaje(nombre, servicio, correo, mensaje);
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

    public String generarMensaje(String nombre, List<String> serviciosArray, String correo, String notasAdicionales) {
        String servicios = String.join(", ", serviciosArray);

        return "Hola, buen día.<br>" +
                "Mi nombre es <strong>" + nombre + "</strong> y estoy interesad@ en los siguientes servicios: <strong>" + servicios + "</strong>.<br>" +
                "Puedes contactarme a través de mi correo electrónico: <strong>" + correo + "</strong><br>" +
                "<em>Notas adicionales:</em> " + notasAdicionales + "<br>" +
                "Quedo atent@ a tu respuesta. Muchas gracias y saludos cordiales.";
    }


}
