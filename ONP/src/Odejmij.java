import Narzedzia.NotEnoughtArgException;
import Narzedzia.Wyj¹tekONP;

public class Odejmij extends Funkcja{

	public Odejmij() {
		super(2);
	}

	@Override
	public double obliczWartoœæ() throws Wyj¹tekONP {
		if (ar != assigned){
			throw new NotEnoughtArgException();
		}
		return argumenty[1] - argumenty[0];
	}

}
