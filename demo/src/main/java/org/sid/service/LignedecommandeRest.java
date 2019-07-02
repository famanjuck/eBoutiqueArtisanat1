package org.sid.service;

import java.util.List;
import java.util.Optional;

import org.sid.dao.LignedecommandeRepository;
import org.sid.reverse.Lignedecommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LignedecommandeRest {
	@Autowired
	private LignedecommandeRepository LignedecommandeRepository;
	
	@RequestMapping(value ="/Lignedecommande",method=RequestMethod.GET)
	public List<Lignedecommande> getCommande(){
		return LignedecommandeRepository.findAll();
	}
	
	@RequestMapping(value ="/Lignedecommande/{ref}",method=RequestMethod.GET)
	public Optional<Lignedecommande> getCommande(@PathVariable("ref") int ref){
		return LignedecommandeRepository.findById(ref) ;
	}
	
	@RequestMapping(value ="/Lignedecommande",method=RequestMethod.POST)
	public Lignedecommande saveProduit(@RequestBody Lignedecommande Lignedecommande){
		return LignedecommandeRepository.save(Lignedecommande) ;
	}
	
	@RequestMapping(value ="/Lignedecommande",method=RequestMethod.DELETE)
	public Boolean deleteCommande(@PathVariable("ref") int ref){
		LignedecommandeRepository.deleteById(ref);
		return true ;
	}
	
	@RequestMapping(value ="/Lignedecommande",method=RequestMethod.PUT)
	public Lignedecommande updatecommande(@RequestBody Lignedecommande Lignedecommande){
		return LignedecommandeRepository.saveAndFlush(Lignedecommande) ;
	}

}
