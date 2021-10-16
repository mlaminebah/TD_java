package td3;

import java.util.HashMap;

/**BAH Mamadou Lamine
 * M1 Miage TD3
 */
public class Basket {
	private Catalog catalog;
	private HashMap <Integer,Integer> reservs;
	
	public Basket (Catalog cat) {
		this.catalog = cat;
		this.reservs = new HashMap <Integer,Integer> ();
	}
	
	public void inc (int id,int qte) {
		int stock = this.catalog.qteStock(id);
		if (stock >= qte) {
			/*System.out.println (stock);
			this.reservs.put(id,qte+this.reservs.get(id));
			int actu = this.reservs.get(id);
			System.out.println (actu);*/
			
			if (!this.reservs.containsKey(id)) this.reservs.put(id,qte);
			else this.reservs.replace (id,this.reservs.get(id),this.reservs.get(id)+qte);
			dec (id,qte);
		} else {
			System.out.println ("Le stock est insuffisant");
			System.exit(-1);
		}
	}
	//pousse le catalog à faire une mise à jour de son stock
	private void dec (int id,int qte) {
		this.catalog.modifieStock(id, qte);
	}
	
	public String toString () {
		String s = new String ();
		s = "*******Le panier*******[\n";
		for (Integer id : this.reservs.keySet() ) {
			s += this.reservs.get(id)+" x "+this.catalog.getProductById(id).toString()+",\n";
		}
		s += "]*********************";
		return s;
	}
}
