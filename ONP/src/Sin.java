import Narzedzia.Wyj�tekONP;

public class Sin extends Funkcja{

	public Sin() {
		super(1);
	}

	@Override
	public double obliczWarto��() throws Wyj�tekONP {
		return Math.sin(argumenty[0]);
	}

}
