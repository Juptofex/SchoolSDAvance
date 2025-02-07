import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ControleDAcces {

	private Map<Badge, Employe> badgeEmployeMap;
	private Set<Employe> employeScanne;
	
	public ControleDAcces(){
		badgeEmployeMap = new HashMap<Badge, Employe>();
		employeScanne = new HashSet<Employe>();
	}
	
	// associe le badge � un employ�
	public void donnerBadge (Badge b, Employe e){
		badgeEmployeMap.put(b,  e);
	}
	
	// met � jour les employ�s pr�sents dans le batiment
	public void entrerBatiment (Badge b){
		employeScanne.add(badgeEmployeMap.get(b));
	}

	// met � jour les employ�s pr�sents dans le batiment
	public void sortirBatiment (Badge b){
		employeScanne.remove(badgeEmployeMap.get(b));
	}
	
	// renvoie vrai si l'employ� est dans le batiment, faux sinon
	public boolean estDansBatiment (Employe e){
		if (employeScanne.contains(e))
			return true;
		return false;
	}
}
