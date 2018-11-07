package wyrazenia;

/**
 * @author GosiaZ
 * Klasa przyjmuje dwa wyra¿enia i dzieli jedno przez drugie
 */
public class Dzielenie extends Operator2arg{

	public Dzielenie(Wyrazenie arg1, Wyrazenie arg2) {
		super(arg1, arg2, 10, "/");
	}

	@Override
	public double oblicz() {
		return arg1.oblicz() / arg2.oblicz();
	}

}
