package ilu2;

public class Welcome {
	public static StringBuilder plusieursNomInput(String[] names,StringBuilder resultat) {
		resultat.append("Hello");
		for (String name : names) {
			resultat.append(", ");
			resultat.append(name.substring(0, 1).toUpperCase() + name.substring(1));
		}
		return resultat;
	}

	public static String welcome(String input) {
		StringBuilder resultat = new StringBuilder();
		if(input== null || input.isEmpty() || input.isBlank()) {
			resultat.append("Hello, my friend");
		}else if(input.equals(input.toUpperCase())) {
			resultat.append("HELLO, "+input);
		}else {
			input=input.replaceAll(" ","");
			String[] names=input.split(",");
			if(names.length==2) {
				resultat.append("Hello, "+names[0].substring(0, 1).toUpperCase() + names[0].substring(1)+", "+names[1].substring(0, 1).toUpperCase() + names[1].substring(1));
			}else if(names.length>2) {
				resultat=plusieursNomInput(names,resultat);
			}else{			
				resultat.append("Hello, "+input.substring(0, 1).toUpperCase() + input.substring(1));
			}
		}
		return resultat.toString();
	}
}
