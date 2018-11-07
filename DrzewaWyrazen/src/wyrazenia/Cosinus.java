package wyrazenia;

/**
 * @author GosiaZ
 * Klasa wylicza funkcjê cosinus
 */
public class Cosinus extends Operator1Arg{

	public Cosinus(Wyrazenie arg1) {
		super(arg1);
	}

	@Override
	public double oblicz() {
		return Math.cos(arg1.oblicz());
	}
	
	@Override
	public String toString(){
		return "cos( " + arg1.toString() + " )";
	}

	@Override
	public int priorytet() {
		return 100;
	}

}
