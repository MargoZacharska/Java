import Narzedzia.Wyj�tekONP;

/**
 * @author GosiaZ
 * Klasa wylicza sinus dla argumentu
 */
public class Cos extends Funkcja{

	public Cos() {
		super(1);
	}

	@Override
	public double obliczWarto��() throws Wyj�tekONP {
		return Math.cos(argumenty[0]);
	}

}
