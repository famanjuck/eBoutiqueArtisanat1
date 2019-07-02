package org.sid.service;

import java.util.List;
import java.util.Optional;

import org.sid.dao.SuperviseurRepository;
import org.sid.dao.UtilisateurRepository;
import org.sid.reverse.Superviseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SuperviseurRest {
	@Autowired
	 private SuperviseurRepository superviseurRepository ;
	@Autowired
	public UtilisateurRepository utilisateurRepository;
	
	@RequestMapping (value = "/Superviseur", method=RequestMethod.GET)
	public List<Superviseur> getSuperviseur(){
		return superviseurRepository.findAll() ;
	}
	
	@RequestMapping (value = "/Superviseur/{ref}", method=RequestMethod.GET)
	public Optional<Superviseur> getSuperviseurs(@PathVariable ("ref")int ref){
		return superviseurRepository.findById(ref) ;
	}
	
	@RequestMapping (value = "/Superviseur", method=RequestMethod.POST)
	public Superviseur saveSuperviseurs(@RequestBody Superviseur superviseur){
		return superviseurRepository.save(superviseur) ;
	}
	
	@RequestMapping (value = "/Superviseur", method=RequestMethod.DELETE)
	public Boolean deleteSuperviseurs(@PathVariable ("ref") int ref){
		superviseurRepository.findById(ref);
		return true;
	}
	
	@RequestMapping(value = "/Superviseur",method=RequestMethod.PUT)
	public Superviseur updateSuperviseur(@RequestBody Superviseur superviseur){
		return superviseurRepository.saveAndFlush(superviseur) ;
	}


}
