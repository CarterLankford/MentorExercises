public class ArrayStack {
	private int arraySize;
	private int [] anArray;


	public ArrayStack() {

	}


	public void setArraySize(int arraySize){
		this.arraySize = arraySize;
		// anArray = new int[arraySize];
	}

	//getting hung up here, can an array be created dynamicly? - we do in main
	// trying something similar in the constructor 
	public void createArrayStack(){
		anArray = new int[arraySize];
	}

	public void push(int myValue){
		anArray[0] = myValue;
	}

	public int getValueAt(int theIndex){
		return anArray[theIndex];
	}
}