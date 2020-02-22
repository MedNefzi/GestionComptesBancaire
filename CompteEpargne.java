package Gestion.Banque;

import java.util.Date;

import Gestion.Banque.Exceptions.SoldeNegatifException;

public class CompteEpargne extends Compte{
	private Date dateCreation;
	private double solde_mois ;
	private Date dat_dern_vers ;

	public CompteEpargne(){
		super();
		// Update nbre Client par agence
	}
	
	public CompteEpargne(long rIB, Client client, Agence agence, double montant) throws SoldeNegatifException {
		super(rIB,  client, agence, montant);
		this.dateCreation = new Date();
		this.dat_dern_vers=new Date();
		// Update nbre Client par agence
	}
	
	public CompteEpargne(long rIB, Client client, Agence agence , Date d) {
		super(rIB,  client, agence);
		this.dateCreation = d;
		this.dat_dern_vers=new Date();
		// Update nbre Client par agence
	}
	
	
	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getSolde_mois() {
		return solde_mois;
	}

	public void setSolde_mois(double solde_mois) {
		this.solde_mois = solde_mois;
	}

	public Date getDat_dern_vers() {
		return dat_dern_vers;
	}

	public void setDat_dern_vers(Date dat_dern_vers) {
		this.dat_dern_vers = dat_dern_vers;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void versement(double m) {
		Date date_courante=new Date() ;
		if  ((date_courante.getMonth() - dat_dern_vers.getMonth() == 0) && (date_courante.getYear() - dat_dern_vers.getYear() == 0)) {
			solde_mois+=m;
			dat_dern_vers=date_courante;
			this.montant = this.montant + m;
			// Update Credit Agence
			if(solde_mois < 20)
				System.out.println("il vous reste"+(20-solde_mois));
		}else {
			if(solde_mois >=20) {
				solde_mois=m;
				dat_dern_vers=date_courante;
				this.montant = this.montant + m;
				// Update Credit Agence
			}else
				System.out.println("Votre compte épargne est bloquée");
		}
	}

	@Override
	public boolean retrait(double r) throws SoldeNegatifException{
		if(((new Date().getTime() - dateCreation.getTime()) > (365*24*3600*1000)) && montant >= 2000){
			if(this.montant - r < 0 )
				throw new SoldeNegatifException("Erreur : Solde négative");
			this.montant-= r;
			// Update debit Agence
		}
		return true;
	}

	@Override
	public void virement(double m, Compte c) throws SoldeNegatifException {
		System.out.println("Pas de virement pour le compte VIP");
		/*if(this.retrait(m) == false) 
			throw new SoldeNegatifException("Erreur : Solde négative");
		this.retrait(m);
		c.versement(m);*/
	}
	@Override
	public String toString() {
		return "CompteEpargne [RIB=" + RIB + ", client=" + client + ", agence=" + agence + ", montant=" + montant + "]";
	}

	public  boolean compareSoldes(Compte c1) {
		return this.montant > c1.getMontant();
	}
	
	public Compte triCompte(Compte c1) {
		if(compareSoldes(c1) == true)
			return c1;
		return this;
	}
	
}
