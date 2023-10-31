package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	

		
		try {
			DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
			Connection connectionMaria = DriverManager.getConnection("jdbc:mysql://localhost:3306/compta", "root", "");
			
			Statement leStatement = connectionMaria.createStatement();
			//int nb = leStatement.executeUpdate("INSERT INTO fournisseur (NOM) VALUES ('La Maison de la Peinture')");
			
			//int nb = leStatement.executeUpdate("UPDATE fournisseur SET NOM = 'Maison des peintures' where ID = 4");
			
			int nb = leStatement.executeUpdate("DELETE FROM fournisseur WHERE ID = 4");
			
			System.out.println(nb);
			leStatement.close();
			connectionMaria.close();
			
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			
		}
		
	}

}
