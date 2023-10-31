package fr.diginamic.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.diginamic.jdbc.entities.Fournisseur;

public class TestSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection connectionMaria = null;
		Statement leStatement = null;
		ResultSet curseur = null;
		
		
		try {
			
			DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
			connectionMaria = DriverManager.getConnection("jdbc:mysql://localhost:3306/compta", "root", "");
			
			leStatement = connectionMaria.createStatement();
			
			curseur = leStatement.executeQuery("SELECT * FROM fournisseur");
			
			ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
			
			while(curseur.next()){
				int id = curseur.getInt(1);
				String nom = curseur.getString(2);
				
				Fournisseur fournisseur = new Fournisseur(nom, id);
				fournisseurs.add(fournisseur);
			}
			
			for(Fournisseur f : fournisseurs) {
				System.out.println(f.toString());
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
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
		
	}

	

}
