package Gestion.Banque;

public class ClientNormal extends Client{
	
private String profession;
private double  salaire;

public ClientNormal(){
	super();
}

public ClientNormal(int cin, String nom, String prenom) {
	super(cin, nom, prenom);
}

public ClientNormal(int cin, String nom, String prenom, String profession) {
	super(cin, nom, prenom);
	this.profession=profession;
}

public ClientNormal(int cin, String nom, String prenom,double sa , String profession) {
	super(cin, nom, prenom);
	this.salaire=sa;
	this.profession=profession;
}


public ClientNormal(int cin, String nom, String prenom,double sa) {
	super(cin, nom, prenom);
	this.salaire=sa;
}

public String getProfession() {
	return profession;
}

public void setProfession(String profession) {
	this.profession = profession;
}


public double getSalaire() {
	return salaire;
}

public void setSalaire(double salaire) {
	this.salaire = salaire;
}

@Override
public String toString() {
	return "ClientNormal [profession=" + profession + ", CIN=" + getCin() + ", Nom=" + getNom()
			+ ", Prenom=" + getPrenom() + " salaire=" + salaire + "]";
}

}
