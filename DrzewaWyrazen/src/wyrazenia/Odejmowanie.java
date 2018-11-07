package wyrazenia;

/**
 * @author GosiaZ
 * Klasa wykonuj�ca odejmowanie dw�ch wyra�e�
 */
public class Odejmowanie extends Operator2arg{

	public Odejmowanie(Wyrazenie arg1, Wyrazenie arg2) {
		super(arg1, arg2, 1, "-");
	}

	@Override
	public double oblicz() {
		return arg1.oblicz() - arg2.oblicz();
	}

}
