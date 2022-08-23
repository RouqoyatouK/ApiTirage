package com.tirage.freetirage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tirage.freetirage.Model.Liste;
import com.tirage.freetirage.repository.ListeRepo;

@Service
public class ListeServiceImpl implements ListeService {
	
	@Autowired
	ListeRepo listerepo;

	@Override
	public Liste creer(Liste liste) {
		// TODO Auto-generated method stub
		return listerepo.save(liste);
	}

	@Override
	public List<Liste> lire() {
		// TODO Auto-generated method stub
		return listerepo.findAll();
	}

	@Override
	public Liste trouverListeParLibelle(String libelle) {
		// TODO Auto-generated method stub
		return listerepo.findByLibelle(libelle);
	}

}
