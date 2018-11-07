package wyrazenia;

/**
 * @author GosiaZ
 * Klasa liczy wartoœæ wyra¿enia przeciwnego do podanego
 */
public class Przeciwienstwo extends Operator1Arg{
	
	
	
	public Przeciwienstwo(Wyrazenie arg1) {
		super(arg1);
	}

	@Override
	public double oblicz() {
		return -arg1.oblicz();
	}
	
	@Override
	public String toString(){
		return "-" + arg1.toString();
	}

	@Override
	public int priorytet() {
		return 50;
	}
	
	
}
