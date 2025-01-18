import java.util.ArrayList;
import java.util.List;

public class Plateau {

    private Case[][] tableau;
    private int taille = 10;
    private List<Bateau> bateaux;

    public Plateau() {
        this.initialisationPlateau();
        this.bateaux = new ArrayList<>();
    }

    public void getTableau(Case[][] tableau) {
        this.tableau = tableau;
    }

    public void initialisationPlateau() {
        this.tableau = new Case[this.taille][this.taille];
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                tableau[i][j] = new Case(i, j);
            }
        }
    }

    public Case getCase(int ligne, int colonne) {
        return this.tableau[ligne][colonne];
    }

    public void ajoutezBateau(Bateau bateau, int ligne, int colonne, String sens) {
        Case[][] casesBateau = bateau.getTableau();

        // Vérifiez si le bateau peut être placé sans collision
        if (verifierCollision(casesBateau, ligne, colonne) || verifierDepassement(casesBateau, ligne, colonne)) {
            System.out.println("Collision ou dépassement détecté. Le bateau ne peut pas être placé.");
            return;
        }

        if ("V".equals(sens)) {
            for (int i = 0; i < casesBateau.length; i++) {
                for (int j = 0; j < casesBateau[i].length; j++) {
                    int x = ligne + i;
                    int y = colonne + j;
                    tableau[x][y] = casesBateau[i][j];
                    tableau[x][y].setBateauId(bateau.getId());
                }
            }
        } else if ("H".equals(sens)) {
            for (int i = 0; i < casesBateau.length; i++) {
                for (int j = 0; j < casesBateau[i].length; j++) {
                    int x = ligne + j;
                    int y = colonne + i;
                    tableau[x][y] = casesBateau[i][j];
                    tableau[x][y].setBateauId(bateau.getId());
                }

            }
        } 
        bateaux.add(bateau);
        System.out.println(bateau.toString());
    }

    public boolean verifierCollision(Case[][] casesBateau, int startX, int startY) {
        for (int i = 0; i < casesBateau.length; i++) {
            for (int j = 0; j < casesBateau[i].length; j++) {
                int x = startX + i;
                int y = startY + j;
                if (x >= taille || y >= taille || tableau[x][y].getBateauId() != 0) {
                    return true;
                }
                if ((x > 0 && tableau[x - 1][y].getBateauId() != 0) ||
                        (x < taille - 1 && tableau[x + 1][y].getBateauId() != 0) ||
                        (y > 0 && tableau[x][y - 1].getBateauId() != 0) ||
                        (y < taille - 1 && tableau[x][y + 1].getBateauId() != 0) ||
                        (x > 0 && y > 0 && tableau[x - 1][y - 1].getBateauId() != 0) ||
                        (x > 0 && y < taille - 1 && tableau[x - 1][y + 1].getBateauId() != 0) ||
                        (x < taille - 1 && y > 0 && tableau[x + 1][y - 1].getBateauId() != 0) ||
                        (x < taille - 1 && y < taille - 1 && tableau[x + 1][y + 1].getBateauId() != 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verifierDepassement(Case[][] casesBateau, int startX, int startY) {

        for (int i = 0; i < casesBateau.length; i++) {
            for (int j = 0; j < casesBateau[i].length; j++) {
                int x = startX + i;
                int y = startY + j;
                if (x >= taille || y >= taille) {
                    return true;
                }
            }
        }
        return false;
    }

    public void afficherPlateau() {
        System.out.print("  ");
        for (int i = 0; i < taille; i++) {
            System.out.print((char) ('A' + i) + " ");
        }
        System.out.println();
        for (int i = 0; i < tableau.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < tableau[i].length; j++) {
                if (tableau[i][j] != null && tableau[i][j].getBateauId() != 0) {
                    System.out.print(tableau[i][j].getBateauId() + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public void afficherPlateauxTirs(Joueur joueur, Joueur adversaire) {
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        System.out.print("  ");
        for (int i = 0; i < taille; i++) {
            System.out.print((char) ('A' + i) + " ");
        }
        System.out.println();
        for (int i = 0; i < tableau.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < tableau[i].length; j++) {
                Case caseAdversaire = adversaire.getPlateau().getCase(i, j);
                if (caseAdversaire != null && caseAdversaire.getTouched()) {
                    if (caseAdversaire.getBateauId() != 0) {
                        System.out.print(RED + "X " + RESET); // Touché
                    } else {
                        System.out.print(GREEN + "O " + RESET); // Manqué
                    }
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public Bateau getBateau(int id) {
        for (Bateau bateau : bateaux) {
            
            if (bateau.getId() == id) {
                return bateau;
            }
        }
        return null;
    }
}
