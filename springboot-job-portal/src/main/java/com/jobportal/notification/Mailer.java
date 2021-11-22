package com.jobportal.notification;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class Mailer {
//	
	 public void send(String from,String password,String to,String sub,String msg){  
         //Get properties object    
         Properties props = new Properties();    
         props.put("mail.smtp.host", "127.0.0.1");    
//         props.put("mail.smtp.socketFactory.port", "1025");    
         props.put("mail.smtp.socketFactory.class",    
                   "javax.net.ssl.SSLSocketFactory");    
         props.put("mail.smtp.auth", "false");    
         props.put("mail.smtp.port", "1025");    
         //get Session   
//         Session session = Session.getDefaultInstance(props,    
//          new javax.mail.Authenticator() {    
//          protected PasswordAuthentication getPasswordAuthentication() {    
//          return new PasswordAuthentication(from,password);  
//          }    
//         });    
         
         Session session = Session.getInstance(props,
        	      new javax.mail.Authenticator() {
        	        protected PasswordAuthentication getPasswordAuthentication() {
        	            return new PasswordAuthentication(from, password);
        	        }
        	      });
         
         //compose message    
         try {    
          MimeMessage message = new MimeMessage(session);    
          message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
          message.setSubject(sub);    
          message.setText(msg);    
          //send message  
          Transport.send(message);    
          System.out.println("message sent successfully");    
         } catch (MessagingException e) {throw new RuntimeException(e);}    
   }  
	 
	 public void sendActivationLink(String from,String password,String to,String sub,String msg){  
         //Get properties object    
         Properties props = new Properties();    
         props.put("mail.smtp.host", "127.0.0.1");    
//         props.put("mail.smtp.socketFactory.port", "1025");    
         props.put("mail.smtp.socketFactory.class",    
                   "javax.net.ssl.SSLSocketFactory");    
         props.put("mail.smtp.auth", "false");    
         props.put("mail.smtp.port", "1025");    
         //get Session   
//         Session session = Session.getDefaultInstance(props,    
//          new javax.mail.Authenticator() {    
//          protected PasswordAuthentication getPasswordAuthentication() {    
//          return new PasswordAuthentication(from,password);  
//          }    
//         });    
         
         
         Session session = Session.getInstance(props,
        	      new javax.mail.Authenticator() {
        	        protected PasswordAuthentication getPasswordAuthentication() {
        	            return new PasswordAuthentication(from, password);
        	        }
        	      });
         
         
         //compose message    
         try {    
          MimeMessage message = new MimeMessage(session);    
          message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
          message.setSubject(sub);    
          message.setText(msg);    
          //send message  
          Transport.send(message);    
          System.out.println("message sent successfully");    
         } catch (MessagingException e) {throw new RuntimeException(e);}    
   }  
	
	
}
