package wyrazenia;

/**
 * @author GosiaZ
 * Klasa g³ówna s³u¿aca do testowania programu
 */
public class Main {

	public static void main(String[] args) {
		Para p = new Para("a",2);
		Para p2 = new Para("b",16);
		Para p3 = new Para("x", -1.618);
		Zmienna.zbior.wstaw(p);
		Zmienna.zbior.wstaw(p2);
		Zmienna.zbior.wstaw(p3);
		Wyrazenie w = new Dodawanie(
				new Dodawanie(
						new Zmienna("a"),
						new Stala(7)),
				new Stala(10));
		System.out.println(w + " = " + w.oblicz());
		Wyrazenie w2 = new Mnozenie(
				new Dodawanie(
						new Stala(13),
						new Mnozenie(
								new Zmienna("a"),
								new Zmienna("c"))),
				new Dzielenie(
						new Stala(3),
						new Stala(1)));
		System.out.println(w2 + " = " + w2.oblicz());
		System.out.println(Wyrazenie.sumuj(new Stala(3),new Stala(4),new Stala(5)));
		System.out.println(Wyrazenie.pomnoz(new Stala(3), new Stala(4), new Stala(5), new Stala(6)));
		
		Wyrazenie wyrazenie = new Dodawanie(
				new Stala(7),
				new Mnozenie(
						new Zmienna("x"),
						new Stala(5)));
		System.out.println(wyrazenie + " = " + wyrazenie.oblicz());
	}

}
