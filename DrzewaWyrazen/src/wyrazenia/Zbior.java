package wyrazenia;
/**
 * @author GosiaZ
 * Klasa Zbiór przechowuje pary, w zbiorze nie wystêpuj¹ pary o tym samym kluczu
 */
public class Zbior {
	
	private Para[] zbior;
	private int il_elementow;
	
	public Zbior(int max){
		zbior = new Para[max];
		il_elementow = 0;				
	}
	
	
	
	/** metoda szuka pary z okreœlonym kluczem */
	public Para szukaj(String kl) {
		for (int i = 0; i < zbior.length; i++){
			if (zbior[i] == null){
				return null;
			}
			else {
				if (kl.equals(zbior[i].klucz)){
					return zbior[i];
				}
			}
		}
		return null;
	}
	
	/** metoda wstawia do zbioru now¹ parê */
	public void wstaw(Para p) throws IllegalArgumentException {
		if (szukaj(p.klucz) == null){
			int i;
			for (i = 0; i < zbior.length; i++){
				if(zbior[i] == null){
					zbior[i] = p;
					il_elementow += 1;
					break;
				}
			}
			if(i == zbior.length){
				System.out.println("brak dostêpnych miejsc w tablicy");
			}
		}
	}
	
	/** metoda odszukuje parê i zwraca wartoœæ zwi¹zan¹ z kluczem */
	public double czytaj(String kl) throws IllegalArgumentException {
		//Para p = szukaj(kl);
		//return p.getWartosc();
		return szukaj(kl).getWartosc();
	}
	
	/** metoda wstawia do zbioru now¹ albo aktualizuje istniej¹c¹ parê */
	public void ustal(Para p) throws IllegalArgumentException {
		if (szukaj(p.klucz) == null){
			wstaw(p);
		}
		
		for (int i = 0; i < zbior.length; i++){
			if (zbior[i].klucz == p.klucz){
				zbior[i] = p;
				break;
			}
		}
		
	}
	
	/** metoda podaje ile par jest przechowywanych w zbiorze */
	public int ile(){
		return il_elementow;
	}
	
	/** metoda usuwa wszystkie pary ze zbioru */
	public void czysc(){
		for(int i = 0; i < zbior.length; i++){
			zbior[i] = null;
		}
	}
}
