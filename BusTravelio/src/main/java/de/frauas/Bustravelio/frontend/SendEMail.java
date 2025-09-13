/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.frauas.Bustravelio.frontend;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEMail {
    public void sendMail(String recepient, String oldinfo, String newinfo,String e_subject,String filename) throws Exception {
        System.out.println("preparing to send E-mail");
    Properties properties = new Properties();
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.port", "587");
    
    properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
    properties.put("mail.smpt.ssl.trust", "smpt.gmail.com");
    properties.put("mail.smpt.ssl.trust", "smpt.gmx.de");
    
    String myEmail = "travelio.official23@gmail.com";
    String password = "lmeadqkybwhdkqln";
    
    
    Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(myEmail, password);
        }
    });
    /*
    * new message Deklaration 
    * variable Defenition information and same variable of a Method @sendMail 
    * @ send a message
    */
    Message message = prepareMessage(session, myEmail, recepient,oldinfo, newinfo,e_subject,filename);
    Transport.send(message);
    System.out.println("Message sent successfully");
    }
//    Filename
    private Message prepareMessage(Session session, String myEmail, String recepient,String oldinfo, String newinfo,String e_subject, String filename) {
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(myEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(e_subject);
            BodyPart Body1 = new MimeBodyPart();
            Body1.setText(oldinfo +newinfo );
            if(filename!=null) {
                MimeBodyPart Body2 = new MimeBodyPart();
                FileDataSource source = new FileDataSource(filename);
                Body2.setDataHandler(new DataHandler(source));
                Body2.setFileName(filename);
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(Body1);
                multipart.addBodyPart(Body2);
                message.setContent(multipart );
            }
            else {
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(Body1);
                message.setContent(multipart );
            }
            return message;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
