package jDBCProjet.beans;

public class Client {
	private int id ;
	private String prenom;
	private String nom;
	public Client(String prenom, String nom) {
		this.prenom = prenom;
		this.nom = nom;
	}
	public Client(int id, String prenom, String nom){
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", prenom=" + prenom + ", nom=" + nom + "]";
	}
	public int getId() {
		return id;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	
	
}
