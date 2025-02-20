import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ListeDArc extends Graph{
	
	private ArrayList<Flight> flights;

	public ListeDArc() {
		super();
		flights=new ArrayList<Flight>();
	}

	@Override
	// Complexité: ?
	protected void ajouterSommet(Airport a) {	
		//à compléter

	}

	@Override
	// Complexité: ?
	protected void ajouterArc(Flight f) {
		//à compléter
		flights.add(f);
	}

	@Override
	// Complexité: ?
	public Set<Flight> arcsSortants(Airport a) {
		//à compléter
		Set<Flight> temp = new HashSet<Flight>();
		for (Flight flight : flights) {
			if (flight.getSource().equals(a))
				temp.add(flight);
		}
		return temp;
	}

	@Override
	// Complexité: ?
	public boolean sontAdjacents(Airport a1, Airport a2) {
		// à compléter
		for (Flight flight : flights) {
			if ((flight.getSource().equals(a1) && flight.getDestination().equals(a2)) || (flight.getSource().equals(a2) && flight.getDestination().equals(a1)))
				return true;
		}
		return false;
	}

}
