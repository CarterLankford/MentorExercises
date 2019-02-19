public class ArrayStack {
	//TODO: 
	// add relationship with interface and overrides for the functions
	private int arraySize;
	private int [] anArray;

	public void setArraySize(int arraySize){
		this.arraySize = arraySize;
	}

	//getting hung up here, can an array be created dynamicly? - we do in main
	// trying something similar in the constructor 
	public void createArrayStack(){
		anArray = new int[arraySize];
	}

	// public void push(int myValue){
	// 	anArray[0] = myValue;
	// }

	public int getValueAt(int theIndex){
		return anArray[theIndex];
	}

	//need all functions from interface in here, will lay them out

	public boolean push(int inputValue){
		anArray[0] = inputValue;
		return true; //just doing this for now until logic is built to return if successful or not
	}

	public boolean isFull(){
		return true; // place holder until logic is built
	}

	public boolean isEmpty(){
		return true; // place holder until logic is built
	}

	public int pop(){
		return anArray[0]; // want the top value which will always be index 0, need to add logic to check if empty or not
	}

	public int peek(){
		return anArray[0]; // want the top value which will always be index 0, need to add logic to check if empty or not
	}

	public int size(){
		return arraySize;
	}
}