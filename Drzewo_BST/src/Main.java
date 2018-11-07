
public class Main {

	public static void main(String[] args) {

		BST<Integer> bst = new BST<>();
		bst.insert(6);
		bst.insert(1);
		bst.insert(2);
		bst.insert(7);
		bst.insert(3);
		bst.insert(9);
		bst.insert(5);
		bst.toString();
		bst.max().toString();
		bst.min().toString();
		bst.remove(7);
		bst.toString();
		bst.clear();
		bst.toString();
		
	}

}
