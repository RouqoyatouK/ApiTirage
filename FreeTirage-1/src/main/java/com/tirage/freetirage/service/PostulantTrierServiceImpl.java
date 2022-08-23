package com.tirage.freetirage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tirage.freetirage.Model.PostulantTrier;
import com.tirage.freetirage.Model.Tirage;
import com.tirage.freetirage.repository.PostulantTrieRepo;

@Service
public class PostulantTrierServiceImpl implements PostulantTriService {
	
	@Autowired
	PostulantTrieRepo postulanttrierrepo;

	@Override
	public int creer(long idPostulant, String nomPostulant, String prenomPostulant, String numeroPostulant, String email,
			long tirage_idtirage) {
		// TODO Auto-generated method stub
		return postulanttrierrepo.INSERTPOSTTIRE(idPostulant, nomPostulant, prenomPostulant, numeroPostulant, email, tirage_idtirage);
	}

	@Override
	public List<PostulantTrier> postulantTrierParId(int idTirage) {
		// TODO Auto-generated method stub
		return postulanttrierrepo.FINDALLPOSTULANTTRIEPARID(idTirage);
		
		
	}

	@Override
	public List<PostulantTrier> trouverPostulantTrierParIdtirage(Long idTirage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostulantTrier save(PostulantTrier p) {
		// TODO Auto-generated method stub
		return postulanttrierrepo.save(p);
	}

	@Override
	public List<PostulantTrier> findByTirage(Tirage t) {
		// TODO Auto-generated method stub
		return postulanttrierrepo.findByTirage(t);
	}

}
