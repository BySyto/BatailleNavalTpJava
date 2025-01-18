package Support;

public class TraitementCoordonnee {

	/**
	 * 
	 * @param coord
	 */
	public static String CoordonneeLettreversNombre ( String coord ) {
		return String . valueOf ( new String ( " ABCDEFGHIJ " ) . indexOf ( coord ) ) ;
		}

	/**
	 * 
	 * @param coord
	 */
	public static String coordonneeNombreVersLettre ( int coord ) {
		String [] lettres = { " A " , " B " , " C " , " D " , " E " , " F " , " G " , " H " , " I " ,
		" J " };
		return lettres [ coord ];
		

}
}