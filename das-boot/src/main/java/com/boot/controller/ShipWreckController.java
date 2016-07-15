package com.boot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipWreckRepository;

@RestController
@RequestMapping("api/v1/")
public class ShipWreckController {
	
	@Autowired
	private ShipWreckRepository shipWreckRepository;
	
	@RequestMapping(value="shipwrecks" , method=RequestMethod.GET)
	public List<Shipwreck> list(){
		
		//return ShipwreckStub.list();
		return shipWreckRepository.findAll();
	}
	
	@RequestMapping(value="shipwrecks/{id}" , method=RequestMethod.GET)
	public Shipwreck get(@PathVariable Long id){
		
		return shipWreckRepository.findOne(id);
		
	}
	
	@RequestMapping(value="shipwrecks" , method=RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck shipwreck){
		
		//return ShipwreckStub.create(shipwreck);
		return shipWreckRepository.saveAndFlush(shipwreck);
		
	}
	
	@RequestMapping(value="shipwrecks/{id}" , method=RequestMethod.PUT)
	public Shipwreck update(@PathVariable Long id,@RequestBody Shipwreck shipwreck){
		Shipwreck existingWreck =shipWreckRepository.findOne(id);
		BeanUtils.copyProperties(shipwreck, existingWreck);
		
		return shipWreckRepository.saveAndFlush(shipwreck);
		
	}
	
	@RequestMapping(value="shipwrecks/{id}" , method=RequestMethod.DELETE)
	public Shipwreck delete(@PathVariable Long id){
		Shipwreck existingWreck =shipWreckRepository.findOne(id);
		shipWreckRepository.delete(existingWreck);
		return existingWreck;
		
	}
	
}
