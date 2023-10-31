package fr.diginamic.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import fr.diginamic.jdbc.entities.Recensement;



public class Liseuse {


	
	public static Recensement liseuse() {
		
		Recensement donneesBrut = new Recensement();
		
		try {
			Path path = Paths.get("C:\\Users\\Paul\\Documents\\7. Langage Java - approche objet\\Journée J7 - autoformation\\tp 16 - recensement population 2016.csv");
			List<String> lignes  = Files.readAllLines(path, StandardCharsets.UTF_8);
			
			lignes.remove(0);
			
			for (String ligne: lignes){
				Parse.ajoutLigne(donneesBrut, ligne);
			}
			return donneesBrut;
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}

		
	}
	
	
}
