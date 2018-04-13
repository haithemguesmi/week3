package org.sid.web;

import java.util.List;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConatactRestService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	
	//RequestMapping :pour accéder a cette methode'list' via une requette http 
	//method : la methode de ce cette requette "get ou put ou post"
	
	@RequestMapping(value="/contacts",method=RequestMethod.GET)
	public List<Contact> getContact(){
		return contactRepository.findAll();
	}
	
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.GET)
	public Contact getContact(@PathVariable Long id){
		return contactRepository.findOne(id);
	}
	
	@RequestMapping(value="/contacts",method=RequestMethod.POST)
	public Contact save(@RequestBody Contact c ){
		return contactRepository.save(c);
	}
	
	@RequestMapping(value="/contacts/{c}",method=RequestMethod.DELETE)
	public boolean supprime(@PathVariable Long c ){
		 contactRepository.delete(c);
		 return true ;
	}
	
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.PUT)
	public Contact modifer(@PathVariable Long id ,@RequestBody Contact c ){
		c.setId(id);
		return contactRepository.save(c);
	}
	
	@RequestMapping(value="/cherchercontacts",method=RequestMethod.GET)
	public Page <Contact> chercher(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return contactRepository.chercher("%"+mc+"%",new PageRequest(page,size));
	}
	
}
