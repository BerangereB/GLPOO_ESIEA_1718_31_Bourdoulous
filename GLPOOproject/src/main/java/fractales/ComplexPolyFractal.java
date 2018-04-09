package fractales;

import java.awt.image.BufferedImage;
import flanagan.complex.Complex;
import flanagan.complex.ComplexPoly;

public abstract class ComplexPolyFractal implements Fractale {
	
	protected int width; // Largeur du dessin
	
	protected int height; // Hauteur du dessin
	
	protected int iterations = 500; // Plus cet entier est grand plus il est long de calculer le dessin (mais plus
									// grande précision dans le degré ed convergence de certain complexes)
	
	protected BufferedImage buffer; // Image tampon

	protected int scale;	// Définit le zoom
	
	protected float estompage;	// Utilisé pour la coloration du dessin  
	protected float color;      // Utilisé pour la coloration du dessin 
	
	/*
	 * centre, max, min sont particulièrement utiles lorsque l'on souhaite recentrer ou zoomer
	 */
	protected float centreX;	
	protected float centreY;
	protected float maxX;
	protected float minX;
	protected float maxY;
	protected float minY;

	
	protected final double epsilon = (double) 0.00001; // plus epsilon est petit, plus le calcul est précis, et le temps
														// de calcul évolue de manière exponentielle. Tester avec de
														// petites valeurs au début
	protected final double alpha = (double) 1;

	protected double[] coefficients1; // on définit les coefficients du polynome

	protected ComplexPoly P1;
	protected ComplexPoly P2;
	protected ComplexPoly P3;

	protected final Complex[] roots;

	public ComplexPolyFractal(final int a0, final int a1, final int a2, int scale, int width, int height,
			final float estompage, final float color,int a3) {
		// On instancie le buffer : dimensions et coloration
		buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// Initialisation des paramètres du dessin

		coefficients1 = new double[] { a3, a2, a1, a0 }; 
		P1 = new ComplexPoly(coefficients1); // P1(X) = a_3 * X^3    +   a_2 * X^2   +   a_1 * X   +   a_0
		P2 = P1.nthDerivative(1); // P2(X) = P1'(X) = 3 * a_3 * X^2   +   2 * a_2 * X   +    a_1 
		P3 = P1.nthDerivative(2); //  P3(X) = P1"(X) = 6 * a_3 * X   +   2 * a_2
		roots = P1.roots(); // ==> 3 racines de P1

		this.scale = scale;
		this.width = width;
		this.height = height;
		this.estompage = estompage;
		this.color = color;
		
		// On place le centre (X,Y) du dessin au centre de gravité des racines de P1
		centreX = (float) (roots[0].getReal()+roots[1].getReal()+roots[2].getReal())/3;
		centreY = (float) (roots[0].getImag()+roots[1].getImag()+roots[2].getImag())/3;
		calcMinMax();

	}

	public void calcMinMax() {
		maxX = centreX + (float) 0.5 * width / scale;
		minX = centreX - (float) 0.5 * width / scale;

		maxY = centreY + (float) 0.5 * height / scale;
		minY = centreY - (float) 0.5 * height / scale;

	}

	@Override
	public String toString() {
		return "JuliaFractale [width=" + width + ", height=" + height + ", iterations=" + iterations + ", buffer="
				+ buffer + ", scale=" + scale + ", estompage=" + estompage + ", color=" + color + ", centreX=" + centreX
				+ ", centreY=" + centreY + ", maxX=" + maxX + ", minX=" + minX + ", maxY=" + maxY + ", minY=" + minY
				+ "]";
	}

	/**
	 * Parcours des pixels de la fenetre et choix 
	 * de coloration de chaque pixel via la méthode
	 *  colorCalcul(x,y) 
	 */
	protected void draw() {
		float X, Y;
		for (int x = 0; x < width; x += 1) {
			X = (float) x / scale + minX;
			for (int y = 0; y < height; y += 1) {
				Y = (float) y / scale + minY;
				final int color = colorCalcul(X, Y);
				buffer.setRGB(x, y, color);
			}
		}
	}
	

	public BufferedImage getDrawing() {
		draw();
		return buffer;
	}

	/**
	 * 
	 * Cette méthode doit être définie 
	 * pour chaque classe qui étend ComplexPolyFractal
	 * 
	 */
	public abstract int colorCalcul(double zx, double zy);

	
	
	 
	///////// GETTERS & SETTERS  //////
	
	
	public void setBuffer(BufferedImage bufferedImage) {
		this.buffer = bufferedImage;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getIterations() {
		return iterations;
	}

	public int getScale() {
		return scale;
	}

	public float getCentreX() {
		return centreX;
	}

	public float getCentreY() {
		return centreY;
	}

	public float getMaxX() {
		return maxX;
	}

	public float getMinX() {
		return minX;
	}

	public float getMaxY() {
		return maxY;
	}

	public float getMinY() {
		return minY;
	}

	public void setIterations(int iterations) {
		this.iterations = iterations;
	}

	public void setScale(int scale) {
		this.scale = scale;
		calcMinMax();
	}

	public void setCentreX(float centreX) {
		this.centreX = centreX;
		calcMinMax();
	}

	public void setCentreY(float centreY) {
		this.centreY = centreY;
		calcMinMax();
	}

	public void setMaxX(float maxX) {
		this.maxX = maxX;
	}

	public void setMinX(float minX) {
		this.minX = minX;
	}

	public void setMaxY(float maxY) {
		this.maxY = maxY;
	}

	public void setMinY(float minY) {
		this.minY = minY;
	}

	public void setHeight(int height) {
		this.height = height;

	}

	public void setWidth(int width) {
		this.width = width;

	}

}
