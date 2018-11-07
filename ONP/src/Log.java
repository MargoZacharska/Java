import Narzedzia.Wyj¹tekONP;

public class Log extends Funkcja{

	public Log() {
		super(2);
	}

	@Override
	public double obliczWartoœæ() throws Wyj¹tekONP {
		return Math.log(argumenty[1])/Math.log(argumenty[0]);
	}

}
