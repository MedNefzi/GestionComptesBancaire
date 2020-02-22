package Gestion.Banque;

import java.util.Arrays;

public class Agence {
	private long identifiant;
	private String nom;
	private String adresse;
	private int nbreClient;
	private double debitAgence;
	private double creditAgence;
	private Compte  [] comptes;
	
	public Agence(){
		
	}
	public Agence(long identifiant, String nom, String adresse,Compte[] t) {
		this.identifiant = identifiant;
		this.nom = nom;
		this.adresse = adresse;
		this.comptes=t;
	}
	public Agence(long identifiant, String nom, String adresse) {
		this.identifiant = identifiant;
		this.nom = nom;
		this.adresse = adresse;
	}
	public Agence(String nom, String adresse) {
		this.nom = nom;
		this.adresse = adresse;
	}
	public long getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(long identifiant) {
		this.identifiant = identifiant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public double getDebitAgence() {
		return debitAgence;
	}
	public void setDebitAgence(double debitAgence) {
		this.debitAgence += debitAgence;
	}
	public double getCreditAgence() {
		return creditAgence;
	}
	public void setCreditAgence(double creditAgence) {
		this.creditAgence += creditAgence;
	}
	
	public int getNbreClient() {
		return nbreClient;
	}
	public void setNbreClient(int nbreClient) {
		this.nbreClient = nbreClient;
	}
	public double soldeTotalParClient(int cin ) {
		double sm =  0;
		for(Compte cm : comptes) {
			if(cm.getClient().getCin() == cin )
				sm+=cm.getMontant();
		}
		return sm;
	}
	
	public double soldeTotalParClient(String nom, String prenom) {
		double sm =  0;
		for(Compte cm : comptes) {
			if(cm.getClient().getNom() == nom && cm.getClient().getPrenom() == prenom )
				sm+=cm.getMontant();
		}
		return sm;
	}
	@Override
	public String toString() {
		return "Agence [identifiant=" + identifiant + ", nom=" + nom + ", adresse=" + adresse + ", nbreClient="
				+ nbreClient + ", debitAgence=" + debitAgence + ", creditAgence=" + creditAgence + ", comptes="
				+ Arrays.toString(comptes) + "]";
	}
	
}
