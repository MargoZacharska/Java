package wyrazenia;

/**
 * @author GosiaZ
 * Klasa liczy logarytm, gdzie pierwsze wyra¿enie jest podstaw¹ logarytmu
 */
public class Logarytmowanie extends Operator2arg{

	public Logarytmowanie(Wyrazenie arg1, Wyrazenie arg2) {
		super(arg1, arg2, 150, "log");
	}

	@Override
	public double oblicz() {
		return Math.log(arg2.oblicz())/Math.log(arg1.oblicz());
	}

}
