
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.CsvTirageDao;
import dao.SimpleTirage;
import dao.Tirage;

public class CsvDaoTest {
	private CsvTirageDao dao;
	private final String Filename = "src/main/ressources/euromillions_4.csv";
	
	@Before
	public void beforeEachTest(){
		dao = new CsvTirageDao(Filename);
	}
	
	// On teste le nombre de tirages dans le fichier csv
	@Test
	public void testfindAllTirages_line_146() throws Exception {
		final int expectedSize =146;
		
		final int actualSize = dao.findAllTirages().size();
		
		Assert.assertEquals(expectedSize,actualSize);
	}
	
	/* On teste le contenu du premier tirage : ordre croissant
	 */
	@Test
	public void testfindAllTirages_Tirages_0() throws Exception {
		final int numberTirage = 0;
		
		final Tirage expectedTirage = new SimpleTirage(6,9,13,39,41,2,12);
		
		final Tirage actualTirage = dao.findAllTirages().get(numberTirage);
		
		Assert.assertEquals(expectedTirage.toString(), actualTirage.toString());
			
	}
	
	/* file = new File(fileName); => FileNotFoundException
	 **/
	@Test (expected=FileNotFoundException.class)
	public void testFindAllTirages_wrong_file() throws Exception  {
		final String fileName = "wrong_file_name";
		
		dao = new CsvTirageDao(fileName);
		
		dao.findAllTirages();  
		
	}
	
	
	////////// Les méthodes sont similaires pour la partie "Stats" ////////
	
	/*
	 * Teste le nombre de lignes renvoyées par le csv
	 */
	@Test
	public void testfindAllTiragesStats_line_146() throws Exception {
		final int expectedSize =146;
		
		final int actualSize = dao.findAllTiragesStats().size();
		
		Assert.assertEquals(expectedSize,actualSize);
	}
	
	/*
	 * teste le contenu du premier tirage : ordre de sortie
	 */
	@Test
	public void testfindAllTiragesStats_Tirages_0() throws Exception {
		final int numberTirage = 0;
		
		final Tirage expectedTirage = new SimpleTirage(41,6,13,39,9,2,12);
		
		final Tirage actualTirage = dao.findAllTiragesStats().get(numberTirage);
		
		Assert.assertEquals(expectedTirage.toString(), actualTirage.toString());
			
	}
	
	/* file = new File(fileName); => FileNotFoundException
	 **/
	@Test (expected=FileNotFoundException.class)
	public void testFindAllTiragesStats_wrong_file() throws Exception  {
		final String fileName = "wrong_file_name";
		
		dao = new CsvTirageDao(fileName);
		
		dao.findAllTiragesStats();  
		
	}


}
