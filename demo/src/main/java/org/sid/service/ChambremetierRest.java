package org.sid.service;

import java.util.List;
import java.util.Optional;

import org.sid.dao.ChambremetierRepository;
import org.sid.reverse.Chambremetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChambremetierRest {
	@Autowired
	 private ChambremetierRepository chambremetierRepository ;
	
	@RequestMapping (value = "/Chambremetier", method=RequestMethod.GET)
	public List<Chambremetier> getChambremetiers(){
		return chambremetierRepository.findAll() ;
	}
	
	@RequestMapping (value = "/Chambremetier/{ref}", method=RequestMethod.GET)
	public Optional<Chambremetier> getChambremetiers(@PathVariable ("ref")int ref){
		return chambremetierRepository.findById(ref) ;
	}
	
	
	@RequestMapping(value = "/Chambremetier",method=RequestMethod.POST)
	public  Chambremetier saveChambremetiers(@RequestBody Chambremetier chambremetier){
		return chambremetierRepository.save(chambremetier) ;
	}
	
	@RequestMapping (value = "/Chambremetier", method=RequestMethod.DELETE)
	public Boolean  deleteChambremetiers(@PathVariable ("ref") int ref){
		 chambremetierRepository.deleteById(ref) ;
		 return true;
	}
	
	@RequestMapping(value = "/Chambremetier",method=RequestMethod.PUT)
	public  Chambremetier updateChambremetiers(@RequestBody Chambremetier chambremetier){
		return chambremetierRepository.saveAndFlush(chambremetier) ;
	}

}
