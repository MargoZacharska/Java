import Narzedzia.Wyj¹tekONP;

/**
 * @author GosiaZ
 *
 */
public class Dodaj extends Funkcja{

	public Dodaj() {
		super(2);
	}

	@Override
	public double obliczWartoœæ() throws Wyj¹tekONP {
		return argumenty[1] + argumenty[0];
	}

}
