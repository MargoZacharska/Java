

public interface Dict <T extends Comparable<T>>{

	public T search2(T data);
	public void insert(T data);
	public void remove(T data);
	public T min();
	public T max();
}
