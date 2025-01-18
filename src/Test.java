import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws IOException {
        boolean boucle = true;
        while(boucle){
        System.out.println("DEBUG CLASSE TEST(suffit de mettre le nom de la classe, pour Joueur les deux classes sont testé en même temps)");
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choix = reader.readLine();
        switch (choix) {
            case "Configuration":
                testConfiguration();
                break;
            case "Case":
                testCase();
                break;
            case "Bateau":
                testBateau();
                break;
            case "Plateau":
                testPlateau();
                break;
            case "Joueur":
                testJoueur();
                break;
            case "Partie":
                testPartie();
                break;
            case "Menu":
                testMenue();
                break;
            default:
                boucle = false;
                break;
            }
            
        }
    }

    static void testConfiguration() {
        for (int i = 1; i <= Configuration.getNombreBateaux(); i++) {
            System.out.println(Configuration.getDescriptionBateau(i));
        }
        System.out.println("Nombre de Bateaux : "+Configuration.getNombreBateaux());
        System.out.println("Taille de la grille : "+Configuration.getTailleGrille());
    }

    static void testCase() {
        Case c = new Case(1, 2);
        System.out.println("Colonne : "+c.getColonne());
        System.out.println("Ligne : "+c.getLigne());
        System.out.println("est Touché ? : "+c.getTouched());
        System.out.println("Id du bateau : "+c.getBateauId());
        c.setBateauId(3);
        System.out.println("Id du bateau après modif : "+c.getBateauId());
        c.setTouchee();
        System.out.println("est Touché ? après modif : "+c.getTouched());
    }

    static void testBateau() {
        Case[][] tableau = new Case[3][1];
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                tableau[i][j] = new Case(i, j);
            }
        }

        Bateau bateau = new Bateau(1, "GroBato", tableau);

        System.out.println("ID: " + bateau.getId());
        System.out.println("Nom: " + bateau.getNom());
        System.out.println("Taille du bateau: " + bateau.getTailleBateau());

        // Test estCoulee method
        System.out.println("Est coulé (0,0): " + bateau.estCoulee());
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                bateau.getCase(i, j).setTouchee();
            }
        }
        System.out.println("Est coulé (0,0) après toucher: " + bateau.estCoulee());

    }

    static void testPlateau() {
        Joueur joueur1 = new JoueurHumain();
        Joueur joueur2 = new JoueurOrdi();

        Case[][] cases1 = { { new Case(0, 0) }, { new Case(1, 0) }, { new Case(2, 0) } };
        Bateau bateau1 = new Bateau(1, "Bateau1", cases1);
        joueur1.getPlateau().ajoutezBateau(bateau1, 0, 0, "V");

        Case[][] cases2 = { { new Case(0, 0) }, { new Case(1, 0) }, { new Case(2, 0) }, { new Case(3, 0) } };
        Bateau bateau2 = new Bateau(2, "Bateau2", cases2);
        joueur2.getPlateau().ajoutezBateau(bateau2, 4, 0, "H");

        Plateau plateau = new Plateau();
        plateau.afficherPlateauxTirs(joueur1, joueur2);
    }

    static void testJoueur() {

        Joueur joueur1 = new JoueurHumain();
        Joueur joueur2 = new JoueurOrdi();

        // Afficher les noms des joueurs pour vérifier qu'ils sont uniques
        System.out.println("Nom du joueur 1: " + joueur1.getNom());
        System.out.println("Nom du joueur 2: " + joueur2.getNom());

        // Initialiser les plateaux des joueurs
        joueur1.getPlateau().initialisationPlateau();
        joueur2.getPlateau().initialisationPlateau();

        // Afficher les plateaux initiaux
        System.out.println("Plateau du joueur 1:");
        joueur1.getPlateau().afficherPlateau();
        System.out.println("Plateau du joueur 2:");
        joueur2.getPlateau().afficherPlateau();

        // Simuler des tirs entre les joueurs
        joueur1.tirerSur(joueur2);
        joueur2.tirerSur(joueur1);

        // Afficher les plateaux après les tirs
        System.out.println("Plateau du joueur 1 après les tirs:");
        joueur1.getPlateau().afficherPlateau();
        System.out.println("Plateau du joueur 2 après les tirs:");
        joueur2.getPlateau().afficherPlateau();

    }
    static void testPartie() throws IOException{
        Partie partie = new Partie();
		partie.initialiserPartie();
	    partie.jouerPartie();




    }


    static void testMenue() {
        Menu menue = new Menu();
        menue.afficherMenu();
    }

}