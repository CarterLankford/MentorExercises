/*
TODO:
Rather than having calculateResult do 
most of the heavy lifting, create more
functions to take the load of it. Not 
sure if setters are a good idea for 
value or not, will try to see what 
happens. 

That doesn't make any sense for setters
class is self contained, only setter
should be for the initial index request 
*/


class Fibonacci {

	public static void main(String[] args) {
		// Suggestion
		// System.out.println(calculateResult(12L)); // 233
		
			// System.out.println(calculateResult(1000000) + "\n"); // 144
			System.out.println(fib(1000000) + "\n"); // 144
		// for(int i = 0; i<1000; i++){
		// }
	}


	//using calculateresult as is (once converted into a static method) figure out the calculation. 
	// public long calculateResult() {
	// 	Fibonacci fb = new Fibonacci();
	// 	int x = 0;	//Setting Counter at 0	
	// 	while (x <= requestedIndex){			
	// 		result = fb.getSum(firstValue, secondValue);
	// 		firstValue = secondValue;
	// 		secondValue = result;
	// 		x++;
	// 		System.out.println( result + " I:" + x);			
	// 	}
	// 	return result;
	// }

	public static long calculateResult(int requestedIndex) {
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
			// System.out.println("R:" + result + " I:" + currentIndex);
		}
		// while (currentIndex <= requestedIndex) {
		// 	result = firstNumber + secondNumber;

		// 	firstNumber = secondNumber;
		// 	secondNumber = result;
		// 	System.out.println("R:" + result + " I:" + currentIndex);
		// 	currentIndex++;
		// }

		return result;
	}

// Recursion example of fibonacci, DO NOT USE: SUPER EXPENSIVE
	public static long fib(int index){
		if(index < 2){
			return index;
		}
		return fib(index - 1) + fib(index - 2);
	}
}