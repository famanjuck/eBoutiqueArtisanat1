package org.sid.service;

import java.util.List;
import java.util.Optional;

import org.sid.dao.AdministrateurRepository;
import org.sid.dao.UtilisateurRepository;
import org.sid.reverse.Administrateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdministrateurRest {
	@Autowired
	private AdministrateurRepository administrateurRepository;
	@Autowired
	public UtilisateurRepository utilisateurRepository;

	@RequestMapping(value = "/Administrateur",method=RequestMethod.GET)
	public List<Administrateur> getAdmins(){
		return administrateurRepository.findAll();
	}
	
	@RequestMapping(value = "/Administrateur/{ref}",method=RequestMethod.GET)
	public Optional<Administrateur> getAdmins(@PathVariable("ref") int ref){
		return administrateurRepository.findById(ref) ;
	}
	
	@RequestMapping(value = "/Administrateur",method=RequestMethod.POST)
	public Administrateur saveAdmins(@RequestBody Administrateur administrateur){
		utilisateurRepository.save(administrateur.getUtilisateur());
		return administrateurRepository.save(administrateur) ;
	}
	
	@RequestMapping(value = "/Administrateur",method=RequestMethod.DELETE)
	public Boolean deleteAdmins(@PathVariable("ref") int ref){
		administrateurRepository.deleteById(ref);
		return true ;
	}
	
	@RequestMapping(value = "/Administrateur",method=RequestMethod.PUT)
	public Administrateur updateAdmins(@RequestBody Administrateur administrateur){
		return administrateurRepository.saveAndFlush(administrateur) ;
	}

}
