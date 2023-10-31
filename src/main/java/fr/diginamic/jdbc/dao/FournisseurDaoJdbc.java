package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.entities.Fournisseur;

public class FournisseurDaoJdbc implements FournisseurDao {
	
	Connection connectionMaria = null;
	Statement leStatement = null;
	

	@Override
	public List<Fournisseur> extraire() {
		// TODO Auto-generated method stub
		ResultSet curseur = null;
		ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
		
		try {
			connectionMaria = DriverManager.getConnection("jdbc:mysql://localhost:3306/compta", "root", "");
			leStatement = connectionMaria.createStatement();
			curseur = leStatement.executeQuery("SELECT * FROM fournisseur");
			
			while(curseur.next()){
				int id = curseur.getInt(1);
				String nom = curseur.getString(2);
				
				Fournisseur fournisseur = new Fournisseur(nom, id);
				fournisseurs.add(fournisseur);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				curseur.close();
				leStatement.close();
				connectionMaria.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return fournisseurs;
		
	}

	@Override
	public void insert(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
		try {
			connectionMaria = DriverManager.getConnection("jdbc:mysql://localhost:3306/compta", "root", "");
			leStatement = connectionMaria.createStatement();

			leStatement.executeUpdate("INSERT INTO fournisseur (NOM) VALUES ('"+fournisseur.getNom()+"')");
			
			System.out.println("OK");
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				leStatement.close();
				connectionMaria.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
	}

	@Override
	public int update(String ancienNom, String nouveauNom) {
		// TODO Auto-generated method stub
		
		int update = 0;
		
		try {
			connectionMaria = DriverManager.getConnection("jdbc:mysql://localhost:3306/compta", "root", "");
			leStatement = connectionMaria.createStatement();
			
			PreparedStatement updateCompta = connectionMaria.prepareStatement("UPDATE fournisseur SET NOM = '?' where NOM = '?'");
			updateCompta.setString(1, ancienNom);
			updateCompta.setString(2, nouveauNom);
			updateCompta.executeUpdate();
			//String leFournisseur = "('"+fournisseur.getNom()+"')";

			//update = leStatement.executeUpdate("UPDATE fournisseur SET NOM = '"+nouveauNom+"' where NOM = '"+ancienNom+"'");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				leStatement.close();
				connectionMaria.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		return update;
	}

	@Override
	public boolean delete(Fournisseur fournisseur) {
		Boolean delete = false;
		int deleteTest = 0;
		
		try {
			connectionMaria = DriverManager.getConnection("jdbc:mysql://localhost:3306/compta", "root", "");
			leStatement = connectionMaria.createStatement();
			
			//String leFournisseur = "('"+fournisseur.getNom()+"')";

			deleteTest = leStatement.executeUpdate("DELETE FROM fournisseur WHERE NOM = '"+fournisseur.getNom()+"'");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				leStatement.close();
				connectionMaria.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		if (deleteTest == 0) {
			delete = false;
		} else {
			delete = true;
		}
		return delete;
	}

}
