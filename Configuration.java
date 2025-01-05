public abstract class Configuration {

	private static final String[][] bateaux = {
        {"1", "Porte-avions", "5"},
        {"2", "Cuirasse", "4"},
        {"3", "Croiseur", "3"},
        {"4", "Croiseur", "3"},
        {"5", "Torpilleur", "2"}
    };
	private static int tailleGrille = 10;

	public static String[][] getBateaux() {
		return bateaux;
	}


	public static String getDescriptionBateau(int id) {	
		int i = 0 ;
		String description	= "Bateau non trouvé";
		while (i < bateaux.length ) {
			if (Integer.parseInt(bateaux[i][0]) == id) {
				description= "ID: " + bateaux[i][0] + ", Nom: " + bateaux[i][1] + ", Taille: " + bateaux[i][2];
		}
			i++;
		}
		return description;
	}

	public static int getNombreBateaux() {
		return bateaux.length;
	}

	public int getTailleGrille() {
		return tailleGrille;
	}
	// public static void main(String[] args) {
		
	// 		for(int i = 1; i <= bateaux.length; i++) {
	// 			System.out.println(getDescriptionBateau(i));
	// 		}
			


	// }
}

