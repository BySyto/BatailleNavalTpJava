import java.io.*;
public class Menu {

	private BufferedReader reader;

	public Menu() {
		this.reader = new BufferedReader(new InputStreamReader(System.in));
	}

	public void lancerPartie() {
		Partie partie = new Partie();
		try {
			partie.initialiserPartie();
			partie.jouerPartie();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void quitter() {
		System.out.println("Merci d'avoir joué à mon jeu de bataille navale");
		System.exit(0);
		
	}

	public void afficherMenu() {
		System.out.println("Bienvenue dans mon jeu de bataille navale");
		System.out.println("1. Lancer une partie");
		System.out.println("2. Afficher les règles");
		System.out.println("3. Quitter");
		System.out.println("Veuillez choisir une option : ");
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			String choix = reader.readLine();
			switch(choix) {
				case "1":
					lancerPartie();
					break;
				case "2":
					afficherRegles();
					break;
				case "3":
					quitter();
					break;
				default:
					System.out.println("Veuillez choisir une option valide");
					afficherMenu();
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void afficherRegles() {

		System.out.println("Les règles sont simples :");
		System.out.println("Chaque joueur place ses bateaux sur une grille de 10x10");
		System.out.println("Chaque joueur a 5 bateaux :");
		System.out.println("  1 Porte-Avion (5 cases)");
		System.out.println("  1 Cuirassé (4 cases)");
		System.out.println("  2 Croiseurs (3 cases)");
		System.out.println("  1 torpilleur (2 cases)");
		System.out.println("Les joueurs jouent à tour de rôle");
		System.out.println("Le premier joueur à couler tous les bateaux de l'adversaire gagne");
		afficherMenu();
	}

}