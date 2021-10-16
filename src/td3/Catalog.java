package td3;

/**BAH Mamadou Lamine
 * M1 Miage TD3
 */

import java.util.HashMap;
import java.util.HashSet;

public class Catalog {
	private HashSet <Product> produits;
	private HashMap <Integer,Integer> quantites;
	private static Catalog instance = null;
	
	
	private Catalog () {
		produits = new HashSet <Product> ();
		quantites = new HashMap <Integer,Integer> ();
	}
	
	public static Catalog getInstance () {
		if (instance == null) {	
			instance = new Catalog ();
		}
		return instance;
	}
	
	public int addProduct (String nom,double prix,int quantite) throws Exception {
		Product p = new Product (nom,prix);
		int id = 0;
		//boolean res = produits.add(p);
		//System.out.println (p.getPrix());
		if (!produits.add(p)) {
			throw new Exception ("Produit existant déjà");
		}
		id = p.getId();
		quantites.putIfAbsent(id, quantite);
		return id;
	}
	
	//renvoie la valeur de la clé id fourni de la HashMap
	public int qteStock (int id) {
		return this.quantites.get (id);
	}
	//cette méthode modifie le stock associée à la clé
	public void modifieStock (int id,int qte) {
		this.quantites.replace(id,this.quantites.get(id),this.quantites.get(id) - qte);
	}
	@Override
	public String toString() {
		String prod = new String ();
		prod = "******Le catalog******[\n";
		for (Product p : this.produits) {
			prod += p.toString()+" : "+this.qteStock(p.getId())+",\n";
		}
		//prod += "]";
		return prod+"]****************";
	}
	
	public Product getProductById (int id) {
		Product p1 = null;
		for (Product p: this.produits) {
			if (p.getId() == id) p1 = p;
		}
		return p1;
	}
	//reponse de la question 4) les explications sont dans le main
	public void setPrice (int id,double prix) throws Exception {
		Product p =  new Product (this.getProductById(id).getNom(),prix,id);
		if (this.produits.remove(this.getProductById(id))) {
			//System.out.println (p.getPrix());
			if (!produits.add(p)) {
				throw new Exception ("Produit existant déjà");
			}
		}
		
	}
}
