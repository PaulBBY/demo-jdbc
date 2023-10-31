package fr.diginamic.utils;

import fr.diginamic.jdbc.entities.Brut;
import fr.diginamic.jdbc.entities.Recensement;

public class Parse {
	
	public static void ajoutLigne(Recensement recensement, String ligne){
		
		String[] morceaux = ligne.split(";");
		String codeRegion = morceaux[0];
		String nomRegion = morceaux[1];
		String codeDepartement = morceaux[2];
		String nomVille = morceaux[6];
		String popVille = morceaux[7];
		int populationTotale = Integer.parseInt(popVille.replace(" ", "").trim());
		
		// On cree maintenant la ville avec toutes ses données
		Brut brut = new Brut(nomVille, populationTotale, codeDepartement, nomRegion, codeRegion);
		
		// On ajoute la ville é la liste des villes du recensement
		recensement.getDonneesBrut().add(brut);
		
	}

}
