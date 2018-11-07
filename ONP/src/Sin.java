import Narzedzia.Wyj¹tekONP;

public class Sin extends Funkcja{

	public Sin() {
		super(1);
	}

	@Override
	public double obliczWartoœæ() throws Wyj¹tekONP {
		return Math.sin(argumenty[0]);
	}

}
