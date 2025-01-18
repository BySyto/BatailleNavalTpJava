public class Bateau {

	private int id;
	private String nom;
	private Case[][] tableau;

	public Bateau(int id, String nom, Case[][] tableau) {
		this.id = id;
		this.nom = nom;
		this.tableau = tableau;
	}

	public boolean estCoulee() {
		for (Case[] casesLigne : tableau) {
			for (Case c : casesLigne) {
				if (!c.getTouched()) {
					return false;
				}
			}
		}
		return true;
	}
	

	
	public Case getCase(int ligne , int colonne) {
		return this.tableau[ligne][colonne];
	}

	public int getTailleBateau() {
		
		return this.tableau.length;
	}

	public int getId() {
		return this.id;
	}

	public String getNom() {
		return this.nom;
	}

	public Case[][] getTableau() {
		return this.tableau;
	}

}