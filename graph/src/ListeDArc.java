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
	// Complexit�: ?
	protected void ajouterSommet(Airport a) {	
		//� compl�ter

	}

	@Override
	// Complexit�: ?
	protected void ajouterArc(Flight f) {
		//� compl�ter
		flights.add(f);
	}

	@Override
	// Complexit�: ?
	public Set<Flight> arcsSortants(Airport a) {
		//� compl�ter
		Set<Flight> temp = new HashSet<Flight>();
		for (Flight flight : flights) {
			if (flight.getSource().equals(a))
				temp.add(flight);
		}
		return temp;
	}

	@Override
	// Complexit�: ?
	public boolean sontAdjacents(Airport a1, Airport a2) {
		// � compl�ter
		for (Flight flight : flights) {
			if ((flight.getSource().equals(a1) && flight.getDestination().equals(a2)) || (flight.getSource().equals(a2) && flight.getDestination().equals(a1)))
				return true;
		}
		return false;
	}

}
