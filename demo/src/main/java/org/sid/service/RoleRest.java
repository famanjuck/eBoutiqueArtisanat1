package org.sid.service;

import java.util.List;
import java.util.Optional;

import org.sid.dao.RoleRepository;
import org.sid.reverse.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleRest {
	@Autowired
	 private RoleRepository roleRepository ;
	
	@RequestMapping (value = "/Role", method=RequestMethod.GET)
	public List<Role> getRoles(){
		return roleRepository.findAll() ;
	}
	
	@RequestMapping (value = "/Role/{ref}", method=RequestMethod.GET)
	public Optional<Role> getRoles(@PathVariable ("ref") int ref){
		return roleRepository.findById(ref) ;
	}

	@RequestMapping (value = "/Role", method=RequestMethod.POST)
	public Role saveRoles(@RequestBody Role role){
		return roleRepository.save(role) ;
	}
	
	@RequestMapping (value = "/Role", method=RequestMethod.DELETE)
	public Boolean deleteRoles(@PathVariable ("ref") int ref){
		roleRepository.deleteById(ref) ;
		return true;
	}
	
	@RequestMapping (value = "/Role", method=RequestMethod.PUT)
	public Role updateRoles(@RequestBody Role role){
		return roleRepository.saveAndFlush(role) ;
	}

}
