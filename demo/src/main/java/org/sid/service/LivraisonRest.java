package org.sid.service;

import java.util.List;
import java.util.Optional;

import org.sid.dao.LivraisonRepository;
import org.sid.reverse.Livraison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivraisonRest {
	@Autowired
	 private LivraisonRepository livraisonRepository ;
	
	@RequestMapping (value = "/Livraison", method=RequestMethod.GET)
	public List<Livraison> getLivraison(){
		return livraisonRepository.findAll() ;
	}
	
	@RequestMapping (value = "/Livraison/{ref}", method=RequestMethod.GET)
	public Optional<Livraison> getLivraison(@PathVariable ("ref") int ref ){
		return livraisonRepository.findById(ref) ;
	} 
	
	@RequestMapping (value = "/Livraison", method=RequestMethod.POST)
	public Livraison saveLivraison(@RequestBody Livraison livraison ){
		return livraisonRepository.save(livraison) ;
	} 
	
	@RequestMapping (value = "/Livraison/{ref}", method=RequestMethod.DELETE)
	public Boolean deleteLivraison(@PathVariable ("ref") int ref ){
		 livraisonRepository.findById(ref) ;
		 return true;
	}
	
	@RequestMapping (value = "/Livraison", method=RequestMethod.PUT)
	public Livraison updateLivraison(@RequestBody Livraison livraison ){
		return livraisonRepository.saveAndFlush(livraison) ;
	}


}
