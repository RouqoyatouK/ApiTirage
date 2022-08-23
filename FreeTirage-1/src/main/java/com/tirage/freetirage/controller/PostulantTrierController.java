package com.tirage.freetirage.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirage.freetirage.Model.PostulantTrier;
import com.tirage.freetirage.service.PostulantTriService;

@RestController
@RequestMapping("/postulantTrier")
public class PostulantTrierController {
	
	@Autowired
	PostulantTriService postulantTrierService;
	
	
	@GetMapping("/afficher")
	public List<PostulantTrier> create (int idPostulant) {
		return postulantTrierService.postulantTrierParId(idPostulant);

}
}
