package org.sid.service;

import java.util.List;
import java.util.Optional;

import org.sid.dao.BoutiqueRepository;
import org.sid.reverse.Boutique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoutiqueRest {
	@Autowired
	 private BoutiqueRepository boutiqueRepository ;
	
	@RequestMapping (value = "/Boutique", method=RequestMethod.GET)
	public List<Boutique> getBoutique(){
		return boutiqueRepository.findAll() ;
	} 
	
	@RequestMapping (value = "/Boutique/{ref}", method=RequestMethod.GET)
	public Optional<Boutique> getBoutique(@PathVariable ("ref") int ref){
		return boutiqueRepository.findById(ref) ;
	} 
	
	@RequestMapping (value = "/Boutique", method=RequestMethod.POST)
	public Boutique saveBoutique(@RequestBody Boutique boutique){
		return boutiqueRepository.save(boutique) ;
	}
	
	@RequestMapping (value = "/Boutique", method=RequestMethod.DELETE)
	public Boolean  deleteBoutique(@PathVariable ("ref") int ref){
		boutiqueRepository.deleteById(ref) ;
		return  true;
	}
	
	@RequestMapping (value = "/Boutique", method=RequestMethod.PUT)
	public Boutique updateBoutique(@RequestBody Boutique boutique){
		return boutiqueRepository.saveAndFlush(boutique) ;
	}
	

}
