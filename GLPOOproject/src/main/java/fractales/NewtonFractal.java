package fractales;

import java.awt.Color;
import flanagan.complex.Complex;

public class NewtonFractal extends ComplexPolyFractal {

	

	public NewtonFractal(int a0, int a1, int a2, int scale, int width, int height, float estompage, float color,int a3) {
		super(a0, a1, a2, scale, width, height, estompage, color,a3);
	}

	public int colorCalcul(double zx, double zy)
	{
		int n = 0;
		
		Complex z = new Complex(zx,zy);
		
		for(; n < iterations; n++)
		{
			z = z.minus(((P1.evaluate(z))).over(P2.evaluate(z))); // z_(n+1) = z_n - P(z_n)/P'(z_n)
			for(Complex item : roots)
			{
				if(Math.abs(z.getReal() - item.getReal()) < epsilon && Math.abs(z.getImag() - item.getImag()) < epsilon)
						{
							return Color.HSBtoRGB(color +  (float)Math.sqrt((double) estompage/12 + n/iterations) , 0.65f, (float)15*n/iterations); 
							
						}
			}
		}
		return 0xFFFFFFFF;
}
}	
