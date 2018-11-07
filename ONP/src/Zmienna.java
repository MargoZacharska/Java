import Narzedzia.Slownik;
import Narzedzia.Wyj�tekONP;

public class Zmienna extends Operand{
	String zmienna;
	Slownik sl;
	
	
	public Zmienna(String zmienna, Slownik sl){
		this.zmienna = zmienna;
		this.sl = sl;
	}
	
	@Override
	public double obliczWarto��() throws Wyj�tekONP {
		return sl.get(zmienna);
	}

}
