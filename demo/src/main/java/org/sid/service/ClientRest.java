package org.sid.service;

import java.util.List;
import java.util.Optional;

import org.sid.dao.ClientRepository;
import org.sid.dao.UtilisateurRepository;
import org.sid.reverse.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientRest {
	@Autowired
	 private ClientRepository clientRepository ;
	@Autowired
	public UtilisateurRepository utilisateurRepository;

	
	@RequestMapping (value = "/Client", method=RequestMethod.GET)
	public List<Client> getClients(){
		return clientRepository.findAll() ;
	}
	
	@RequestMapping(value = "/Client/{ref}",method=RequestMethod.GET)
	public Optional<Client> getClients(@PathVariable("ref") int ref){
		return clientRepository.findById(ref) ;
	}
	
	@RequestMapping(value = "/Client",method=RequestMethod.POST)
	public  Client saveClients(@RequestBody Client client){
		utilisateurRepository.save(client.getUtilisateur());
		return clientRepository.save(client) ;
	}
	
	@RequestMapping(value = "/Client",method=RequestMethod.DELETE)
	public Boolean deleteClients(@PathVariable("ref") int ref){
		clientRepository.deleteById(ref);
		return true ;
	}
	
	@RequestMapping(value = "/Client",method=RequestMethod.PUT)
	public Client updateClients(@RequestBody Client client){
		return clientRepository.saveAndFlush(client) ;
	}

}
