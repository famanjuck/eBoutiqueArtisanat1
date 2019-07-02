package org.sid.service;

import java.util.List;
import java.util.Optional;

import org.sid.dao.VillageartisanalRepository;
import org.sid.reverse.Villageartisanal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VillageartisanalRest {
	@Autowired
	 private VillageartisanalRepository villageartisanalRepository ;
	
	@RequestMapping (value = "/Villageartisanal", method=RequestMethod.GET)
	public List<Villageartisanal> getGalerie(){
		return villageartisanalRepository.findAll() ;
	} 
	
	@RequestMapping (value = "/Villageartisanal/{ref}", method=RequestMethod.GET)
	public Optional<Villageartisanal> getGalerie(@PathVariable ("ref") int ref){
		return villageartisanalRepository.findById(ref) ;
	} 
	
	@RequestMapping (value = "/Villageartisanal", method=RequestMethod.POST)
	public Villageartisanal saveGalerie(@RequestBody Villageartisanal villageartisanal ){
		return villageartisanalRepository.save(villageartisanal) ;
	}

	@RequestMapping (value = "/Villageartisanal", method=RequestMethod.DELETE)
	public Boolean deleteGalerie(@PathVariable ("ref") int ref){
		 villageartisanalRepository.deleteById(ref) ;
		 return true;
	}
	
	
	@RequestMapping (value = "/Villageartisanal", method=RequestMethod.PUT)
	public Villageartisanal updateGalerie(@RequestBody Villageartisanal villageartisanal ){
		return villageartisanalRepository.saveAndFlush(villageartisanal) ;
	}


}
