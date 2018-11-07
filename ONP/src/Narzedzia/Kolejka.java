package Narzedzia;

public class Kolejka<T> {
	
	protected Node<T> first = null;
	protected Node<T> last = null;
	
	protected static class Node<T>{
		public Node(T value){
			this.value = value;
		}
		public Node<T> next;
		public Node<T> previous;
		public T value;
	}
	
	/*public void Add(T value){
		Node<T> node = new Node<T>(value);
		if (first == null){
			first = node;
		}
		else{
			Node<T> tmp = first;
			while(tmp.next != null){
				tmp = tmp.next;
			}
			tmp.next = node;
		}
	}*/
	
	public void Add(T value){
		Node<T> node = new Node<T>(value);
		if (first == null){
			first = node;
			last = node;
		}
		else{
			node.previous = last;
			last.next = node;
			last = last.next;
		}
		
	}
	
	public T GetFirst(){
		if(first == null)
			return null;
		T value = first.value;
		first = first.next;
		if(first != null)
		{
			first.previous = null;
		}else
		{
			last = null;
		}
		return value;
	}
	
	public T GetLast(){
		if(last == null)
			return null;
		T value = last.value;
		last = last.previous;
		if (last != null){
			last.next = null;
		}
		else{
			first = null;
		}
		return value;
	}
	
	
	
}
