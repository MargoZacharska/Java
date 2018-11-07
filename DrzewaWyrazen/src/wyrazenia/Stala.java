package wyrazenia;

/**
 * @author GosiaZ
 * Klasa zwracaj¹ca wartoœæ podanej sta³ej oraz jest zapis
 */
public class Stala extends Wyrazenie{
	private double x;

	public Stala(double x){
		this.x = x;
	}

	@Override
	public double oblicz() {
		return x;
	}
	
	@Override
	public String toString(){
		return " " + x + " ";
	}

	@Override
	public int priorytet() {
		return 100;
	}

}
