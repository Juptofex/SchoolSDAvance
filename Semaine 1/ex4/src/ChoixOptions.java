import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ChoixOptions {
	
	// associe le nom d'une option avec son objet Option correspondant
	private Map<String, Option> options;
	// ajouter ici les autres attributs
	private Map<Etudiant, String[]> preferences;
	
	//constructeur prenant un entier et une suite de string en param�tres
	//ces string repr�sentent les noms des diff�rentes options possibles
	public ChoixOptions(int nbEtudiantsParOption, String... nomsOption) {
		this.options = new HashMap<String, Option>();
		if (nomsOption.length < 3)
			throw new IllegalArgumentException();
		for (int i = 0; i < nomsOption.length; i++) {
			String nomOption = nomsOption[i];
			options.put(nomOption, new Option(nomOption, nbEtudiantsParOption));
		}
		// initialiser les nouveaux attributs
		preferences = new TreeMap<Etudiant, String[] >(Comparator.comparingInt(Etudiant::getMoyenne)
				.reversed());
	}

	// cette m�thode encode les pr�f�rences des �tudiants
	// il ne faut pas v�rifier que ces choix soient valides
	public void ajouterPreferences(Etudiant etu, String choix1, String choix2,
			String choix3) {
		preferences.put(etu, new String[]{choix1, choix2, choix3});
	}

	// cette m�thode est appel�e apr�s que les �tudiants aient donn� leurs pr�f�rences
	// cette m�thode attribue les options aux �tudiants en favorisant les �tudiants 
	// ayant les meilleures moyennes si il n'y a plus de place disponible dans certaines 
	// options. Pour les �tudiants faibles, si les deux premi�res options sont pleines, 
	// il faut recourir au troisi�me choix.
	// Cette m�thode doit faire appel � la m�thode inscrireEtudiant de la classe Option.
	public void attribuerOptions() {
		for (Map.Entry<Etudiant, String[]> etudiantEntry: preferences.entrySet()) {
			Etudiant et = etudiantEntry.getKey();
			for (String option: etudiantEntry.getValue()) {
				Option opt = options.get(option);
				if (opt.inscrireEtudiant(et))
					break;
			}
		}
	}
	
	public String toString(){
		String s="";
		for (Option o:options.values()){
			s=s+o+"\n"+"-----------------"+"\n";
		}
		return s;
	}
}
