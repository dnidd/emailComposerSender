import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Entry point.
 * Class sending email via SMTP.
 */
public class Mail {

    // Run program:
    // java -jar mailSenderTerminal.jar <host> <port> <username> <password> <recipient> <subject> <message>

    public static void main(String[] args) throws MessagingException {

        String host = args[0];          // smtp.gmail.com
        String port = args[1];          // 587
        String username = args[2];      // user
        String password = args[3];      // Temporary Google app password
        String recipient = args[4];     // to
        String subject = args[5];       // subject
        String content = args[6];       // content

        // Configure SMTP (Simple Mail Transfer Protocol).
        // TLS (Transport Layer Security) - communication protection (encryption).
        Properties prop = new Properties();
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", port);
        // Login to server.
        prop.put("mail.smtp.auth", "true");
        // Encrypt SMPT connection.
        prop.put("mail.smtp.starttls.enable", "true");


        // Create session and authenticate to Gmail.
        // Authenticate using args[2] and args[3].
        Session session = Session.getInstance(prop,
                new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        } );


        // Create and send email.
        try {
            // Creating email.
            Message message = new MimeMessage(session);
            // Sender of email.
            message.setFrom(new InternetAddress(username));
            // Recipients of email. parse() converts to an address JavaMail API can handle.
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(recipient)
            );
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);
            System.out.println("Mail Sent Successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }

}
