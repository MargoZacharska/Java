package wyrazenia;

/**
 * @author GosiaZ
 * Klasa zwracaj¹ca wartoœæ dla podanego klucza i napis String podanego klucza
 */
public class Zmienna extends Wyrazenie{

	static final int max = 6;
	public static Zbior zbior = new Zbior(max);
	
	
	private String x;
	public  Zmienna(String x) {
		this.x = x;
	}
	
	@Override
	public double oblicz() {
		try{
			zbior.czytaj(x);
		}
		catch(NullPointerException e){
			System.out.println("Nieznana wartosc dla podanej zmiennej " + x + ". Wyliczona wartoœæ zostanie podana dla 0.");
			return 0;
		}
		return zbior.czytaj(x);
	}
	
	@Override
	public String toString(){
		return x;
	}

	@Override
	public int priorytet() {
		return 100;
	}

}
