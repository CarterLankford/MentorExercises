public interface Stack {
	boolean push(int inputValue);
	boolean isFull();
	boolean isEmpty();
	Integer pop();
	Integer peek();
	int size();
}