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
	private int requestedIndex;
	private long firstValue;
	private long secondValue;
	private long result;

	public static void main(String[] args) {
		Fibonacci fb = new Fibonacci();

		fb.setIndex(5);
		fb.calculateResult();
	
	}

	public long calculateResult() {
		Fibonacci fb = new Fibonacci();

		int x = 0;	//Setting Counter at 0	
		while (x <= requestedIndex){
			if (x == 0) {
				System.out.println(result + " I:" + x);
				x++; //We know everhting will equal 0
			} else if (x == 1) {
				firstValue = 1;
				result = fb.getSum(firstValue, secondValue);
				System.out.println(result + " I:" + x);
				firstValue = secondValue;
				secondValue = result;
				x++;
			} else {
				result = fb.getSum(firstValue, secondValue);
				System.out.println(result + " I:" + x);
				firstValue = secondValue;
				secondValue = result;
				x++;
			}
		}
		return result;
	}

	public long getSum(long firstInt, long secondInt) {
		result = firstInt + secondInt;
		return result;
	}

	public int getIndex() {
		return requestedIndex;
	}

	public void setIndex(int requestedIndex) {
		this.requestedIndex = requestedIndex;
	}
}