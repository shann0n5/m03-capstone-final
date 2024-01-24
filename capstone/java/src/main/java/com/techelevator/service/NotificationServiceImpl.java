package com.techelevator.service;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class NotificationServiceImpl implements NotificationService{
    private final String SENDGRID_API_KEY = "---INSERT_API_KEY_HERE---";
    public void sendEmail() {
    Email from = new Email("userapplying@sampleemail.com");
    String subject = "Your application has been sent!";
    Email to = new Email("propertyownerreplying@sampleemail.com");
    Content content = new Content("text/plain", "Your application has been sent!");
    Mail mail = new Mail(from, subject, to, content);

    SendGrid sg = new SendGrid(SENDGRID_API_KEY);
    Request request = new Request();
    try {
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());
        Response response = sg.api(request);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        System.out.println(response.getHeaders());
    } catch (IOException ex) {
        //throw ex;
     }
    }
}
