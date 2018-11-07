import Narzedzia.Wyj¹tekONP;

public class Liczba extends Operand{
	private double stala;

	public Liczba(double stala) {
		super();
		this.stala = stala;
	}
	
	@Override
	public double obliczWartoœæ() throws Wyj¹tekONP{
		return stala;
	}
}
