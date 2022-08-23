package com.tirage.freetirage.service;

import java.util.List;

import com.tirage.freetirage.Model.PostulantTrier;
import com.tirage.freetirage.Model.Tirage;

public interface PostulantTriService {
	
	
	public int creer(long idPostulant, String nomPostulant, String prenomPostulant, String numeroPostulant, String email,
			long tirage_idtirage);
	
	public List<PostulantTrier> postulantTrierParId(int idTirage);
	
	List<PostulantTrier> trouverPostulantTrierParIdtirage(Long idTirage);

	PostulantTrier save(PostulantTrier p);
	
	List<PostulantTrier> findByTirage(Tirage t);

}
