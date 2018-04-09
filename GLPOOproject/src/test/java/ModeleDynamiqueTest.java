import org.junit.Assert;
import org.junit.Test;

import dao.SimpleTirage;
import dao.Tirage;
import model.ModeleDynamique;

public class ModeleDynamiqueTest {
	private final ModeleDynamique model = new ModeleDynamique();

	@Test
	public void testRowToTirage_row_0() {
		// Arrange -6-9-13-39-41--2-12
		final int rowTested = 0;
		final Tirage expectedTirage = new SimpleTirage(6,9,13,39,41,2,12);
		// Act
		final Tirage actualTirage = model.rowToTirage(rowTested);
		
 		// Assert
		Assert.assertEquals(expectedTirage.toString(), actualTirage.toString());
	}
	
	/*
	 * On teste l'index de la column 
	 * correspondant au titre "B1"
	 */
	@Test
	public void testGetColumnName_B1() {
		final int columnNumberB1 = 1;
		final String expectedColumnName = "B1";
		
		final String actualColumnName = model.getColumnName(columnNumberB1);
		
		Assert.assertEquals(expectedColumnName, actualColumnName);
	}
	
	
	@Test
	public void testGetValueAt_row_0_column_1() {
		final int rowIndex = 0;
		final int columnIndex = 1;
		final int expectedValue = 6;
		
		final int actualValue = (int) model.getValueAt(rowIndex, columnIndex);
		
		Assert.assertEquals(expectedValue, actualValue);
		
	}
	
	/*
	 * On vérifie que getValueAt(..) renvoie bien 
	 * une exception de type IllegalArgumentException
	 * lorsque l'on tente d'accéder à un élément dans
	 * une colonne inexistante
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetValueAt_column_8() {
		final int rowIndex = 0;
		final int columnIndex = 8;
		model.getValueAt(rowIndex, columnIndex);
		
	}
	
	/*
	 * On vérifie que le modele récupère 
	 * bien toutes les lignes du csv
	 */
	@Test
	public void testTotalRows_146() {
		final int expectedCountRows = 146;
		
		final int actualCountRows = model.getRowCount();
		
		Assert.assertEquals(expectedCountRows, actualCountRows);
	}
	
	/*
	 * On test le nombre de colonnes du modele
	 * à savoir 8
	 */
	@Test
	public void testTotalHeaders_8() { // index + 5 boules + 2 etoiles
		final int expectedCountHeaders = 8;
		
		final int actualCountHeaders = model.getColumnCount();
		
		Assert.assertEquals(expectedCountHeaders, actualCountHeaders);
	}
}
