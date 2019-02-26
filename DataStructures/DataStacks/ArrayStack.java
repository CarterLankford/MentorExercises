public class ArrayStack implements Stack{
	//TODO: 
	// add relationship with interface and overrides for the functions
	
	private Integer[] anArray;
	private int stackElementCount = 0;


	public ArrayStack() { 
		anArray = new Integer[10];
	}

	
	//need all functions from interface in here, will lay them out

	@Override //work here
	public boolean push(int inputValue){
		if(isFull()){
			System.out.println("Already Full");
			return false;
		}
		// TODO: add right shift
		int q = stackElementCount;
		for (int i=0; i < stackElementCount; i++) {
			int y = q -1;
			anArray[q] = anArray[y];
			q--;
		}
		anArray[0] = inputValue;
		stackElementCount++;
		System.out.println(inputValue);

		return true; //just doing this for now until logic is built to return if successful or not
	}

	@Override
	public boolean isFull(){
		return stackElementCount == 10; 
	}

	@Override
	public boolean isEmpty(){
		return stackElementCount == 0;
	}

	@Override //work here
	public Integer pop(){
		if(isEmpty()){
			System.out.println("Already empty");
			return null;
		}
		// TODO: add left shift
		stackElementCount--;
		return anArray[0]; // want the top value which will always be index 0, need to add logic to check if empty or not
	}

	@Override
	public Integer peek(){
		return anArray[0]; // want the top value which will always be index 0, need to add logic to check if empty or not
	}

	@Override
	public int size(){
		return stackElementCount;
	}

	//TODO: fix the spacing
	@Override
	public String toString(){
		String result = "[";
		for (int i = 0; i < stackElementCount; i++){
			result = result + anArray[i] + " ";  
		}
		result += "]";
		return result;
	}
}