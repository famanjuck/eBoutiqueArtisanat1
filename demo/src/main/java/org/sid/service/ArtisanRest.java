package org.sid.service;

import java.util.List;
import java.util.Optional;

import org.sid.dao.ArtisanRepository;
import org.sid.dao.UtilisateurRepository;
import org.sid.reverse.Artisan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ArtisanRest {
	@Autowired
	 private ArtisanRepository artisanRepository ;
	@Autowired
	public UtilisateurRepository utilisateurRepository;

	
	@RequestMapping (value = "/Artisan", method=RequestMethod.GET)
	public List<Artisan> getArtist(){
		return artisanRepository.findAll() ;
	}
	
	@RequestMapping(value = "/Artisan/{ref}",method=RequestMethod.GET)
	public Optional<Artisan> getArtist(@PathVariable("ref") int ref){
		return artisanRepository.findById(ref) ;
	}
	
	@RequestMapping(value = "/Artisan",method=RequestMethod.POST)
	public Artisan saveArtist(@RequestBody Artisan artisan){
		utilisateurRepository.save(artisan.getUtilisateur());
		return artisanRepository.save(artisan) ;
	}
	
	@RequestMapping(value = "/Artisan",method=RequestMethod.DELETE)
	public Boolean deleteArtist(@PathVariable("ref") int ref){
		artisanRepository.deleteById(ref);
		return true ;
	}
	
	@RequestMapping(value = "/Artisan",method=RequestMethod.PUT)
	public Artisan updateAdmin(@RequestBody Artisan artisan){
		return artisanRepository.saveAndFlush(artisan) ;
		
	}	

}
