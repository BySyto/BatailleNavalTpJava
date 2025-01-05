import java.util.Random;

public class JoueurOrdi extends Joueur {

    private Random random;

    public JoueurOrdi() {
        super();
        this.random = new Random();
        initialiserNom();
    }

    @Override
    public void placerBateaux() {
        // Implémentation pour placer les bateaux de manière aléatoire
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
                int x = random.nextInt(10);
                int y = random.nextInt(10);
                if (!getPlateau().verifierCollision(cases, x, y) && !getPlateau().verifierDepassement(cases, x, y)) {
                    getPlateau().ajoutezBateau(bateau, x, y);
                    placed = true;
                }
            }
        }
    }

    @Override
    public void tirerSur(Joueur adversaire) {
        // Implémentation pour tirer sur un joueur adverse de manière aléatoire
        boolean tirReussi = false;
        while (!tirReussi) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
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
                    }System.out.println("ALLIE TOUCHE! Bateau ID: " + cible.getBateauId());

                }else System.out.println("L'ennemi vous a Manqué!");
                tirReussi = true;
            }
        }
    }

    @Override
    public void initialiserNom() {
        setNom("Ordinateur");
    }
}