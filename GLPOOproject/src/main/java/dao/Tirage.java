package dao;


public interface Tirage {
	int getB1();
	int getB2();
	int getB3();
	int getB4();
	int getB5();
	int getE1();
	int getE2();
	
	void setB1(int b1);
	void setB2(int b2);
	void setB3(int b3);
	void setB4(int b4);
	void setB5(int b5);
	void setE1(int e1);
	void setE2(int e2);
	
	String toStringBis();
}
