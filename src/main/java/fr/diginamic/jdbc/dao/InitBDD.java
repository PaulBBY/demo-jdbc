package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.diginamic.jdbc.entities.Brut;
import fr.diginamic.jdbc.entities.Departement;
import fr.diginamic.jdbc.entities.Recensement;
import fr.diginamic.jdbc.entities.Region;
import fr.diginamic.utils.Liseuse;

public class InitBDD {
	
	static {
		
		Recensement brut = new Recensement();
		
		brut = Liseuse.liseuse();
		
		ArrayList<Brut> dB = brut.getDonneesBrut();
		
		Connection connectionMaria = null;
		Statement leStatement = null;
		ResultSet curseur = null;
		
		try {
			
			connectionMaria = DriverManager.getConnection("jdbc:mysql://localhost:3306/recensement", "root", "");
			leStatement = connectionMaria.createStatement();
			
			ArrayList<String> departements = new ArrayList<>();
			ArrayList<String> regions = new ArrayList<>();
			
			for(Brut b : dB) {
				
				if(!departements.contains(b.getCodeDepartement())) {
					
					PreparedStatement insertDpt = connectionMaria.prepareStatement("INSERT INTO departement (CODE_DEPARTEMENT) values (?)");
					insertDpt.setString(1, b.getCodeDepartement());
					insertDpt.executeUpdate();	
					departements.add(b.getCodeDepartement());
				}
				
				if(!regions.contains(b.getCodeRegion())) {
					PreparedStatement insertRgn = connectionMaria.prepareStatement("INSERT INTO region (NOM_REGION, CODE_REGION) VALUES (?, ?)");
					insertRgn.setString(1, b.getNomRegion());
					insertRgn.setString(2, b.getCodeRegion());
					insertRgn.executeUpdate();
					regions.add(b.getCodeRegion());
				}
				
	
				PreparedStatement getIdDpt = connectionMaria.prepareStatement("SELECT ID FROM departement WHERE CODE_DEPARTEMENT = ?");

				getIdDpt.setString(1, b.getCodeDepartement());
	
				curseur = getIdDpt.executeQuery();
				int fkDpt = 0;
				if(curseur.next()) {
					 fkDpt = curseur.getInt(1);	
		
				}
				
				PreparedStatement getIdRgn = connectionMaria.prepareStatement("SELECT ID FROM region WHERE CODE_REGION = ?");
				getIdRgn.setString(1, b.getCodeRegion());
				curseur = getIdRgn.executeQuery();
				int fkRgn = 0;
				if(curseur.next()) {
					 fkRgn = curseur.getInt(1);

				}
				
				
				
				PreparedStatement insertVille = connectionMaria.prepareStatement("INSERT INTO ville (NOM_VILLE, POP_VILLE, ID_DPT, ID_RGN) VALUES (?,?,?,?)");
				insertVille.setString(1, b.getNomVille());
				insertVille.setInt(2, b.getPopVille());
				insertVille.setInt(3, fkDpt);
				insertVille.setInt(4, fkRgn);
				insertVille.executeUpdate();
				
			}
	
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
	
	
}
