package wyrazenia;
/**
 * @author GosiaZ
 * Klasa Para przechowuje pary klucz-wartoœæ
 */
public class Para {
	public Para(String klucz, double wartosc){
		super();
		this.klucz = klucz;
		this.wartosc = wartosc;
	}
	public final String klucz;
	private double wartosc;
	
	public double getWartosc(){
		return wartosc;
	}
	
	public void setWartosc(double wartosc){
		this.wartosc = wartosc;
	}
	
	@Override
	public java.lang.String toString() {
		return String.format("%s,%f", klucz,wartosc);
	}
	
	@Override
	public boolean equals(Object obj){
		if (obj instanceof Para){
			Para p2 = (Para)obj;
			return klucz.equals(p2.klucz);
		}
		return false;
	}
}
