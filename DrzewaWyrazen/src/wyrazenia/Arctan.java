package wyrazenia;

/**
 * @author GosiaZ
 * Klasa liczy wartoœæ funkcji arctan z danego wyra¿enia
 */
public class Arctan extends Operator1Arg{

	public Arctan(Wyrazenie arg1) {
		super(arg1);
	}

	@Override
	public double oblicz() {
		return Math.atan(arg1.oblicz());
	}
	
	@Override
	public String  toString(){
		return "arctg( " + arg1.toString() + " )";
	}

	@Override
	public int priorytet() {
		return 100;
	}

}
