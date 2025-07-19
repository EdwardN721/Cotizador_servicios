package aurora.servicios.servicios_backend.services.interfaces.email;

import aurora.servicios.servicios_backend.dtos.EmailDto;
import jakarta.mail.MessagingException;

public interface EmailService {
    String enviarCorreo(EmailDto email) throws MessagingException;
}
