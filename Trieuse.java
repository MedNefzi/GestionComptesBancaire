package Gestion.Banque;

import java.util.Vector;

public class Trieuse {
	public static Vector triInsertion(Vector v) {
	Vector res = new Vector();
	int i,p;
	for(i=0; i<v.size();i++) {
		Comparable elti = (Comparable) v.elementAt(i);
		p=0;
		while(p < res.size() && (elti.compareTo(res.elementAt(p)) == -1))
			p++;
		res.insertElementAt(elti, p);
	}
	return res;
	}

}
