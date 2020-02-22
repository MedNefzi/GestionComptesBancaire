package Gestion.Banque;

import Gestion.Banque.Exceptions.SoldeEnRougeException;
import Gestion.Banque.Exceptions.SoldeNegatifException;

public abstract class Compte implements Comparable{
	protected long RIB;
	protected Client client;
	protected Agence agence;
	protected double montant;
	public Compte(){
		
	}
	
	public Compte(long rIB, Client client, Agence agence, double montant) throws SoldeNegatifException{
		this.RIB = rIB;
		this.client = client;
		this.agence = agence;
		if(montant <0)
			throw new  SoldeNegatifException("Erreur : Solde négative");
		this.montant = montant;
	}
	
	public Compte(long rIB, Client client, Agence agence){
		this.RIB = rIB;
		this.client = client;
		this.agence = agence;
	}
	
	public long getRIB() {
		return RIB;
	}

	public void setRIB(long rIB) {
		RIB = rIB;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) throws SoldeNegatifException {
		if(montant <0)
			throw new  SoldeNegatifException("Erreur : Solde négative");
		this.montant = montant;
	}

	public abstract void versement(double m) ;
	
	public abstract boolean retrait(double r) throws SoldeNegatifException,SoldeEnRougeException;
	
	public abstract void virement(double m, Compte c)throws SoldeNegatifException,SoldeEnRougeException;
	
	public int compareTo(Object o) {
		if (o instanceof Compte)
			if (montant <= ((Compte)o).montant)
				return 1;
			else
				return -1;
	return 0;
	}
	
	public static boolean compareSoldes(Compte c1, Compte c2) {
		return c1.getMontant() > c2.getMontant();
	}
	
	public static Compte triCompte(Compte c1, Compte c2) {
		if(compareSoldes(c1,c2) == true)
			return c1;
		return c2;
	}

}
