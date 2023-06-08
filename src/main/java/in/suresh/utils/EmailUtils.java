package in.suresh.utils;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
@Component
public class EmailUtils {

	
	@Autowired
	private JavaMailSender mailSender;

	public boolean sendEmail(String to, String subject, String body, File file) {
		System.out.println("Entered into EmailUtils :: sendEmail() method");

		boolean isSent = false;

		try {
			MimeMessage createMimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(createMimeMessage,true);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body, true);
			helper.addAttachment("Plan_Info", file);
			mailSender.send(createMimeMessage);
			
			/*helper.setText("<b>Dear friend</b>,<br><i>Please find the book attached.</i>", true);
			FileSystemResource file = new FileSystemResource(new File("Book.pdf"));
			helper.addAttachment("FreelanceSuccess.pdf", file);*/

			isSent = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Exit from EmailUtils :: sendEmail() method");

		return true;
	}
}
