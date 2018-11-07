package wyrazenia; 

/**
 * @author GosiaZ
 * Klasa abstrakcyjna stanowi¹ca podstawê drzewa wyra¿eñ, zawiar dwie dodatkowe metody ze zmienna liczb¹ argumentów
 */
public abstract class Wyrazenie {
	public abstract double oblicz();
	public abstract int priorytet();
	
	public static double sumuj(Wyrazenie... wyr){
		Wyrazenie wynik = wyr[0];
		for (int i = 1; i < wyr.length; i++){
			wynik = new Dodawanie(wynik,wyr[i]);
		}
		return wynik.oblicz();
	}
	public static double pomnoz(Wyrazenie... wyr){
		Wyrazenie wynik = wyr[0];
		for (int i = 1; i < wyr.length; i++){
			wynik = new Mnozenie(wynik,wyr[i]);
		}
		return wynik.oblicz();
	}
}
