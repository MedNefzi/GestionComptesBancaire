package Gestion.Banque;

import Gestion.Banque.Exceptions.SoldeEnRougeException;

public class CompteSalarie extends Compte{

	public CompteSalarie(){
		super();
		// nombre client
	}
	
	public CompteSalarie(long rIB, Client client, Agence agence){
		super(rIB,  client, agence);
		// nombre client
	}

	@Override
	public void versement(double m) {
		this.montant = this.montant + m;
		// credit
		
	}

	@Override
	public boolean retrait(double r) throws SoldeEnRougeException {
		double max_taux_retrait = ((ClientNormal)this.client).getSalaire()  * 0.005;
		if(this.montant - r > 0 ){
			this.montant-= r;
			// debit
			return true;
		}else if ( this.montant - r >=  max_taux_retrait ) {
			this.montant-= r;
			// debit
			return true;
		} 
		throw new SoldeEnRougeException(" Erreur : Opération de retrait d'argent incomplete vu salaire du client ");
	}

	@Override
	public void virement(double m, Compte c) throws SoldeEnRougeException {
		if(this.retrait(m) == false) 
			throw new SoldeEnRougeException(" Erreur : Opération de retrait d'argent incomplete ");
		c.versement(m);
			
	}

	public  boolean compareSoldes(Compte c1) {
		return this.montant > c1.getMontant();
	}
	
	public Compte triCompte(Compte c1) {
		if(compareSoldes(c1) == true)
			return c1;
		return this;
	}
	
	@Override
	public String toString() {
		return "CompteSalarie [RIB=" + RIB + ", client=" + client + ", agence="
				+ agence + ", montant=" + montant + "]";
	}
	

}
