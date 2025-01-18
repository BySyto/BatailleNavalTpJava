import java.io.*;
public abstract class Joueur {

	private String nom;
	private Plateau plateau;
	private int frappesTotales;
	private int frappesReussies;
	private int bateauxCoules;
	private Case derniereCaseFrappee;
	private BufferedReader reader;

	public Joueur() {
		this.plateau = new Plateau();
        this.frappesTotales = 0;
        this.frappesReussies = 0;
        this.bateauxCoules = 0;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
	}
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Plateau getPlateau() {
		return this.plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public int getFrappesTotales() {
		return this.frappesTotales;
	}



	public int getFrappesReussies() {
		return this.frappesReussies;
	}


	public int getBateauxCoules() {
		return this.bateauxCoules;
	}


	public Case getDerniereCaseFrappee() {
		return this.derniereCaseFrappee;
	}

	public void setDerniereCaseFrappee(Case derniereCaseFrappee) {
		this.derniereCaseFrappee = derniereCaseFrappee;
	}

	public BufferedReader getReader() {
		return this.reader;
	}

	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}

	public void incrementerFrapperTotales() {
		this.frappesTotales++;
	}

	public void incrementerFrapperReussies() {
		this.frappesReussies++;
	}

	public void incrementerBateauxCoules() {
		this.bateauxCoules++;
	}

	public void recapStatJoueur() {
		System.out.println("Nom: " + getNom());
        System.out.println("Frappes Totales: " + getFrappesTotales());
        System.out.println("Frappes Réussies: " + getFrappesReussies());
        System.out.println("Bateaux Coulés: " + getBateauxCoules());
	}

	public abstract void placerBateaux();
	public abstract void tirerSur(Joueur adversaire);
    public abstract void initialiserNom();
}