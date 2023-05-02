package ilu2;

public class Welcome {

	public static String welcome(String input) {
		StringBuilder resultat = new StringBuilder();
		if(input== null || input.isEmpty() || input.isBlank()) {
			resultat.append("Hello, my friend");
		}else {		
			resultat.append("Hello, "+input.substring(0, 1).toUpperCase() + input.substring(1));
		}
		return resultat.toString();
	}
}
