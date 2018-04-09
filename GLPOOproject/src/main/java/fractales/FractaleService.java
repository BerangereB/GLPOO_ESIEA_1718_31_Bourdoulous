package fractales;


import java.awt.image.BufferedImage;
import java.util.List;

/*
 * Cette classe permet de recalculer les fractales
 * lorsque l'utilisateur zoom ou recentre la frractale
 * 
 */
public class FractaleService {

	// On fait un zoom x2
	private final static int ZOOM_COEF = 2;  
	
	/* lorsqu'on veut recentrer on se déplace de (+/-)0.04 x largeur (ou hauteur) 
	 * avec largeur/hauteur dans le plan complexe;  
	 * ie : largeur = maxX - minX = frame_largeur/echelle | hauteur = maxY - minY = frame_hauteur/echelle
	 */
	public final static float TRANSLATION_COEF = 0.04f;  

	
	public static void changeCenter(Fractale f, float X, float Y) {
		final float centreX = (float) (f.getCentreX() + (float) X * f.getWidth() / f.getScale());
		final float centreY = (float) (f.getCentreY() + (float) Y * f.getHeight() / f.getScale());
		f.setCentreX(centreX);
		f.setCentreY(centreY);

		f.calcMinMax();

	}

	/**
	 * 
	 * Methode de ZOOM
	 * 
	 */
	public static void zoom(Fractale f, boolean bool) {
		int scale = f.getScale();
		if (bool) { //ZOOM
			f.setScale(scale * ZOOM_COEF); 
		} else {	//DEZOOM
			f.setScale((int) scale / ZOOM_COEF);
		}
		f.calcMinMax();

	}
	
	/**
	 * 
	 * Methode utilisée lorsque l'on redimensionne la fenetre 
	 * 
	 */
	public static void changeSize(Fractale f,int newWidth, int newHeight) {
		f.setWidth(newWidth);
		f.setHeight(newHeight);
		f.calcMinMax();
		f.setBuffer(new BufferedImage(newWidth,newHeight,BufferedImage.TYPE_INT_RGB));
	}

	/******************************
	 * SUPERPOSITION DE FRACTALES *                 
	 ******************************/

	public static BufferedImage joinFractales(final List<BufferedImage> images) {
		// On test le format d'entrée
		final int width = images.get(0).getWidth();
		final int height = images.get(0).getHeight();
		for (BufferedImage buffer : images) {
			if (width != buffer.getWidth() && height != buffer.getHeight()) {
				throw new IllegalArgumentException("L'une au moins des images n'a pas les mêmes dimensions");
			}
		}
		BufferedImage res = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//Addition des couleurs
		for (int x = 0; x < width; x += 1) {
			for (int y = 0; y < height; y += 1) {
				for (BufferedImage image : images) {
					res.setRGB(x, y, res.getRGB(x, y) + image.getRGB(x, y) );
				}
			}
		}
		return res;
	}

}
