import Narzedzia.Wyj�tekONP;

public class Pomnoz extends Funkcja{

	public Pomnoz() {
		super(2);
	}

	@Override
	public double obliczWarto��() throws Wyj�tekONP {
		return argumenty[0] * argumenty[1];
	}

}
