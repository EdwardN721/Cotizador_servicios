package aurora.servicios.servicios_backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@PropertySource("classpath:email.properties")
public class EmailConfig {
    @Value("${email.username}")
    private String email;

    @Value("${email.password}")
    private String password;

    private Properties getMailProperties(){
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com"); // Gmail verifica el certificado SSL del servidor.
        properties.put("mail.smtp.connectiontimeout", "5000"); // milisegundos Tiempo máximo para establecer conexión con el servidor SMTP.
        properties.put("mail.smtp.timeout", "5000"); // Tiempo límite para esperar una respuesta del servidor (después de conectarse).
        properties.put("mail.smtp.writetimeout", "5000"); // Tiempo máximo para enviar datos al servidor SMTP

        return properties;
    }

    @Bean
    public JavaMailSender javaMailSender(){
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setJavaMailProperties(getMailProperties());
    mailSender.setUsername(email);
    mailSender.setPassword(password);
    return mailSender;
    }

    @Bean
    public ResourceLoader resourceLoader(){
        return new DefaultResourceLoader();
    }

}
