import Narzedzia.Wyj�tekONP;

public class Potega extends Funkcja{

	public Potega() {
		super(2);
	}

	/**
	 * @return pot�ga
	 */
	@Override
	public double obliczWarto��() throws Wyj�tekONP {
		return Math.pow(argumenty[1],  argumenty[0]);
	}

}
