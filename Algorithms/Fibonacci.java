class Fibonacci {

	public static void main(String[] args) {
		// Suggestion
		// System.out.println(fib(1000000) + "\n"); 
		for(int i = 0; i<1000; i++){
			calculateResult(3);
		}
	}

	public static long calculateResult(int requestedIndex) {
		//To find out if value is 0,1  Placed at start to be cheap and not use memory when not needed. 
		if(requestedIndex < 2){
			return requestedIndex;
		}

		long firstNumber = 0L;
		long secondNumber = 1L;
		long result = 0L;
		
		for (int currentIndex = 2; currentIndex <= requestedIndex; currentIndex++){
			result = firstNumber + secondNumber;

			firstNumber = secondNumber;
			secondNumber = result;
			System.out.println(result);
		}

		//How to do as While loop, converted to for loop since end of index is known
		/*
		while (currentIndex <= requestedIndex) {
			result = firstNumber + secondNumber;

			firstNumber = secondNumber;
			secondNumber = result;
			System.out.println("R:" + result + " I:" + currentIndex);
			currentIndex++;
		}
		*/
		

		return result;
	}

// Recursion example of fibonacci, DO NOT USE: SUPER EXPENSIVE
/*
	
	public static long fib(int index){
		if(index < 2){
			return index;
		}
		return fib(index - 1) + fib(index - 2);
	}
*/
}