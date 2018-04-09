package fractales;

import java.awt.Color;
import flanagan.complex.Complex;

public class HalleyFractal extends ComplexPolyFractal {
		

	public HalleyFractal(int a0, int a1, int a2, int scale, int width, int height, float estompage, float color,int a3) {
		super(a0, a1, a2, scale, width, height, estompage, color,a3);
	}

	public int colorCalcul(double zx, double zy)
	{
		int n = 0;
		
		Complex z = new Complex(zx,zy);
		
		for(; n < iterations; n++)
		{
			Complex numerateur = P1.evaluate(z).times(P2.evaluate(z)).times(new Complex(2,0)); //2.P(z_n).P'(z_n)
			Complex denominateur = new Complex(2,0).times(P2.evaluate(z)).times(P2.evaluate(z)).minus(P1.evaluate(z).times(P3.evaluate(z))); //2.P'(z_n)² - P(z_n).P''(z_n)
			z = z.minus(numerateur.over(denominateur)); 
			for(Complex item : roots)
			{
				if(Math.abs(z.getReal() - item.getReal()) < epsilon && Math.abs(z.getImag() - item.getImag()) < epsilon)
						{
							return Color.HSBtoRGB((float) (color + (float)((1-color)*n/iterations)) , 0.65f, (float)10*estompage*n/iterations);
							
						}
			}
		}
		return 0xFFFFFFFF;
}
	
	
		
}	
