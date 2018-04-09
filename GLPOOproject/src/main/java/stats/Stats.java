package stats;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.Tirage;
import dao.CsvTirageDao;

public class Stats {

	// On r�cup�re le fichier des tirages, les classes qui nous seront utiles

	private CsvTirageDao dao;
	private List<Tirage> tirages;
	private List<Integer> listeb1;
	private List<Integer> listeb2;
	private List<Integer> listeb3;
	private List<Integer> listeb4;
	private List<Integer> listeb5;
	private List<Integer> listee1;
	private List<Integer> listee2;
	
	private Logger LOGGER = Logger.getLogger(Stats.class);

	// M�thode pour r�cup�rer les m�thodes utiles

	public Stats(String filename) {
		dao = new CsvTirageDao(filename);
		try {
			tirages = dao.findAllTiragesStats();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		initializeLists();
	}

	// Initialisation des listes

	public void initializeLists() {

		listeb1 = new ArrayList<Integer>();
		listeb2 = new ArrayList<Integer>();
		listeb3 = new ArrayList<Integer>();
		listeb4 = new ArrayList<Integer>();
		listeb5 = new ArrayList<Integer>();
		listee1 = new ArrayList<Integer>();
		listee2 = new ArrayList<Integer>();

		for (Tirage tirage : tirages) {
			listeb1.add(tirage.getB1());
			listeb2.add(tirage.getB2());
			listeb3.add(tirage.getB3());
			listeb4.add(tirage.getB4());
			listeb5.add(tirage.getB5());
			listee1.add(tirage.getE1());
			listee2.add(tirage.getE2());
		}
	}
	
	private String toStringListOccurences(List<Integer> occurences) {
		String str = "<html>";
		//str += occurences.get(0) + " fois <br>"; // nombre d'occurences
		
		for(int i = 1; i < occurences.size(); i++) {
			if(i%2 == 1)
				str += occurences.get(i) ;
			else
				str +=  " | " + occurences.get(i) + "<br>";
		}
		
		return str + "</html>";
	}

	

	/// getters public moyenne

	public String getAvB1() {
		return Float.toString(StatsUtils.averageCalculation(listeb1));
	}

	public String getAvB2() {
		return Float.toString(StatsUtils.averageCalculation(listeb2));
	}

	public String getAvB3() {
		return Float.toString(StatsUtils.averageCalculation(listeb3));
	}

	public String getAvB4() {
		return Float.toString(StatsUtils.averageCalculation(listeb4));
	}

	public String getAvB5() {
		return Float.toString(StatsUtils.averageCalculation(listeb5));
	}
	
	public String getAvE1() {
		return Float.toString(StatsUtils.averageCalculation(listee1));
	}

	public String getAvE2() {
		return Float.toString(StatsUtils.averageCalculation(listee2));
	}

	/// getters public max occurrence

	public String getPlusParuB1() {
		return toStringListOccurences(StatsUtils.maxOccurence(listeb1));
	}

	public String getPlusParuB2() {
		return toStringListOccurences(StatsUtils.maxOccurence(listeb2));
	}

	public String getPlusParuB3() {
		return toStringListOccurences(StatsUtils.maxOccurence(listeb3));
	}

	public String getPlusParuB4() {
		return toStringListOccurences(StatsUtils.maxOccurence(listeb4));
	}

	public String getPlusParuB5() {
		return toStringListOccurences(StatsUtils.maxOccurence(listeb5));
	}
	
	public String getPlusParuE1() {
		return toStringListOccurences(StatsUtils.maxOccurence(listee1));
	}
	
	public String getPlusParuE2() {
		return toStringListOccurences(StatsUtils.maxOccurence(listee2));
	}

	/// getters public StatsUtils.mediane

	public String getMedB1() {
		return Float.toString(StatsUtils.mediane(listeb1));
	}

	public String getMedB2() {
		return Float.toString(StatsUtils.mediane(listeb2));
	}

	public String getMedB3() {
		return Float.toString(StatsUtils.mediane(listeb3));
	}

	public String getMedB4() {
		return Float.toString(StatsUtils.mediane(listeb4));
	}

	public String getMedB5() {
		return Float.toString(StatsUtils.mediane(listeb5));
	}
	
	public String getMedE1() {
		return Float.toString(StatsUtils.mediane(listee1));
	}

	public String getMedE2() {
		return Float.toString(StatsUtils.mediane(listee2));
	}

	/// getters public StatsUtils.variance

	public String getVarB1() {
		return Float.toString(StatsUtils.variance(listeb1));
	}

	public String getVarB2() {
		return Float.toString(StatsUtils.variance(listeb2));
	}

	public String getVarB3() {
		return Float.toString(StatsUtils.variance(listeb3));
	}

	public String getVarB4() {
		return Float.toString(StatsUtils.variance(listeb4));
	}

	public String getVarB5() {
		return Float.toString(StatsUtils.variance(listeb5));
	}
	
	public String getVarE1() {
		return Float.toString(StatsUtils.variance(listee1));
	}

	public String getVarE2() {
		return Float.toString(StatsUtils.variance(listee2));
	}

	/// getters public occurence minimale

	public String getMinB1() {
		return toStringListOccurences(StatsUtils.minOccurence(listeb1));
	}

	public String getMinB2() {
		return toStringListOccurences(StatsUtils.minOccurence(listeb2));
	}

	public String getMinB3() {
		return toStringListOccurences(StatsUtils.minOccurence(listeb3));
	}

	public String getMinB4() {
		return toStringListOccurences(StatsUtils.minOccurence(listeb4));
	}

	public String getMinB5() {
		return toStringListOccurences(StatsUtils.minOccurence(listeb5));
	}

	public String getMinE1() {
		return toStringListOccurences(StatsUtils.minOccurence(listee1));
	}

	public String getMinE2() {
		return toStringListOccurences(StatsUtils.minOccurence(listee2));
	}
	/// getters public Ecart-type

	public String getEcartB1() {
		return Float.toString(StatsUtils.ecartType(listeb1));
	}

	public String getEcartB2() {
		return Float.toString(StatsUtils.ecartType(listeb2));
	}

	public String getEcartB3() {
		return Float.toString(StatsUtils.ecartType(listeb3));
	}

	public String getEcartB4() {
		return Float.toString(StatsUtils.ecartType(listeb4));
	}

	public String getEcartB5() {
		return Float.toString(StatsUtils.ecartType(listeb5));
	}
	
	public String getEcartE1() {
		return Float.toString(StatsUtils.ecartType(listee1));
	}

	public String getEcartE2() {
		return Float.toString(StatsUtils.ecartType(listee2));
	}

	
}
