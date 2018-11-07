package wyrazenia;

/**
 * @author GosiaZ
 * Klasa abstrakcyjna po której dziedzicz¹ wszystkie operatory dwuargumentowe, zawiera metodê toString tak¹ sama dla wszystkich klas dziedzicz¹cych po niej
 */
public abstract class Operator2arg extends Operator1Arg{

	protected Wyrazenie arg2;
	protected int _priorytet;
	private String op;
	public Operator2arg(Wyrazenie arg1, Wyrazenie arg2, int _priorytet, String op) {
		super(arg1);
		this.arg2 = arg2;
		this._priorytet = _priorytet;
		this.op = op;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		if (arg1.priorytet() < _priorytet){
			sb.append("( " + arg1.toString() + " ) " + op + " ");
		}
		else sb.append(arg1.toString() + " " + op + " ");
		if (arg2.priorytet() < _priorytet){
			sb.append("( " + arg2.toString() + " )");
		}
		else sb.append(arg2.toString());
		return sb.toString();
	}
	
	@Override 
	public int priorytet()
	{
		return _priorytet;
	}

}
