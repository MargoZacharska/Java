package wyrazenia;

/**
 * @author GosiaZ
 * Klasa zwraca wartoœæ bezwglêdn¹ danego wyra¿enia
 */
public class WartoscBezwzgledna extends Operator1Arg{

	public WartoscBezwzgledna(Wyrazenie arg1) {
		super(arg1);
	}

	@Override
	public double oblicz() {
		return Math.abs(arg1.oblicz());
	}
	
	@Override
	public String toString(){
		return "|" + arg1.toString() + "|";
	}

	@Override
	public int priorytet() {
		return 100;
	}

}
