package fractales;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.Tirage;

public class TirageToFractaleConverter {
	private int coef_1; // => b1
	private int coef_2; // => b2
	private int coef_3; // e2
	private float estompage; // => e1
	private int echelle; // b3
	private float couleur; // => b4
	private int coef_4; // b5
	private String typeFractale;

	private List<Tirage> tirages;
	private Logger LOGGER = Logger.getLogger(TirageToFractaleConverter.class);

	public TirageToFractaleConverter(List<Tirage> tirages, String typeFractale) {
		this.tirages = tirages;
		this.typeFractale = typeFractale;

	}
	
	public TirageToFractaleConverter() {} // Used for Mandelbrot

	/**
	 * Convertit une liste de tirages en une liste de fractales
	 * 
	 */
	public List<Fractale> convertTirageToFractale() {

		List<Fractale> fractales = new ArrayList<Fractale>();
		for (Tirage tirage : tirages) {
			convertTirageToParamFractale(tirage.getB1(), tirage.getB2(), tirage.getB3(), tirage.getB4(), 0,
					tirage.getE1(), 10);
			Fractale fractale = getFractale();
			fractales.add(fractale);
		}
		LOGGER.info("Conversion tirages to fractales succeeded");
		return fractales;
	}

	/**
	 * Convertit les valeurs des boules et etoiles d'un tirage en paramètres d'une
	 * fractale => unicité
	 */
	private void convertTirageToParamFractale(int b1, int b2, int b3, int b4, int b5, int e1, int e2) {
		coef_1 = Math.min(b1, b2);
		coef_2 = Math.max(b1, b2);

		echelle = 20*b3;
		
		couleur = (float) b4 / 50;
		
		coef_4 = b5;

		estompage = (float) e1 + 2;

		coef_3 = e2;

	}

	/*
	 * Renvoie une fractale de type Julia, mandelbrot ou autre en fonction du type
	 * choisi par l'utilisateur
	 */
	private Fractale getFractale() {

		// JULIA
		if (typeFractale.equals("Julia")) {

			/**
			 * FORMULE pour avoir les coordonnées du centre du bulb coef_1/coef_2 de l'ensemble de
			 * Mandelbrot
			 * 
			 * On note Z = exp(2*PI*i*coef_1/coef_2) alors
			 * 
			 * Bulb(coef_1/coef_2) = Z/2 * (1 - Z/2)
			 * 
			 * Re_C = Re( Bulb(coef_1/coef_2) ) | Im_C = Im( Bulb(coef_1/coef_2) )
			 * 
			 */

			float Re_C = (float) ((float) ((float) 1 / 2 * Math.cos((float) 2 * Math.PI * coef_1 / coef_2)
					- (float) 1 / 4 * Math.cos((float) 4 * Math.PI * coef_1 / coef_2)));
			
			float Im_C = (float) ((float) ((float) 1 / 2 * Math.sin((float) 2 * Math.PI * coef_1 / coef_2)
					- (float) 1 / 4 * Math.sin((float) 4 * Math.PI * coef_1 / coef_2)));

			float X = (float) ((float) 1 / coef_1 * Math.cos((float) (2 * Math.PI * coef_1 / coef_2))); // Léger décalage par rapport
																							// au centre du bulb
			coef_4/=50;
			JuliaFractale julia = new JuliaFractale(Re_C, Im_C + X, echelle, 1070, 540, estompage, couleur);
			
			return julia;
			
		// NEWTON	
		} else if (typeFractale.equals("Newton")) {  
			
			return new NewtonFractal(coef_1, coef_2, coef_3, echelle, 1070, 540, estompage, couleur,coef_4);
			
		// HALLEY	
		} else if (typeFractale.equals("Halley")) {  
			
			return new HalleyFractal(coef_1, coef_2, coef_3, echelle, 1070, 540, estompage, couleur,coef_4);
			
		// HOUSEHOLDER	
		} else {
			
			return new HouseHolder(coef_1, coef_2, coef_3, echelle, 1070, 540, estompage, couleur,coef_4);
			
		}
	}

}
