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
		anArray[0] = inputValue;
		if(isFull()){
			System.out.println("Not Full");
		}

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