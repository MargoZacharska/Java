import Narzedzia.Slownik;
import Narzedzia.Wyj¹tekONP;

public class Zmienna extends Operand{
	String zmienna;
	Slownik sl;
	
	
	public Zmienna(String zmienna, Slownik sl){
		this.zmienna = zmienna;
		this.sl = sl;
	}
	
	@Override
	public double obliczWartoœæ() throws Wyj¹tekONP {
		return sl.get(zmienna);
	}

}
