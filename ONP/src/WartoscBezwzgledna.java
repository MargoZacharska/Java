import Narzedzia.Wyj�tekONP;

public class WartoscBezwzgledna extends Funkcja{

	public WartoscBezwzgledna() {
		super(1);
	}

	@Override
	public double obliczWarto��() throws Wyj�tekONP {
		
		return Math.abs(argumenty[0]);
	}

}
