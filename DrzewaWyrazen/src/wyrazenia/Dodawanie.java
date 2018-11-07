package wyrazenia;

/**
 * @author GosiaZ
 * Klasa odpowiada za dodawanie wyra¿eñ
 */
public class Dodawanie extends Operator2arg{

	

	public Dodawanie(Wyrazenie arg1, Wyrazenie arg2) {
		super(arg1, arg2, 1, "+");
	}

	@Override
	public double oblicz() {
		
		return arg1.oblicz() + arg2.oblicz();
	}

}
