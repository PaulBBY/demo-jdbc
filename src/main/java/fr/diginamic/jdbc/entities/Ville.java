package fr.diginamic.jdbc.entities;

public class Ville {

	private String nomVille;
	private int popVille;
	Departement departementVille;
	Region regionVille;
	
	public Ville(String nomVille, int popVille, Departement departementVille, Region regionVille) {
		this.nomVille = nomVille;
		this.popVille = popVille;
		this.departementVille = departementVille;
		this.regionVille = regionVille;
	}

	@Override
	public String toString() {
		return "Ville [nomVille=" + nomVille + ", popVille=" + popVille + ", departementVille=" + departementVille
				+ ", regionVille=" + regionVille + "]";
	}

	public String getNomVille() {
		return nomVille;
	}

	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}

	public int getPopVille() {
		return popVille;
	}

	public void setPopVille(int popVille) {
		this.popVille = popVille;
	}

	public Departement getDepartementVille() {
		return departementVille;
	}

	public void setDepartementVille(Departement departementVille) {
		this.departementVille = departementVille;
	}

	public Region getRegionVille() {
		return regionVille;
	}

	public void setRegionVille(Region regionVille) {
		this.regionVille = regionVille;
	}
	
	
	
	
}
