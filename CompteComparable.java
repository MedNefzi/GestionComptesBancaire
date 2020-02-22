package Gestion.Banque;

import java.util.*;

public class CompteComparable {

	public static void main(String[] args) {
		Vector comptes = new Vector();
		
      /**** Cr�ation de clients */
		
        //Client c1 = new Client(80702045, "Ali", "BenSalah");
       // Client c2=new Client(75745742, "Mohamed", "Nefzi");
       
        /* Cr�ation d'agence***/
        
        Agence a=new Agence("AgenceBT", "Cit� ABC, Rue CDE, N�20");
        
        /*Cr�ation d'un tableau de comptes */
        
        /*comptes.add(new Compte(2013654789630214587L, c1,a));
		comptes.add(new CompteSalarie(2778844585112687485L,c1, a, 2000));
        comptes.add(new CompteEpargne(277884458511267485L, c1, a, new Date(2019, 10, 2))); // le dernier champs est la date de cr�ation de compte
        
        comptes.add(new CompteVIP(2778844585112685L,c2,a, "ABCDEF", 20, 500000));
        comptes.add(new CompteEpargne(Long.MIN_VALUE, c1, a, new Date()));
        comptes.add(new CompteEpargne(Long.MIN_VALUE, c1, a, new Date(2018,11,2)));
        
        // tester les op�rations bancaires sur un compte normal 
        
        ((CompteAbstrait) comptes.elementAt(0)).versement(1000);
        
        // tester les op�rations bancaires sur un compte �pargne
        
        ((CompteAbstrait) comptes.elementAt(2)).versement(10);
         
        ((CompteAbstrait) comptes.elementAt(4)).versement(10);
        
        ((CompteAbstrait) comptes.elementAt(5)).versement(10);
        
        // tester les op�rations bancaires sur un compte VIP 
        
        ((CompteAbstrait) comptes.elementAt(5)).versement(1000);
        
        for(int i = 0; i<comptes.size();i++) {
			System.out.println(comptes.elementAt(i));
		}
		Vector vRes = Trieuse.triInsertion(comptes);
		
		System.out.println(" Apr�s Tri");
		for(int i = 0; i<vRes.size();i++) {
			System.out.println(vRes.elementAt(i));*/
		

	}

}
