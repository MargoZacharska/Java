import Narzedzia.Wyj�tekONP;

public class Liczba extends Operand{
	private double stala;

	public Liczba(double stala) {
		super();
		this.stala = stala;
	}
	
	@Override
	public double obliczWarto��() throws Wyj�tekONP{
		return stala;
	}
}
