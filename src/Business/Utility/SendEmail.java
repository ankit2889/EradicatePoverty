package business.utility;


import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendEmail {
 
    
    
    
	public static boolean SendEmail(String rec, String sub,String newUsername,String userPassword)
        {
            String mailmessage;
            mailmessage = "Welcome to Eradicate Poverty \nYour username:"+newUsername+"\n Password:"+userPassword+"\n\n Please log in and reset your password.\n Thanks for joining Eradicate Poverty and helping us in our mission to  eradicate poverty. \n\n Best regards,\nEradicate Poverty ";
            String mailBody=mailmessage;
            String mailRecepient=rec;
            String mailSubject=sub;
 
		final String username = "kotharia439@gmail.com";
                //Change Password
		final String password = "ankit@2889";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() 
                  {
                                                @Override
                        			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("Amazon"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(mailRecepient));
			message.setSubject(mailSubject);
			message.setText(mailBody);
 
			Transport.send(message);
 
			return true;
 
		} catch (MessagingException e)
                {
                        return false;
		}
	}
}