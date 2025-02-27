import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MatriceDAdjacence extends Graph{
	
	private Map<Integer, Airport>  correspondanceIndiceAirport;
	private Map<Airport, Integer>  correspondanceAirportIndice;
	private Flight[][] matrice= new Flight[0][0];
	private int nbAirport=0;

	public MatriceDAdjacence() {
		super();
		correspondanceAirportIndice= new HashMap<Airport,Integer>();
		correspondanceIndiceAirport= new HashMap<Integer,Airport>();
	}

	@Override
	// Complexité: ?
	protected void ajouterSommet(Airport a) {	
		//à compléter
		correspondanceAirportIndice.putIfAbsent(a, nbAirport);
		correspondanceIndiceAirport.putIfAbsent(nbAirport, a);
		nbAirport++;

		Flight[][] temp = new Flight[nbAirport][nbAirport];
		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice.length; j++) {
				temp[i][j] = matrice[i][j];
			}
		}

		matrice = temp;
	}

	@Override
	// Complexité: ?
	protected void ajouterArc(Flight f) {
		//à compléter
		int source = correspondanceAirportIndice.get(f.getSource());
		int destination = correspondanceAirportIndice.get(f.getDestination());

		matrice[source][destination] = f;
	}

	@Override
	// Complexité: ?
	public Set<Flight> arcsSortants(Airport a) {
		//à compléter
		Set<Flight> temp = new HashSet<>();
		int ind = correspondanceAirportIndice.get(a);

		for (int i = 0; i < matrice.length; i++) {
			Flight tempF = matrice[ind][i];
			if(tempF != null) {
				temp.add(tempF);
			}
		}
		return temp;
	}

	@Override
	// Complexité: ?
	public boolean sontAdjacents(Airport a1, Airport a2) {
		// à compléter
		int ind1 = correspondanceAirportIndice.get(a1);
		int ind2 = correspondanceAirportIndice.get(a2);

		return matrice[ind1][ind2]!=null || matrice[ind2][ind1]!=null;
	}
	
	

}
