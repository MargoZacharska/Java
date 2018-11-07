package wyrazenia;

/**
 * @author GosiaZ
 * Klasa abstrakcyjna po której dziedzicz¹ operatory jednoargumentowe oraz klasa abstrakcyjna Operator2Arg
 */
public abstract class Operator1Arg extends Wyrazenie{
	protected Wyrazenie arg1;

	public Operator1Arg(Wyrazenie arg1){
		this.arg1 = arg1;
	}
}
