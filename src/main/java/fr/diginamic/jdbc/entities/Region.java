package fr.diginamic.jdbc.entities;

public class Region {

	private String NomRegion;
	private String codeRegion;
	private int id;
	public Region(String nomRegion, String codeRegion) {
		NomRegion = nomRegion;
		this.codeRegion = codeRegion;
		this.id = 0;
	}
	@Override
	public String toString() {
		return "Region [NomRegion=" + NomRegion + ", codeRegion=" + codeRegion + ", id=" + id + "]";
	}
	public String getNomRegion() {
		return NomRegion;
	}
	public void setNomRegion(String nomRegion) {
		NomRegion = nomRegion;
	}
	public String getCodeRegion() {
		return codeRegion;
	}
	public void setCodeRegion(String codeRegion) {
		this.codeRegion = codeRegion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
