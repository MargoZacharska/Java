package wyrazenia;

/**
 * @author GosiaZ
 * Klasa odpowiada za potegowanie
 */
public class Potegowanie extends Operator2arg{

	public Potegowanie(Wyrazenie arg1, Wyrazenie arg2) {
		super(arg1, arg2, 20, "^");
	}

	@Override
	public double oblicz() {
		return Math.pow(arg1.oblicz(), arg2.oblicz());
	}

}
