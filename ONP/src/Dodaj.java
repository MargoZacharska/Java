import Narzedzia.Wyj�tekONP;

/**
 * @author GosiaZ
 *
 */
public class Dodaj extends Funkcja{

	public Dodaj() {
		super(2);
	}

	@Override
	public double obliczWarto��() throws Wyj�tekONP {
		return argumenty[1] + argumenty[0];
	}

}
