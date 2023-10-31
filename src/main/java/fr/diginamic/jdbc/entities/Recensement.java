package fr.diginamic.jdbc.entities;

import java.util.ArrayList;

public class Recensement {
	
	ArrayList<Brut> donneesBrut = new ArrayList<>();

	public ArrayList<Brut> getDonneesBrut() {
		return donneesBrut;
	}

	public void setDonneesBrut(ArrayList<Brut> donneesBrut) {
		this.donneesBrut = donneesBrut;
	}

}
