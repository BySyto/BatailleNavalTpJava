import java.io.IOException;

public class JoueurHumain extends Joueur {

    public JoueurHumain() {
        super();
        initialiserNom();
    }

    @Override
    public void placerBateaux() {
        System.out.println("Placement des bateaux pour1" + getNom());
        String[][] specs = Configuration.getBateaux();
        for (String[] spec : specs) {
            int id = Integer.parseInt(spec[0]);
            String nom = spec[1];
            int taille = Integer.parseInt(spec[2]);
            Case[][] cases = new Case[taille][1];
            for (int i = 0; i < taille; i++) {
                cases[i][0] = new Case(i, 0); // Initialisation des cases du bateau
            }
            Bateau bateau = new Bateau(id, nom, cases);
            boolean placed = false;
            while (!placed) {
                try {
                    System.out.println("Entrez les coordonnées de départ pour le bateau " + nom + " (taille " + taille + ") sous la forme x y:");
                    int x = Integer.parseInt(getReader().readLine());
                    int y = Integer.parseInt(getReader().readLine());
                    if (!getPlateau().verifierCollision(cases, x, y) && !getPlateau().verifierDepassement(cases, x, y)) {
                        getPlateau().ajoutezBateau(bateau, x, y);
                        placed = true;
                    } else {
                        System.out.println("Collision ou dépassement détecté. Veuillez réessayer.");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void tirerSur(Joueur adversaire) {
        boolean tirReussi = false;
        while (!tirReussi) {
            try {
                System.out.println("Entrez les coordonnées de tir sous la forme x y:");
                int x = Integer.parseInt(getReader().readLine());
                int y = Integer.parseInt(getReader().readLine());
                Case cible = adversaire.getPlateau().getCase(x, y);
                if (!cible.getTouched()) {
                    cible.setTouchee();
                    setDerniereCaseFrappee(cible);
                    incrementerFrapperTotales();
                    if (cible.getBateauId() != 0) {
                        incrementerFrapperReussies();
                        // Vérifiez si le bateau est coulé
                        Bateau bateau = adversaire.getPlateau().getBateau(cible.getBateauId());
                        if (bateau.estCoulee(x,y)) {
                            incrementerBateauxCoules();
                        }
                        System.out.println("Touché! Bateau ID: " + cible.getBateauId());
                    }else 
                        System.out.println("Manqué!");
                    tirReussi = true;
                } else {
                    System.out.println("Cette case a déjà été touchée. Veuillez réessayer.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialiserNom() {
        try {
            System.out.println("Entrez le nom du joueur:");
            setNom(getReader().readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}