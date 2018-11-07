import Narzedzia.Wyj¹tekONP;

public class Pomnoz extends Funkcja{

	public Pomnoz() {
		super(2);
	}

	@Override
	public double obliczWartoœæ() throws Wyj¹tekONP {
		return argumenty[0] * argumenty[1];
	}

}
