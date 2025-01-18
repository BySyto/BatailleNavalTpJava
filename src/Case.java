public class Case {

	private int colonne_id;
	private int ligne_id;
	private Boolean touched;
	private int bateau_id;

	public Case(int ligne, int colonne) {

		
		this.ligne_id = ligne;
		this.colonne_id = colonne;
		this.touched = false;
		this.bateau_id = 0;

	}

	public int getColonne() {
		return this.colonne_id;
	}

	public int getLigne() {
		
		return this.ligne_id;
	}

	public boolean getTouched() {
		return this.touched;
	}

	public int getBateauId() {
		return this.bateau_id;
	}

	public void setBateauId(int id) {
		this.bateau_id = id;

	}

	public void setTouchee() {
		this.touched = true;
	}


}