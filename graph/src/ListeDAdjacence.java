import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ListeDAdjacence extends Graph{
	
	private Map<Airport,Set<Flight>> outputFlights;

	public ListeDAdjacence(){
		super();
		outputFlights=new HashMap<Airport,Set<Flight>>();

	}

	@Override
	// Complexité: ?
	protected void ajouterSommet(Airport a) {	
		//à compléter
		outputFlights.put(a, new HashSet<Flight>());
	}

	@Override
	// Complexité: ?
	protected void ajouterArc(Flight f) {
		//à compléter
		Airport temp = f.getSource();
		outputFlights.get(temp).add(f);
	}

	@Override
	// Complexité: ?
	public Set<Flight> arcsSortants(Airport a) {
		//à compléter
		return outputFlights.get(a);
	}

	@Override
	// Complexité: ?
	public boolean sontAdjacents(Airport a1, Airport a2) {
		// à compléter
		Set<Flight> temp1 = outputFlights.get(a1);
		Set<Flight> temp2 = outputFlights.get(a2);
		if (!temp1.isEmpty()) {
			for (Flight flight : temp1) {
				if (flight.getDestination().equals(a2))
					return true;
			}
		}
		if (!temp2.isEmpty()) {
			for (Flight flight : temp2) {
				if (flight.getDestination().equals(a1))
					return true;
			}
		}
		return false;
	}

}
