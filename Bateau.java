public class Bateau {

	private int id;
	private String nom;
	private Case[][] tableau;

	public Bateau(int id, String nom, Case[][] tableau) {
		this.id = id;
		this.nom = nom;
		this.tableau = tableau;
	}

	public boolean estCoulee( int ligne ,int colonne ) {
		
		if (this.tableau[ligne][colonne].getTouched()) {
			return true;
		} else {
			return false;
		}
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

	// public static void main(String[] args) {
		


	// Case[][] tableau = new Case[3][1];
	// for (int i = 0; i < tableau.length; i++) {
	// 	for (int j = 0; j < tableau[i].length; j++) {
	// 		tableau[i][j] = new Case(i,j);
	// 	}
	// }

	// Bateau bateau = new Bateau(1, "Titanic", tableau);

	// System.out.println("ID: " + bateau.getId());
	// System.out.println("Nom: " + bateau.getNom());
	// System.out.println("Taille du bateau: " + bateau.getTailleBateau());

	// // Test estCoulee method
	// System.out.println("Est coulé (0,0): " + bateau.estCoulee(0, 0));
	// bateau.getCase(0, 0).setTouchee();
	// System.out.println("Est coulé (0,0) après toucher: " + bateau.estCoulee(0, 0));
	// }
}