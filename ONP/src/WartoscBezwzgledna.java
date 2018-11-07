import Narzedzia.Wyj¹tekONP;

public class WartoscBezwzgledna extends Funkcja{

	public WartoscBezwzgledna() {
		super(1);
	}

	@Override
	public double obliczWartoœæ() throws Wyj¹tekONP {
		
		return Math.abs(argumenty[0]);
	}

}
