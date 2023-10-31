package fr.diginamic.jdbc.entities;

public class Brut {
	
	private String nomVille;
	private int popVille;
	private String codeDepartement;
	private String nomRegion;
	private String codeRegion;
	
	public Brut(String nomVille, int popVille, String codeDepartement, String nomRegion, String codeRegion) {
		this.nomVille = nomVille;
		this.popVille = popVille;
		this.codeDepartement = codeDepartement;
		this.nomRegion = nomRegion;
		this.codeRegion = codeRegion;
	}

	@Override
	public String toString() {
		return "Brut [nomVille=" + nomVille + ", popVille=" + popVille + ", codeDepartement=" + codeDepartement
				+ ", NomRegion=" + nomRegion + ", codeRegion=" + codeRegion + "]";
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

	public String getCodeDepartement() {
		return codeDepartement;
	}

	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}

	public String getNomRegion() {
		return nomRegion;
	}

	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}

	public String getCodeRegion() {
		return codeRegion;
	}

	public void setCodeRegion(String codeRegion) {
		this.codeRegion = codeRegion;
	}
	
	

}
