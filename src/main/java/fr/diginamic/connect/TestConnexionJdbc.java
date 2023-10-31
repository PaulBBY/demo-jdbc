package fr.diginamic.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnexionJdbc {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
		
		Connection connectionMaria = DriverManager.getConnection("jdbc:mysql://localhost:3306/compta", "root", "");

		System.out.println(connectionMaria);
		
		connectionMaria.close();
	}

}
