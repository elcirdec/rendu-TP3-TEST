package ilu2;

public class Welcome {

	public static StringBuilder plusDeDeuxNomInput(String[] names,StringBuilder resultat, int[] nbOccMots) {
		int nbMotEnMin=0;
		for (String i : names) {				
			if(!i.equals(i.toUpperCase())) {
				nbMotEnMin++;
			}
		}
		resultat=motsMinuscule(names, resultat, nbMotEnMin, nbOccMots);
		System.out.println(resultat.toString());
		return resultat;
	}

	public static StringBuilder motsMinuscule(String[] names,StringBuilder resultat,int nbMotsMinuscule,int[] nbOccMots) {
		int occMin=0;
		for (int i=0;i<names.length;i++) {
			if(!names[i].equals(names[i].toUpperCase())) {
				if(occMin==nbMotsMinuscule-1 && occMin!=0) {
					resultat.append(" and ");
				}else {
					resultat.append(", ");
				}						
				occMin++;
				if(nbOccMots[i]==1) {
					resultat.append(names[i].substring(0, 1).toUpperCase() + names[i].substring(1));
				}else {
					resultat.append(names[i].substring(0, 1).toUpperCase() + names[i].substring(1) + " (x"+nbOccMots[i]+")");
				}
			}
		}
		return resultat;
	}
	public static StringBuilder motsMajuscule(String[] names,StringBuilder resultat, int nbMotsMajuscule, int[] nbOccMots) {
		int occMaj=0;
		resultat.append(". AND HELLO");
		for (int i=0;i<names.length;i++) {
			if(names[i].equals(names[i].toUpperCase())) {
				if(occMaj==nbMotsMajuscule-1 && occMaj!=0) {
					resultat.append(" AND ");
				}else {
					resultat.append(", ");
				}		
				occMaj++;
				if(nbOccMots[i]==1) {
					resultat.append(names[i].substring(0, 1).toUpperCase() + names[i].substring(1));
				}else {
					resultat.append(names[i].substring(0, 1).toUpperCase() + names[i].substring(1) + " (x"+nbOccMots[i]+")");
				}
			}
		}
		resultat.append(" !");
		return resultat;
	}

	public static StringBuilder crisAvecPlusieursNoms(String[] names,StringBuilder resultat, int[] nbOccMots) {
		int nbMotEnMin=0;
		int nbMotEnMaj=0;
		for (String i : names) {				
			if(i.equals(i.toUpperCase())) {
				nbMotEnMaj++;					
			}else {
				nbMotEnMin++;
			}
		}
		resultat=motsMinuscule(names, resultat,nbMotEnMin,nbOccMots);
		resultat=motsMajuscule(names, resultat,nbMotEnMaj,nbOccMots);		
		System.out.println(resultat.toString());
		return resultat;
	}


	public static int[] nbOccMots(String[] names) {
		boolean visited[] = new boolean[names.length];
		int[] nbOccMots = new int[names.length];
		for (int i = 0; i < names.length; i++) {	 
			int occ = 1;
			if(visited[i]==false) {
				for (int j = i + 1; j < names.length; j++) {
					if (names[i].equals(names[j])) {	                
						occ++;
						visited[j]=true;
					}
				}
				nbOccMots[i]=occ;
			}
		}
		return nbOccMots;
	}

	public static String[] namesDistinct(String[] names) {
		int nbValeurDistinct=0;
		boolean visited[] = new boolean[names.length];
		for (int i = 0; i < names.length; i++) {	 
			if(visited[i]==false) {
				for (int j = i + 1; j < names.length; j++) {
					if (names[i].equals(names[j])) {	                
						visited[j]=true;
					}
				}
				nbValeurDistinct++;
			}
		}
		String[] namesDistinct= new String[nbValeurDistinct];
		for (int i = 0; i < names.length; i++) {	 
			if(visited[i]==false) {
				namesDistinct[i]=names[i];
			}
		}
		return namesDistinct;
	}
	public static StringBuilder plusieursNomInput(String[] names,StringBuilder resultat) {
		resultat.append("Hello");
		boolean isNameMaj=false;
		for (String i : names) {				
			if(i.equals(i.toUpperCase())) {
				isNameMaj=true;
			}
		}
		int[] nbOccMots = nbOccMots(names);
		String[] namesDistinct=namesDistinct(names);
		if(names.length>=2 && isNameMaj) {
			resultat=crisAvecPlusieursNoms(namesDistinct, resultat, nbOccMots);
		}else if(names.length==2) {
			resultat.append(", "+names[0].substring(0, 1).toUpperCase() + names[0].substring(1)+" and "+names[1].substring(0, 1).toUpperCase() + names[1].substring(1));
		}else if(names.length>2) {
			resultat=plusDeDeuxNomInput(namesDistinct,resultat,nbOccMots);
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
