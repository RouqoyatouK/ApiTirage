package com.tirage.freetirage.service;

import java.util.List;

import com.tirage.freetirage.Model.Liste;

public interface ListeService  {
	
	Liste creer(Liste liste);
	
	List<Liste> lire();

}