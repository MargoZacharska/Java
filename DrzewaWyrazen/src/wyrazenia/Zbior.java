package wyrazenia;
/**
 * @author GosiaZ
 * Klasa Zbi�r przechowuje pary, w zbiorze nie wyst�puj� pary o tym samym kluczu
 */
public class Zbior {
	
	private Para[] zbior;
	private int il_elementow;
	
	public Zbior(int max){
		zbior = new Para[max];
		il_elementow = 0;				
	}
	
	
	
	/** metoda szuka pary z okre�lonym kluczem */
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
	
	/** metoda wstawia do zbioru now� par� */
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
				System.out.println("brak dost�pnych miejsc w tablicy");
			}
		}
	}
	
	/** metoda odszukuje par� i zwraca warto�� zwi�zan� z kluczem */
	public double czytaj(String kl) throws IllegalArgumentException {
		//Para p = szukaj(kl);
		//return p.getWartosc();
		return szukaj(kl).getWartosc();
	}
	
	/** metoda wstawia do zbioru now� albo aktualizuje istniej�c� par� */
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
