package Narzedzia;

public class Slownik extends Kolejka<Para>{
	
	
	public double get(String key) throws KeyNotFoundException{
		Node<Para> tmp = first;
		while(tmp != null){
			if (tmp.value.klucz.equals(key))
				return tmp.value.getWartosc();
			tmp = tmp.next;
		}
		throw new KeyNotFoundException(key);
	}
	/**
	 * 
	 * @param key 
	 */
	public void remove(String key){
		Node<Para> tmp = first;
		while(tmp != null){
			if(tmp.value.klucz.equals(key)){
				if (tmp == first){
					if (tmp.previous == null){
						first = tmp.next;
					}
					tmp.next.previous = tmp.previous;

				}
				else if (tmp == last){
					if (tmp.next == null){
						last = tmp.previous;
					}
					tmp.previous.next = tmp.next;
				}
				else{
					tmp.next.previous = tmp.previous;
					tmp.previous.next = tmp.next;
				}
				break;
			}
			tmp = tmp.next;
		}
	}
}
