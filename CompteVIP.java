package Gestion.Banque;

import java.util.Date;

import Gestion.Banque.Exceptions.SoldeEnRougeException;
import Gestion.Banque.Exceptions.SoldeNegatifException;

public class CompteVIP extends Compte{

	public CompteVIP(){
		super();
	}
	
	public CompteVIP(long rIB, Client client, Agence agence, double montant, String nomEntreprise, double chiffreAffaire, int nombreEmploye) throws SoldeNegatifException {
		this.RIB = rIB;
		this.client = new ClientVIP(client.getCin(),client.getNom(), client.getPrenom());
		((ClientVIP) this.client).setNomEntreprise(nomEntreprise);
		((ClientVIP) this.client).setChiffreAffaire(chiffreAffaire);
		((ClientVIP) this.client).setNombreEmploye(nombreEmploye);
		this.agence = agence;
		if(montant <0)
			throw new  SoldeNegatifException("Erreur : Solde négative");
		this.montant = montant;
		// update  nombre client
	}
	
	public CompteVIP(long rIB, Client client, Agence agence, String nomEntreprise, double chiffreAffaire, int nombreEmploye) {
		this.RIB = rIB;
		this.client = new ClientVIP(client.getCin(),client.getNom(), client.getPrenom());
		((ClientVIP) this.client).setNomEntreprise(nomEntreprise);
		((ClientVIP) this.client).setChiffreAffaire(chiffreAffaire);
		((ClientVIP) this.client).setNombreEmploye(nombreEmploye);
		this.agence = agence;
		// update  nombre client
	}
	
	public CompteVIP(long rIB, Client client, Agence agence, String nomEntreprise, double chiffreAffaire) {
		this.RIB = rIB;
		this.client = new ClientVIP(client.getCin(),client.getNom(), client.getPrenom());
		((ClientVIP) this.client).setNomEntreprise(nomEntreprise);
		((ClientVIP) this.client).setChiffreAffaire(chiffreAffaire);
		this.agence = agence;
		// update  nombre client
	}

	@Override
	public void versement(double m) {
		this.montant+= m;
		// credit agence
	}

	@Override
	public boolean retrait(double r) throws SoldeEnRougeException {
		double max_taux_retrait=((ClientVIP) this.client).getChiffreAffaire() * 0.005;
		if(this.montant - r > 0){
			this.montant-= r;
			// debit agence
			return true;
		}else if ( this.montant - r >=  max_taux_retrait ) {
				this.montant-= r;
				// debit agence
				return true;
		} 
		throw new SoldeEnRougeException(" Erreur : Opération retrait incomplete vu le chiffre d'affaire ");
	}

	@Override
	public void virement(double m, Compte c) throws SoldeEnRougeException  {
		if(this.retrait(m) == false) 
			throw new SoldeEnRougeException(" Erreur : Opération de retrait d'argent incomplete ");
		this.retrait(m);
		c.versement(m);
	}

	@Override
	public String toString() {
		return "CompteVIP [RIB=" + RIB + ", client=" + client + ", agence=" + agence + ", montant=" + montant + "]";
	}
	
	public boolean prendUnPret(double mnt){
		double max_taux_pret = ((ClientVIP) this.client).getChiffreAffaire() * 0.3;
		if( mnt <= max_taux_pret ){
			// debit agence & banque 
			System.out.println(" Opération de prêt effectuée avec succées ");
			return true;
		}
		System.out.println(" Opération de prêt invalide vu le chiffre d'affaire ");
		return false;
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
