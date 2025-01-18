import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Partie {

	private Joueur joueur1;
	private Joueur joueur2;
	private int prochainAJouer;
	private String vainqueur;
	private BufferedReader reader;

	public Partie(){
		this.reader = new BufferedReader(new InputStreamReader(System.in));
	}

public void initialiserPartie() throws IOException {
        System.out.println("Choisissez le type de joueur pour Joueur 1 (1: Humain, 2: Ordinateur): ");
        int choix1 = Integer.parseInt(reader.readLine());
        joueur1 = (choix1 == 1) ? new JoueurHumain() : new JoueurOrdi();

        System.out.println("Choisissez le type de joueur pour Joueur 2 (1: Humain, 2: Ordinateur): ");
        int choix2 = Integer.parseInt(reader.readLine());
        joueur2 = (choix2 == 1) ? new JoueurHumain() : new JoueurOrdi();

        joueur1.placerBateaux();
        joueur2.placerBateaux();

        prochainAJouer = PremierJoueurRandom();
        vainqueur = null;
    }

	public void jouerPartie() {
        int i = 0 ;
		while (vainqueur == null) {
            Joueur joueurCourant = (prochainAJouer == 1) ? joueur1 : joueur2;
            Joueur adversaire = (prochainAJouer == 1) ? joueur2 : joueur1;


            joueurCourant.tirerSur(adversaire);
            

            if(i%2==0){
                System.out.println("-----------------------------------------------");
                
            }
            i++;

            

            if (getVainqueur(adversaire)) {
                vainqueur = adversaire.getNom();
            }else if (getVainqueur(joueurCourant)) {
				vainqueur = joueurCourant.getNom();
			}
			else {
                prochainAJouer = (prochainAJouer == 1) ? 2 : 1;
            }
            

        }

        finDePartie();
		

	}

	public void finDePartie() {
        System.out.println("Le vainqueur est: " + vainqueur);
        System.out.println("Statistiques du Joueur 1:");
        joueur1.recapStatJoueur();
        System.out.println("-----------------------------------------------");
        System.out.println("Statistiques du Joueur 2:");
        joueur2.recapStatJoueur();
    }

    public boolean getVainqueur(Joueur joueur) {;
		if (joueur.getFrappesReussies() == 17)
			return true;
		else
			return false;
    }

    public int PremierJoueurRandom() {
        Random random = new Random();
        return random.nextInt(2) + 1;
    }

    public static void main(String[] args) throws IOException {
        Partie partie = new Partie();
        partie.initialiserPartie();
        partie.jouerPartie();
    }
}