import java.util.Random;

public class Partie {

	private Joueur joueur1;
	private Joueur joueur2;
	private int prochainAJouer;
	private String vainqueur;

	public void initialiserPartie() {
		joueur1 = new JoueurHumain();
		joueur2 = new JoueurOrdi();
		prochainAJouer = PremierJoueurRandom();
		vainqueur = null;

	



	}

	public void jouerPartie() {
		

	}

	public boolean verifierPartieTerminee() {
		
		if (getVainqueur()==null) {
			return false;
		} else {
			return true;
		}
	}

	public String getVainqueur() {
		return this.vainqueur;
	}

	public int PremierJoueurRandom() {
		Random rand = new Random();
		if (rand.nextInt(1)==0) {
			return 1;
		} else {
			return 2;
		}
	}
}