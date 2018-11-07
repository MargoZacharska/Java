
public class BST <T extends Comparable<T>> implements Dict<T>{
	
	private class Node <T extends Comparable<T>>{
		Node<T> left, right, parent;
		T data;
		
		public Node(T data){
			this.data = data;
		}
	}
	
	private Node<T> root;


	public Node<T> search(T data) {
		Node<T> tmp = root;
		while (tmp != null && tmp.data != data){
			if (tmp.data.compareTo(data) > 0){
				tmp = tmp.left;
			}
			else{
				tmp = tmp.right;
			}
		}
		
		if (tmp == null){
			System.out.println("Key not found"); 
		}
		
		return tmp;
	}
	
	@Override
	public T search2(T data){
		return  search(data).data;
	}

	@Override
	public void insert(T data) {
		if (data == null){
			throw new NullPointerException();
		}
		if (root == null){
			root = new Node<T>(data);
			root.data = data;
		}
		else{
			Node<T> tmp = root;
			Node<T> parent = null;
			while(tmp != null){
				parent = tmp;
				if (tmp.data.compareTo(data) > 0){
					tmp = tmp.left;
				}
				else{
					tmp = tmp.right;
				}
			}
			tmp.data = data;
			if (parent.data.compareTo(data) > 1){
				parent.left = new Node<T>(data);
				parent.left.parent = parent;
			}
			else {
				 parent.right = new Node<T>(data);
				 parent.right.parent = parent;
			}
		}
		
	}

	@Override
	public void remove(T data) {
		Node<T> node = search(data);
		Node<T> tmp;
		if (node.left != null && node.right != null){
			tmp = nastepnik(data);
			remove(nastepnik(data).data);
			node = tmp;
		}
		if (node.left != null && node.right == null){
			node = node.left;
		}
		if (node.left == null && node.right != null){
			node = node.right;
		}
		if (node.left == null && node.right == null){
			node = null;
		}
		
	}

	@Override
	public T min() {
		Node<T> tmp = root;
		while(tmp.left != null){
			tmp = tmp.left;
		}
		return tmp.data;
	}

	@Override
	public T max() {
		Node<T> tmp = root;
		while(tmp.right != null){
			tmp = tmp.right;
		}
		return tmp.data;
	}
	
	
	private Node<T> nastepnik(T data){
		Node<T> node = search(data);
		if (node.right != null){
			node = node.right;
			while (node.left != null){
				node = node.left;
			return node;
			}
		}
		Node<T> tmp = node.parent;
		while(tmp != null && node.parent.left != node){
			node = tmp;
			tmp = tmp.parent;
			}
		return tmp;
//rzuc wyjatek jesli nastepnik nie znaleziony
	}
	

	public int size(Node<T> root){
		Node<T> tmp = root;
		if (root == null){
			return 0;
		}
		else{
			return 1 + size(tmp.left) + size(tmp.right);
		}
	}
	
	public void clear(){
		root = null;
	}
	
	@Override
	public String toString(){
		return toStringAll(root);
	}

	private String toStringAll(Node<T> node) {
		if (node == null){
			throw new NullPointerException();
		}
		return toStringAll(node.left) + " " + node.data + " " + toStringAll(node.right);
	}
}
