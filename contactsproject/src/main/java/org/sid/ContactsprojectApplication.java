package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactsprojectApplication implements CommandLineRunner{

	@Autowired
	private ContactRepository contactRepository;

	public static void main(String[] args) {
		SpringApplication.run(ContactsprojectApplication.class, args);
	}
	
	//String nom, String prenom, Date datenaissance, String email, Long tel, String photo
	
	@Override
	public void run(String... args) throws Exception {
		
			
		DateFormat df =new SimpleDateFormat("dd/MM/yyy");
		contactRepository.save(new Contact("haithem", "guesmi", df.parse("12/05/1992"),"haithem@talan.tn", 27811568,"haith.jpg"));
		contactRepository.save(new Contact("ahmed", "salah", df.parse("06/05/1996"),"ahmed@talan.tn", 45858,"ah.jpg"));
		contactRepository.save(new Contact("samir", "dridi", df.parse("08/05/1993"),"samir@talan.tn", 48758585,"ssa.jpg"));
		contactRepository.save(new Contact("ridha", "yahyaoui", df.parse("09/05/1998"),"ridha@talan.tn", 57855852,"ri.jpg"));
		contactRepository.save(new Contact("rim", "mejri", df.parse("09/05/1991"),"rim@talan.tn", 4512572,"rim.jpg"));
		contactRepository.findAll().forEach(c->{System.out.println(c.getNom());});
	
	}
	
}
