import Narzedzia.Wyj�tekONP;

public class Log extends Funkcja{

	public Log() {
		super(2);
	}

	@Override
	public double obliczWarto��() throws Wyj�tekONP {
		return Math.log(argumenty[1])/Math.log(argumenty[0]);
	}

}
