package fr.diginamic.jdbc;

import java.util.ArrayList;

import fr.diginamic.jdbc.dao.InitBDD;
import fr.diginamic.jdbc.entities.Brut;
import fr.diginamic.jdbc.entities.Recensement;
import fr.diginamic.utils.Liseuse;

public class TestRecensement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		long debut = System.currentTimeMillis();
		
		InitBDD init = new InitBDD();
		
		long fin = System.currentTimeMillis();
		
		System.out.println(fin - debut);
		
	}

}
