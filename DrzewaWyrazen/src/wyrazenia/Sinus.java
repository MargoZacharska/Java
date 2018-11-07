package wyrazenia;

/**
 * @author GosiaZ
 * Klasa obliczaj¹ca funkcjê sinus wyra¿enia
 */
public class Sinus extends Operator1Arg{

	public Sinus(Wyrazenie arg1) {
		super(arg1);
	}

	@Override
	public double oblicz() {
		return Math.sin(arg1.oblicz());
	}

	@Override
	public String toString(){
		return "sin( " + arg1.toString() + " )";
	}

	@Override
	public int priorytet() {
		return 100;
	}
}
