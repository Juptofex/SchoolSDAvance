import java.time.LocalTime;
import java.util.*;

import static java.time.temporal.ChronoUnit.MILLIS;

public class LocationPatins {

	private Map<Integer, ArrayDeque<Integer>> mapCasierPointure;
	private int[] casiers;
	private LocalTime[] emprunt;

	public LocationPatins(int[] casiers) {
		this.casiers = casiers;
		mapCasierPointure = new HashMap<Integer, ArrayDeque<Integer>>();
		emprunt = new LocalTime[casiers.length];
		for (int i = 0; i < casiers.length; i++) {;
			if (!mapCasierPointure.containsKey(casiers[i])){
				mapCasierPointure.put(casiers[i], new ArrayDeque<Integer>());
				mapCasierPointure.get(casiers[i]).add(i);
			} else {
				mapCasierPointure.get(casiers[i]).add(i);
			}
		}
	}

	// date1 < date2
	private static double prix(LocalTime date1, LocalTime date2) {
		// 1 euro par milliseconde (c'est assez cher en effet)
		return MILLIS.between(date1, date2) ;
	}

	public int attribuerCasierAvecPatins(int pointure) {
		if (pointure < 33 || pointure > 48)
			throw new IllegalArgumentException();
		LocalTime l = LocalTime.now();
		if (!mapCasierPointure.containsKey(pointure) || mapCasierPointure.get(pointure).isEmpty())
			return -1;
		int casier = mapCasierPointure.get(pointure).poll();
		emprunt[casier] = l;
		return casier;
		
		//a compl�ter

	}

	public double libererCasier(int numeroCasier) {
		//a completer
		mapCasierPointure.get(casiers[numeroCasier]).add(numeroCasier);
		return prix(emprunt[numeroCasier], LocalTime.now());
	}

}
