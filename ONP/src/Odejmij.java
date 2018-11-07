import Narzedzia.NotEnoughtArgException;
import Narzedzia.Wyj�tekONP;

public class Odejmij extends Funkcja{

	public Odejmij() {
		super(2);
	}

	@Override
	public double obliczWarto��() throws Wyj�tekONP {
		if (ar != assigned){
			throw new NotEnoughtArgException();
		}
		return argumenty[1] - argumenty[0];
	}

}
