package dao;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class CsvTirageDao {
	private String fileName;
	private Logger LOGGER = Logger.getLogger(CsvTirageDao.class);

	public CsvTirageDao(String fileName) {
		this.fileName = fileName;
	}

	private List<String> lectureFichier() throws Exception {

		// On instancie un fichier
		final File file = new File(fileName);

		// Sortie de la fonction : contenu du fichier sous forme de liste de lignes
		final List<String> lines = new ArrayList<String>();

		final FileReader fr = new FileReader(file);
		final BufferedReader br = new BufferedReader(fr);

		// met les lignes du buffer dans la liste de lignes de tirage
		for (String line = br.readLine(); line != null; line = br.readLine()) {
			lines.add(line);
		}

		br.close();
		fr.close();

		return lines;
	}

	/*
	 * On utilise les resultats dans l'ordre croissant
	 */
	private Tirage lineToTirage(final String line) {
		final SimpleTirage tirage = new SimpleTirage();
		final String[] colonnes = line.split(";");

		// On set les attributs du tirage

		final String[] boulesValues = colonnes[12].split("-"); 
		tirage.setB1(new Integer(boulesValues[1]));
		tirage.setB2(new Integer(boulesValues[2]));
		tirage.setB3(new Integer(boulesValues[3]));
		tirage.setB4(new Integer(boulesValues[4]));
		tirage.setB5(new Integer(boulesValues[5]));

		final String[] etoilesValues = colonnes[13].split("-");
		tirage.setE1(new Integer(etoilesValues[1]));
		tirage.setE2(new Integer(etoilesValues[2]));

		return tirage;

	}

	public List<Tirage> findAllTirages() throws Exception {
		LOGGER.info("Function findAllTirages called");
		final List<Tirage> tirages = new ArrayList<Tirage>();

		// Fichier > tab de ligne
		List<String> lines = null;
		
		lines = lectureFichier();
		

		// conversion ligne > tirage
		for (final String line : lines) {
			if (line.trim().isEmpty() || line.startsWith("#")) { 
				continue;
			}
			// les titres sont en commentaire alors on ne supprime pas la première ligne

			final Tirage tirage = lineToTirage(line);
			tirages.add(tirage);
		}

		LOGGER.info(tirages.size() + " draws found");
		return tirages;
	}
	
	/**
	 * 
	 * Pour les statistiques on utilise les tirages
	 * avec les boules rangées par ordre de sortie
	 */
	private Tirage lineToTirageStats(final String line) {
		final SimpleTirage tirage = new SimpleTirage();
		final String[] colonnes = line.split(";");

		// On set les attributs du tirage

		//final String[] boulesValues = colonnes[12].split("-");
		tirage.setB1(new Integer(colonnes[5]));
		tirage.setB2(new Integer(colonnes[6]));
		tirage.setB3(new Integer(colonnes[7]));
		tirage.setB4(new Integer(colonnes[8]));
		tirage.setB5(new Integer(colonnes[9]));

		//final String[] etoilesValues = colonnes[13].split("-");
		tirage.setE1(new Integer(colonnes[10]));
		tirage.setE2(new Integer(colonnes[11]));

		return tirage;

	}

	public List<Tirage> findAllTiragesStats() throws Exception {
		final List<Tirage> tirages = new ArrayList<Tirage>();

		// Fichier > tab de ligne
		List<String> lines = null;
		lines = lectureFichier();

	// ligne > tirage
		for (final String line : lines) {
			if (line.trim().isEmpty() || line.startsWith("#")) {
				continue;
			}
			final Tirage tirage = lineToTirageStats(line);
			tirages.add(tirage);
		}
		

		// return
		return tirages;
	}
}
