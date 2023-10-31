package fr.diginamic.jdbc.dao;

import java.util.List;

import fr.diginamic.jdbc.entities.Fournisseur;

public interface Dao<T>{
	
	List<T> extraire();
	void insert(T objet);
	int update(String ancienNom, String nouveauNom);
	boolean delete(T objet);	 

}
