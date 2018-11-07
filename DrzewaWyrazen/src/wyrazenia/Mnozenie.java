package wyrazenia;

/**
 * @author GosiaZ
 * Klasa mno¿y dane wyra¿enia
 */
public class Mnozenie extends Operator2arg{

	public Mnozenie(Wyrazenie arg1, Wyrazenie arg2) {
		super(arg1, arg2, 10, "*");
		// TODO Auto-generated constructor stub
	}

	@Override
	public double oblicz() {
		return arg1.oblicz() * arg2.oblicz();
	}

}
