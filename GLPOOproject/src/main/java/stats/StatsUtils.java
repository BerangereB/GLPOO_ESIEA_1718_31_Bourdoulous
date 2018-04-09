package stats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatsUtils {
	
	
	// Calcul de la moyenne d'une liste d'entiers

		public static float averageCalculation(List<Integer> list) {
			if(list.isEmpty()) throw new NullPointerException();

			Integer total = 0;
			for (Integer temp : list) {
				total += temp;
			}
			float res = total.floatValue() / list.size();
			float average = (float)Math.round(100*res)/(float)100;
			return average;
		}
	
		
		//VALEUR LA PLUS RECCURENTE
		public static List<Integer> maxOccurence(List<Integer> list) {
			if(list.isEmpty()) throw new NullPointerException();
				Collections.sort(list);
				List<Integer> maxOccValues = new ArrayList<Integer>();
				Map<Integer,Integer> mapOccurences = new HashMap<Integer,Integer>();
				int maxOcc = 1;
				
				if(mapOccurences.isEmpty()) {
				
					// On remplit l'occurence de chaque element dans la map et on trouve le max d'occurence
					for(Integer e : list) {
						if(!mapOccurences.containsKey(e)) {
							mapOccurences.put(e, 1);
						}else {
							int newOcc = mapOccurences.get(e) + 1;
							mapOccurences.put(e, newOcc);
							if(newOcc > maxOcc) {
								maxOcc = newOcc;
							}
						}
					}
				}
				maxOccValues.add(maxOcc);
				
				for(Integer key : mapOccurences.keySet()) {
					int value = mapOccurences.get(key);
					if(value == maxOcc) {
						maxOccValues.add(key);
					}
				}
				
				return maxOccValues;
		}

		// Calcul de la m�diane d'une liste
		public static float mediane(List<Integer> list) {
			if(list.isEmpty()) throw new NullPointerException();
			Collections.sort(list);
			if(list.size()%2 == 1) {
				return list.get( (list.size() + 1 ) / 2 -1);
			}else {
				return ( list.get( list.size()/ 2 -1) + list.get( list.size()/ 2 ) ) /2;
			}
		}

		// VARIANCE
		public static float variance(List<Integer> list) {
			if(list.isEmpty()) throw new NullPointerException();
			Collections.sort(list);

			float moyenne = averageCalculation(list);
			float somme = 0;
			
			for(Integer i : list) {
				somme += (i - moyenne)*(i - moyenne);
			}
			
			float res = somme / list.size();
			return (float)Math.round(100*res)/(float)100;
		}

		// ECART TYPE
		public static float ecartType(List<Integer> list) {
			if(list.isEmpty()) throw new NullPointerException();
			float res = (float) Math.sqrt(variance(list));
			return (float)Math.round(100*res)/(float)100;
		}

		// Retourne la 1ere valeur ressortant le moins dans une liste
		public static List<Integer> minOccurence(List<Integer> list) {
			if(list.isEmpty()) throw new NullPointerException();
			Collections.sort(list);
			List<Integer> minOccValues = new ArrayList<Integer>();
			Map<Integer,Integer> mapOccurences = new HashMap<Integer,Integer>();
			int maxOcc = 1;
			
			if(mapOccurences.isEmpty()) {
			
				// On remplit l'occurence de chaque element dans la map et on trouve le max d'occurence
				for(Integer e : list) {
					if(!mapOccurences.containsKey(e)) {
						mapOccurences.put(e, 1);
					}else {
						int newOcc = mapOccurences.get(e) + 1;
						mapOccurences.put(e, newOcc);
						if(newOcc > maxOcc) {
							maxOcc = newOcc;
						}
					}
				}
			}
			//Recherche de minOcc
			int minOcc = maxOcc;
			for(Integer key : mapOccurences.keySet()) {
				int value = mapOccurences.get(key);
				if(value < minOcc) {
					minOcc = value;
				}
			}
			minOccValues.add(minOcc);
			
			for(Integer key : mapOccurences.keySet()) {
				int value = mapOccurences.get(key);
				if(value == minOcc) {
					minOccValues.add(key);
				}
			}
			
			return minOccValues;
		}
}
