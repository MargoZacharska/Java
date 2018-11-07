import Narzedzia.Wyj¹tekONP;

public class Potega extends Funkcja{

	public Potega() {
		super(2);
	}

	/**
	 * @return potêga
	 */
	@Override
	public double obliczWartoœæ() throws Wyj¹tekONP {
		return Math.pow(argumenty[1],  argumenty[0]);
	}

}
