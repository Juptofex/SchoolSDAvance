import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Ordonnancement {
	public static final int NIVEAU_PRIORITE_MAX=5;
	private Map<Integer, Deque<Tache>> taches;

	public Ordonnancement(){
		taches = new HashMap<Integer, Deque<Tache>>();
		for (int i = 1; i <= NIVEAU_PRIORITE_MAX; i++) {
			taches.put(i, new ArrayDeque<Tache>());
		}
	}
	public void ajouterTache (String descriptif, int priorite){
		taches.get(priorite).add(new Tache(descriptif,priorite)) ;
	}
	
	//renvoie la tache la plus prioritaire
	//renvoie null si plus de tache presente
	public Tache attribuerTache(){
		for (int i = NIVEAU_PRIORITE_MAX; i >= 1; i--) {
			if (!taches.get(i).isEmpty()) {
				return taches.get(i).pop();
			}
		}
		return null;
	}
}
