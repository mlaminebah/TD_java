package td3;
/**BAH Mamadou Lamine
 * M1 Miage TD3
 *
 */
public class Product {
	private String nom;
	private double prix;
	private int id;
	private static int nextId = 0;
	
	public Product (String nom,double prix) {
		this.nom = nom;
		this.prix = prix;
		this.id = this.nextId;
		this.nextId += 1;
	}
	
	public Product (String nom,double prix,int id) {
		this.nom = nom;
		this.prix = prix;
		this.id = id;
	}
	
	public String getNom () {return this.nom;}
	public double getPrix () {return this.prix;}
	public int getId () {return this.id;}
	
	public String toString () {
		return "["+this.id+"/ "+this.nom+"/ "+this.prix+" euros]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + id;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Product)) return false;
		Product p = (Product) obj;
		return this.getNom() == p.getNom() && this.getPrix() == p.getPrix();
	}
	
}
