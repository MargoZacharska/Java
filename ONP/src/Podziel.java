import Narzedzia.Wyj�tekONP;

public class Podziel extends Funkcja{

	public Podziel() {
		super(2);
	}
	
	@Override
	public double obliczWarto��() throws Wyj�tekONP{
		return argumenty[1] / argumenty[0];
	}
}
