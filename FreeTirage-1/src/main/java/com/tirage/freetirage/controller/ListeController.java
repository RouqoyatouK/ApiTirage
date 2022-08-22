package com.tirage.freetirage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tirage.freetirage.Model.Liste;
import com.tirage.freetirage.service.ListeService;


@RequestMapping("liste")
public class ListeController {

	
	@Autowired
	ListeService listeservice;
	
	@GetMapping("/read")
	public List<Liste> read() {
		return listeservice.lire();
}
}
