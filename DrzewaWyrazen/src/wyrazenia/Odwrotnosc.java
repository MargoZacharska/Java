package wyrazenia;

/**
 * @author GosiaZ
 * Klasa oblicza odwrotnoœæ danego wyra¿enia
 */
public class Odwrotnosc extends Operator1Arg{

	public Odwrotnosc(Wyrazenie arg1) {
		super(arg1);
	}

	@Override
	public double oblicz() {
		return 1/arg1.oblicz();
	}
	
	@Override
	public String toString(){
		return "( 1 / " + arg1.toString() + " )";
	}

	@Override
	public int priorytet() {
		return 10;
	}

}
