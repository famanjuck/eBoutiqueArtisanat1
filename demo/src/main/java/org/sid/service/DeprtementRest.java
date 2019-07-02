package org.sid.service;

import java.util.List;
import java.util.Optional;

import org.sid.dao.DepartementRepository;
import org.sid.reverse.Departement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeprtementRest {
	@Autowired
	 private DepartementRepository departementRepository ;
	
	@RequestMapping (value = "/Departement", method=RequestMethod.GET)
	public List<Departement> getDepartement(){
		return departementRepository.findAll() ;
	}
	
	@RequestMapping(value = "/Departement/{ref}",method=RequestMethod.GET)
	public Optional<Departement> getDepartements(@PathVariable("ref") int ref){
		return departementRepository.findById(ref) ;
	}
	
	@RequestMapping(value = "/Departement",method=RequestMethod.POST)
	public  Departement saveDepartements(@RequestBody Departement departement){
		return departementRepository.save(departement) ;
	}
	
	@RequestMapping(value = "/Departementt",method=RequestMethod.DELETE)
	public Boolean deleteDepartement(@PathVariable("ref") int ref){
		departementRepository.deleteById(ref);
		return true ;
	}
	
	@RequestMapping(value = "/Departement",method=RequestMethod.PUT)
	public Departement updateDepartement(@RequestBody Departement departement){
		return departementRepository.saveAndFlush(departement) ;
	}


}
