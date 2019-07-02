package org.sid.service;

import java.util.List;
import java.util.Optional;

import org.sid.dao.UtilisateurRepository;
import org.sid.reverse.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilisateurRest {
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	
	@RequestMapping(value = "/Utilisateur",method=RequestMethod.GET)
	public List<Utilisateur> getPersonne(){
		return utilisateurRepository.findAll();
	}
	
	@RequestMapping(value = "/Utilisateur/{ref}",method=RequestMethod.GET)
	public Optional<Utilisateur> getPersonne(@PathVariable("ref") int ref){
		return utilisateurRepository.findById(ref) ;
	}
	
	@RequestMapping(value = "/Utilisateur",method=RequestMethod.POST)
	public Utilisateur savePersonne(@RequestBody Utilisateur utilisateur){
		return utilisateurRepository.save(utilisateur) ;
	}
	
	@RequestMapping(value = "/Utilisateur/{ref}",method=RequestMethod.DELETE)
	public Boolean deletePersonne(@PathVariable("ref") int ref){
		utilisateurRepository.deleteById(ref);
		return true ;
	}
	
	@RequestMapping(value = "/Utilisateur",method=RequestMethod.PUT)
	public Utilisateur updatePersonne(@RequestBody Utilisateur utilisateur){
		return utilisateurRepository.saveAndFlush(utilisateur) ;
	}
	

}
