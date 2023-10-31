package fr.diginamic.jdbc.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.entities.Fournisseur;

public abstract class TestDaoJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Fournisseur f1 = new Fournisseur("France de Matériaux", 0);
		Fournisseur f2 = new Fournisseur("L'espace création", 0);
		
		FournisseurDaoJdbc dao = new FournisseurDaoJdbc();
		try {
			
			//dao.insert(f1);
			DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
			/*List<Fournisseur> fournisseurs = dao.extraire();
			
			for(Fournisseur f : fournisseurs) {
				System.out.println(f.toString());
			}

			
			fournisseurs = dao.extraire();
			
			for(Fournisseur f : fournisseurs) {
				System.out.println(f.toString());
				
			}
			
			for(Fournisseur f : fournisseurs) {
				
				if (f.getNom().equals("France matériaux")) {
					dao.delete(f);
				}
				
			}*/
			
			dao.insert(f2);
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
