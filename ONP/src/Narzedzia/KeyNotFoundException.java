package Narzedzia;

public class KeyNotFoundException extends Wyj�tekONP{
	
	private String Key;
	public KeyNotFoundException(String key) {
		this.Key = key;
	}
	@Override 
	public String toString(){
		return "Klucz: " + Key + " nie znaleziony.";
	}
}
