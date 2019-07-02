package org.sid.service;

import java.util.List;
import java.util.Optional;

import org.sid.dao.SectionartRepository;
import org.sid.reverse.Sectionart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class SectionartRest {
	@Autowired
	private SectionartRepository sectionartRepository;
	
	@RequestMapping(value ="/Sectionart",method=RequestMethod.GET)
	public List<Sectionart> getSection(){
		return sectionartRepository.findAll();
	}
	
	@RequestMapping(value ="/Sectionart/{ref}",method=RequestMethod.GET)
	public Optional<Sectionart> getSection(@PathVariable("ref") int ref){
		return sectionartRepository.findById(ref) ;
	}
	
	@RequestMapping(value ="/Sectionart",method=RequestMethod.POST)
	public Sectionart saveProduit(@RequestBody Sectionart sectionart){
		return sectionartRepository.save(sectionart) ;
	}
	
	@RequestMapping(value ="/Sectionart",method=RequestMethod.DELETE)
	public Boolean deleteSection(@PathVariable("ref") int ref){
		sectionartRepository.deleteById(ref);
		return true ;
	}
	
	@RequestMapping(value ="/Sectionart",method=RequestMethod.PUT)
	public Sectionart updateProduit(@RequestBody Sectionart sectionart){
		return sectionartRepository.saveAndFlush(sectionart) ;
	}

}
