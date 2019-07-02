package org.sid.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.sid.dao.ArticleRepository;
import org.sid.dao.ClientRepository;
import org.sid.dao.CommandeRepository;
import org.sid.dao.LignedecommandeRepository;
import org.sid.reverse.Client;
import org.sid.reverse.Commande;
import org.sid.reverse.Lignedecommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CommandeRest {
	@Autowired
	 private CommandeRepository commandeRepository ;
	
	@Autowired
	private ArticleRepository articleRepository;
	
/*	@Autowired
	private ClientRepository clientRepository;*/
	
	@Autowired
	private LignedecommandeRepository ligne ;
	
	@RequestMapping (value = "/Commande", method=RequestMethod.GET)
	public List<Commande> getCommandes(){
		return commandeRepository.findAll() ;
	}
	
	@RequestMapping (value = "/Commande/{ref}", method=RequestMethod.GET)
	public Optional<Commande> getCommandes(@PathVariable ("ref") int ref){
		return commandeRepository.findById(ref) ;
	}
	
	@RequestMapping (value = "/Commande/{idArticle}", method=RequestMethod.POST)
	public Commande saveCommandes(@RequestBody Commande commande,@PathVariable ("idArticle") int idArticle){
		
/*		Client client= clientRepository.getOne(4);
		commande.setClient(client);*/
		commandeRepository.save(commande) ;
		
		
		
		Lignedecommande lc = new Lignedecommande(1, commande, articleRepository.getOne(idArticle)) ;
		lc.setDatecommander(new Date());
		lc.setQuantitecommander(3);
		
		ligne.save(lc) ;
		
		return commande ;
	}
	
	@RequestMapping (value = "/Commande", method=RequestMethod.DELETE)
	public Boolean deleteCommandes(@PathVariable ("ref") int ref){
		commandeRepository.deleteById(ref) ;
		return true;
	}
	
	@RequestMapping (value = "/Commande", method=RequestMethod.PUT)
	public Commande updateCommandes(@RequestBody Commande commande){
		return commandeRepository.saveAndFlush(commande) ;
	}

}
