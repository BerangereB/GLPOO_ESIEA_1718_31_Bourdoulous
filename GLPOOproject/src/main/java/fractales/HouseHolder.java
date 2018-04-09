package fractales;

import java.awt.Color;
import flanagan.complex.Complex;

public class HouseHolder extends ComplexPolyFractal {


	public HouseHolder(int a0, int a1, int a2, int scale, int width, int height, float estompage, float color,int a3) {
		super(a0, a1, a2, scale, width, height, estompage, color,a3);
	}

	public int colorCalcul(double zx, double zy)
	{
		int n = 0;
		
		Complex z = new Complex(zx,zy);
		
		for(; n < iterations; n++)
		{
			Complex h = ((P1.times(P3)).evaluate(z)).over(((P2.evaluate(z).pow(2))).times(2));
			z = z.minus(((P1.evaluate(z)).times(h.plus(1))).over(P2.evaluate(z))); 
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
