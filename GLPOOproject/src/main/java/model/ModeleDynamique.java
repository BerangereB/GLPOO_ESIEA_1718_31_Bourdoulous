package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.apache.log4j.Logger;

import dao.CsvTirageDao;
import dao.SimpleTirage;
import dao.Tirage;

public class ModeleDynamique extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private Logger LOGGER = Logger.getLogger(ModeleDynamique.class);

	private final String[] header;

	private String fileName = "src/main/ressources/euromillions_4.csv";
	private CsvTirageDao dao = new CsvTirageDao(fileName);
	private List<Tirage> tirages = null;

	public ModeleDynamique(String fileName) {
		this.fileName = fileName;
		dao = new CsvTirageDao(fileName);
		
		try {
			tirages = dao.findAllTirages(); // On récupère les données du csv grâce au dao
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		
		header = new String[] { "B1", "B2", "B3", "B4", "B5", "E1", "E2" };
	}

	public ModeleDynamique() {
		try {
			tirages = dao.findAllTirages();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		header = new String[] { "Numero de tirage", "B1", "B2", "B3", "B4", "B5", "E1", "E2" };
	}

	public int getColumnCount() { // retourne le nombre de colonnes
		return header.length;
	}

	public int getRowCount() { // retourne le nombre de lignes
		return tirages.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) { // retourne la valeur de la case indiquée
		switch (columnIndex) {
		case 0:
			return rowIndex;
		case 1:
			return tirages.get(rowIndex).getB1();
		case 2:
			return tirages.get(rowIndex).getB2();
		case 3:
			return tirages.get(rowIndex).getB3();
		case 4:
			return tirages.get(rowIndex).getB4();
		case 5:
			return tirages.get(rowIndex).getB5();
		case 6:
			return tirages.get(rowIndex).getE1();
		case 7:
			return tirages.get(rowIndex).getE2();
		default:
			throw new IllegalArgumentException("ERROR");
		}
	}

	public String getColumnName(int columnIndex) { // retourne l'entete de la colonne indiquée
		return header[columnIndex];
	}

	// Renvoie le tirage associé à la ligne donnée en entrée
	public Tirage rowToTirage(int rowIndex) {
		final SimpleTirage tirage = new SimpleTirage();

		tirage.setB1(tirages.get(rowIndex).getB1());
		tirage.setB2(tirages.get(rowIndex).getB2());
		tirage.setB3(tirages.get(rowIndex).getB3());
		tirage.setB4(tirages.get(rowIndex).getB4());
		tirage.setB5(tirages.get(rowIndex).getB5());
		tirage.setE1(tirages.get(rowIndex).getE1());
		tirage.setE2(tirages.get(rowIndex).getE2());

		return tirage;
	}

}
