package fr.diginamic.jdbc.entities;

public class Departement {
	
	private String codeDepartement;
	private int id;

	public Departement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
		this.id = 0;
	}
	
	@Override
	public String toString() {
		return "Departement [codeDepartement=" + codeDepartement + ", id=" + id + "]";
	}

	public String getCodeDepartement() {
		return codeDepartement;
	}

	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

}
