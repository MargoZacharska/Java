import Narzedzia.Wyj�tekONP;

public interface Funkcyjny extends Obliczalny{
	int arnosc();
	int brakujaceArgumenty();
	void dodajArgument(double arg) throws Wyj�tekONP;
}
