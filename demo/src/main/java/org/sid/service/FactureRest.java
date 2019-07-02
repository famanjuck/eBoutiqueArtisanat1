package org.sid.service;

import java.util.List;
import java.util.Optional;


import org.sid.dao.FactureRepository;
import org.sid.reverse.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactureRest {
	@Autowired
	private FactureRepository factureRepository;


	
	@RequestMapping(value ="/Facture",method=RequestMethod.GET)
	public List<Facture> getReçu(){
		return factureRepository.findAll();
	}
	
	@RequestMapping(value ="/Facture/{ref}",method=RequestMethod.GET)
	public Optional<Facture> getReçu(@PathVariable("ref") int ref){
		return factureRepository.findById(ref) ;
	}
	
	@RequestMapping(value ="/Facture",method=RequestMethod.POST)
	public Facture saveReçu(@RequestBody Facture facture){
		return factureRepository.save(facture) ;
	}
	
	@RequestMapping(value ="/Facture",method=RequestMethod.DELETE)
	public Boolean deleteReçu(@PathVariable("ref") int ref){
		factureRepository.deleteById(ref);
		return true ;
	}
	
	@RequestMapping(value ="/Facture",method=RequestMethod.PUT)
	public Facture updateReçu(@RequestBody Facture facture){
		return factureRepository.saveAndFlush(facture) ;
	}


}
