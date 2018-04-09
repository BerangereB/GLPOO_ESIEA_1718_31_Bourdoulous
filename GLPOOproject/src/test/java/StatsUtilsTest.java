import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import stats.StatsUtils;

public class StatsUtilsTest {
	
	private List<Integer> list_impair = new ArrayList<Integer>();
	private List<Integer> list_pair = new ArrayList<Integer>();
	
	public StatsUtilsTest() {
		for(int i = 10; i > 0; i--) {
			list_impair.add(i);
		}
		list_impair.add(10);
		
		Collections.sort(list_impair);
		
		for(int i = 10; i > 0; i--) {
			list_pair.add(i);
		}
		
		Collections.sort(list_pair);
	}
	/**
	 * Données 1 : (10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10) ---> triées : (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10)
	 * 	Moyenne : 5.91 
	 *  Variance : 9.16
	 *  Ecart Type : 3.03
	 *  Mediane : 6
	 *  le plus présent : 10 | occ = 2
	 *  le moins présent : tous sauf 10 | occ = 1
	 */
	
	/*
	 * Teste la valeur de la moyenne de la liste d'entiers de taille impaire
	 */
	@Test
	public void testMoyenne_list_impair() { 
		final float expected = 5.91f;
		
		final float actual = StatsUtils.averageCalculation(list_impair);
		
		Assert.assertEquals((int)(expected-actual),0);
		
	}
	

	/*
	 * Teste la valeur de la variance de la liste d'entiers de taille impaire
	 */
	@Test
	public void testVariance_list_impair() { 
		final float expected = 9.16f;
		
		final float actual = StatsUtils.variance(list_impair);
		
		Assert.assertEquals((int)(expected-actual),0);
		
	}
	
	/*
	 * Teste la valeur de l'écart-type de la liste d'entiers de taille impaire
	 */
	@Test
	public void testEcartType_list_impair() { 
		final float expected = 3.03f;
		
		final float actual = StatsUtils.ecartType(list_impair);
		
		Assert.assertEquals((int)(expected-actual),0);
		
	}
	
	/*
	 * Teste la valeur de la médiane de la liste d'entiers de taille impaire
	 */
	@Test
	public void testMediane_list_impair() { 
		final float expected = 6;
		
		final float actual = StatsUtils.mediane(list_impair);
		
		Assert.assertEquals((int)(expected-actual),0);
		
	}
	
	/*
	 * Teste la méthode donnant la liste des elements 
	 * les plus présents de la liste d'entiers de taille impaire
	 * tel que maxOccurence(list) renvoie (nb d'occurences, element1, ..., elementk)
	 */
	@Test
	public void testMaxOccurence_list_impair() { 
		final List<Integer> expected = new ArrayList<Integer>();
		expected.add(2); // nb_occurence
		expected.add(10); // elements maxOccurence
		
		final List<Integer> actual = StatsUtils.maxOccurence(list_impair);
		
		Assert.assertEquals(expected,actual);
		
	}
	
	/*
	 * Teste la méthode donnant la liste des elements 
	 * les moins présents de la liste d'entiers de taille impaire
	 * tel que minOccurence(list) renvoie (nb d'occurences, element1, ..., elementk)
	 */
	@Test
	public void testMinOccurence_list_impair() { 
		final List<Integer> expected = new ArrayList<Integer>();
		expected.add(1); // nb_occurence
		
		for(int i = 1; i<10;i++) { // elements minOccurence (1, 2, 3, 4, 5, 6, 7, 8, 9)
			expected.add(i); 
		}
		
		final List<Integer> actual = StatsUtils.minOccurence(list_impair);
		
		Assert.assertEquals(expected,actual);
		
	}
	
	
	/**
	 * Données 2 : (10, 9, 8, 7, 6, 5, 4, 3, 2, 1) ---> triées : (1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
	 * 	Moyenne : 5.5 
	 *  Variance : 8.25
	 *  Ecart Type : 2.87
	 *  Mediane : 5 + 6 / 2 => 5.5
	 *  le plus présent : tous | occ = 1
	 *  le moins présent : tous | occ = 1
	 */
	
/* Les méthodes suivantes testent les mêmes méthodes 
 * avec une liste en entrée de taille paire et dont 
 * tous les éléments apparaissent 1 fois seulement
 */
	
	// MOYENNE
	@Test
	public void testMoyenne_list_pair() { 
		final float expected = 5.5f;
		
		final float actual = StatsUtils.averageCalculation(list_pair);
		
		Assert.assertEquals((int)(expected-actual),0);
		
	}
	
	// VARIANCE
	@Test
	public void testVariance_list_pair() { 
		final float expected = 8.25f;
		
		final float actual = StatsUtils.variance(list_pair);
		Assert.assertEquals((int)(expected-actual),0);
		
	}
	
	// ECART TYPE
	@Test
	public void testEcartType_list_pair() { 
		final float expected = 2.87f;
		
		final float actual = StatsUtils.ecartType(list_pair);
		
		Assert.assertEquals((int)(expected-actual),0);
		
	}
	
	// MEDIANE
	@Test
	public void testMediane_list_pair() { 
		final float expected = 5.5f;
		
		final float actual = StatsUtils.mediane(list_pair);
		
		Assert.assertEquals((int)(expected-actual),0);
		
	}
	
	// MAX OCCURENCE
	@Test
	public void testMaxOccurence_list_pair() { 
		final List<Integer> expected = new ArrayList<Integer>();
		expected.add(1); // nb_occurence
		
		for(int i = 1; i<11;i++) { // elements minOccurence (1, 2, 3, 4, 5, 6, 7, 8, 9,10)
			expected.add(i); 
		}
		
		final List<Integer> actual = StatsUtils.maxOccurence(list_pair);
		
		Assert.assertEquals(expected,actual);
		
	}
	
	// MIN OCCURENCE
	@Test
	public void testMinOccurence_list_pair() { 
		final List<Integer> expected = new ArrayList<Integer>();
		expected.add(1); // nb_occurence
		
		for(int i = 1; i<11;i++) { // elements minOccurence (1, 2, 3, 4, 5, 6, 7, 8, 9,10)
			expected.add(i); 
		}
		
		final List<Integer> actual = StatsUtils.minOccurence(list_pair);
		
		Assert.assertEquals(expected,actual);
		
	}
	
	/*
	 * On teste le renvoie d'une exception (NullPointerException)
	 * si la liste en entrée est vide
	 */
	@Test(expected=NullPointerException.class)
	public void testMinOccurence_list_vide() { 
		final List<Integer> emptyList = new ArrayList<Integer>();
		
		StatsUtils.minOccurence(emptyList);
		
		
	}
}
