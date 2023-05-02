package ilu2;

public class Welcome {
	
	public static StringBuilder plusDeDeuxNomInput(String[] names,StringBuilder resultat) {
		for (String name : names) {
			resultat.append(", ");
			resultat.append(name.substring(0, 1).toUpperCase() + name.substring(1));
		}
		return resultat;
	}

	public static StringBuilder crisAvecPlusieursNoms(String[] names,StringBuilder resultat) {
		for (String name : names) {
			if(!name.equals(name.toUpperCase())) {
				resultat.append(", ");
				resultat.append(name.substring(0, 1).toUpperCase() + name.substring(1));
			}
		}
		resultat.append(". AND HELLO");
		for (String name : names) {
			if(name.equals(name.toUpperCase())) {
				resultat.append(", ");
				resultat.append(name.substring(0, 1).toUpperCase() + name.substring(1));

			}
		}
		resultat.append(" !");
		return resultat;
	}

	public static StringBuilder plusieursNomInput(String[] names,StringBuilder resultat) {
		resultat.append("Hello");
		boolean isNameMaj=false;
		for (String i : names) {				
			if(i.equals(i.toUpperCase())) {
				isNameMaj=true;
			}
		}
		if(names.length>=2 && isNameMaj) {
			resultat=crisAvecPlusieursNoms(names, resultat);
		}else if(names.length==2) {
			resultat.append(", "+names[0].substring(0, 1).toUpperCase() + names[0].substring(1)+", "+names[1].substring(0, 1).toUpperCase() + names[1].substring(1));
		}else if(names.length>2) {
			resultat=plusDeDeuxNomInput(names,resultat);
		}
		return resultat;
	}
	
	public static String welcome(String input) {
		StringBuilder resultat = new StringBuilder();
		if(input== null || input.isEmpty() || input.isBlank()) {
			resultat.append("Hello, my friend");
		}else if(input.equals(input.toUpperCase())) {
			resultat.append("HELLO, "+input);
		}else if(input.split(",").length==1) {
			resultat.append("Hello, "+input.substring(0, 1).toUpperCase() + input.substring(1));
		}else {
			input=input.replaceAll(" ","");
			String[] names=input.split(",");

			resultat=plusieursNomInput(names, resultat);
		}
		return resultat.toString();
	}
}
