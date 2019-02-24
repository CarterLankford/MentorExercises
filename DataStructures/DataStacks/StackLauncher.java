public class StackLauncher {
	public static void main(String[] args) {
		ArrayStack merp = new ArrayStack();
		System.out.println("Current stack: " + merp);
		System.out.println("IsFull: " + merp.isFull());
		System.out.println("IsEmpty: " + merp.isEmpty());
		System.out.println("Peek: " + merp.peek());
		System.out.println("Push: " + merp.push(20));
		System.out.println("Push: " + merp.push(5));
		System.out.println("Size: " + merp.size());
		// System.out.println("Pop: " + merp.pop());
		System.out.println("toString: " + merp.toString());

		System.out.println("Pop: " + merp.pop());



		// //the below is education on array creation, used for reference. 
		// int[] anArray; // declares an array of int
		// anArray	= new int[1]; // creates an array of 1 int starting at position 0
		// anArray[0] = 1; 
		// // anArray[1] = 2;


		// System.out.println(anArray[0]);
	}
}