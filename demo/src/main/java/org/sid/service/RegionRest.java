package org.sid.service;

import java.util.List;

import org.sid.dao.RegionRepository;
import org.sid.reverse.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegionRest {
	@Autowired
	 private RegionRepository regionRepository ;
	
	@RequestMapping (value = "/Region/{ref}", method=RequestMethod.GET)
	public List<Region> getVille(){
		return regionRepository.findAll() ;
	} 
	
	@RequestMapping(value = "/Region/{ref}",method=RequestMethod.DELETE)
	public Boolean deleteRegions(@PathVariable("ref") int ref){
		regionRepository.deleteById(ref);
		return true ;
	}
	@RequestMapping(value = "/Region",method=RequestMethod.POST)
	public Region saveRegions(@RequestBody Region region){
		return regionRepository.save(region);
		}
	
	@RequestMapping(value = "/Region",method=RequestMethod.PUT)
	public Region updateRegions(@RequestBody Region region){
		return regionRepository.saveAndFlush(region);
		 
	}

}
