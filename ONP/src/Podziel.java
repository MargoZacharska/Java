import Narzedzia.Wyj¹tekONP;

public class Podziel extends Funkcja{

	public Podziel() {
		super(2);
	}
	
	@Override
	public double obliczWartoœæ() throws Wyj¹tekONP{
		return argumenty[1] / argumenty[0];
	}
}
