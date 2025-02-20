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
	// Complexit�: ?
	protected void ajouterSommet(Airport a) {	
		//� compl�ter
		outputFlights.put(a, new HashSet<Flight>());
	}

	@Override
	// Complexit�: ?
	protected void ajouterArc(Flight f) {
		//� compl�ter
		Airport temp = f.getSource();
		outputFlights.get(temp).add(f);
	}

	@Override
	// Complexit�: ?
	public Set<Flight> arcsSortants(Airport a) {
		//� compl�ter
		return outputFlights.get(a);
	}

	@Override
	// Complexit�: ?
	public boolean sontAdjacents(Airport a1, Airport a2) {
		// � compl�ter
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
