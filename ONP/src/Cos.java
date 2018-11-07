import Narzedzia.Wyj¹tekONP;

/**
 * @author GosiaZ
 * Klasa wylicza sinus dla argumentu
 */
public class Cos extends Funkcja{

	public Cos() {
		super(1);
	}

	@Override
	public double obliczWartoœæ() throws Wyj¹tekONP {
		return Math.cos(argumenty[0]);
	}

}
