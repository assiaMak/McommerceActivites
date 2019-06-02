package com.mcommerce.microserviceexpedition.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mcommerce.microserviceexpedition.dao.ExpeditionDao;
import com.mcommerce.microserviceexpedition.exception.ExpeditionNotFoudException;
import com.mcommerce.microserviceexpedition.model.Expedition;

@RestController
public class ExpeditionController {

	@Autowired
	private ExpeditionDao expeditionDao;
	
	@PostMapping(value = "/expedition")
	public Expedition ajouterExpedition(@RequestBody Expedition expedition) {
		return expeditionDao.save(expedition);
	}
	
	@GetMapping(value = "/expeditions/{id}")
	public Expedition retrouverExpedition(@PathVariable("id") Integer expeditionId){
		Optional<Expedition> expedition = expeditionDao.findById(expeditionId);
		
		if(!expedition.isPresent()) {
			throw new ExpeditionNotFoudException("L'expedition correspondant à l'id " + expeditionId + " n'existe pas");
		}
		
		return expedition.get();
	}
	
	@PutMapping(value = "/expedition")
	public Expedition modifierExpedition(@RequestBody Expedition expedition) {
		Optional<Expedition> baseExpedition = expeditionDao.findById(expedition.getId());
		
		if(!baseExpedition.isPresent()) {
			throw new ExpeditionNotFoudException("L'expedition correspondant à l'id " + expedition.getId() + " n'existe pas");
		}
		return expeditionDao.save(expedition);
	}
}
