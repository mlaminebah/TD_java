package td3;
/**BAH Mamadou Lamine
 * M1 Miage TD3
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			Catalog catalog = Catalog.getInstance();
			int p0 = catalog.addProduct("chausset",2.50,3),
				p1 = catalog.addProduct("chemise",2.80,4),
				p2 = catalog.addProduct("chaussure",2.50,5),
				p3 = catalog.addProduct("chemisette",2.85,4);
				//p4 = catalog.addProduct("chemisette",2.85,4); lève une exception
			
		
			Basket panier_1 = new Basket (catalog);
			Basket panier_2 = new Basket (catalog);
			Basket panier_3 = new Basket (catalog);
			
			panier_1.inc(p0, 2);
			panier_2.inc(p0, 1);
			panier_1.inc(p1, 1);
			catalog.setPrice(p0, 2.55);//le catalog modifie le prix
			panier_2.inc(p2, 3);
			panier_2.inc(p1, 1);
			panier_1.inc(p1, 1);
			//panier_3.inc(p0, 1);//Stock insuffisants
			
			System.out.println ("Panier 1:");
			System.out.println (panier_1);
			System.out.println ("Panier 2:");
			System.out.println (panier_2);
			
			System.out.println ("****le catalog*****");
			System.out.println (catalog);//équivaut à System.out.println(catalog);
			
			/*** Q3-a)
			 * À cet stade il n'est pas possible de mofidier ni le nom du produit ni son produit
			 * Les attributs de produit sont privés et aucune méthode set n'est authorisée
			 */
			/*** Q4) 
			 * Solution 1 : une première solution est de créer directement un nouveau produit du même nom que celui que l'on veut 
			 * 	modifier le prix tout en changeant le prix . Le problème est que cette solution provoque des problèmes
			 * car à chaque création d'un objet Product un nouveau id lui est attribué . Et cela provoque des confusions car 
			 * on sera amené à supprimer l'ancien produit avec son id qui est utilisé par d'autres paniers.Ces paniers feront donc
			 * référence à des produits qui n'existe plus.
			 * Solution 2 : avoir un noveau constructeur dans la classe Product qui va conserver l'id du produit
			 * qu'on veut modifier pour éviter la confusion 
			 */
			
	}

}
