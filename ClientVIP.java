package Gestion.Banque;

public class ClientVIP extends Client {
	
private String nomEntreprise;
private double chiffreAffaire;
private int nombreEmploye;

public ClientVIP(){
	super();
}
public ClientVIP(int cin, String nom, String prenom) {
	super(cin, nom, prenom);
}
public ClientVIP(int cin, String nom, String prenom, String nomEntreprise, double chiffreAffaire, int nombreEmploye) {
	super(cin, nom, prenom);
	this.nomEntreprise = nomEntreprise;
	this.chiffreAffaire = chiffreAffaire;
	this.nombreEmploye = nombreEmploye;
}

public String getNomEntreprise() {
	return nomEntreprise;
}
public void setNomEntreprise(String nomEntreprise) {
	this.nomEntreprise = nomEntreprise;
}
public double getChiffreAffaire() {
	return chiffreAffaire;
}
public void setChiffreAffaire(double chiffreAffaire) {
	this.chiffreAffaire = chiffreAffaire;
}
public int getNombreEmploye() {
	return nombreEmploye;
}
public void setNombreEmploye(int nombreEmploye) {
	this.nombreEmploye = nombreEmploye;
}

@Override
public String toString() {
	return "ClientVIP [ CIN=" + getCin() + ", Nom=" + getNom() + ", Prenom=" + getPrenom() +""
			+ "nomEntreprise=" + nomEntreprise + ", chiffreAffaire=" + chiffreAffaire + ", nombreEmploye="
			+ nombreEmploye + "]";
}


}
