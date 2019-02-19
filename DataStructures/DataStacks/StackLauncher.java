public class StackLauncher {
	public static void main(String[] args) {
		ArrayStack merp = new ArrayStack();
		merp.setArraySize(4);
		merp.createArrayStack();
		merp.push(5);
		// merp.getValueAt(0);
		int x = merp.getValueAt(0);
		System.out.println(x);

		int[] anArray; // declares an array of int
		anArray	= new int[1]; // creates an array of 1 int starting at position 0
		anArray[0] = 1; 
		// anArray[1] = 2;


		System.out.println(anArray[0]);
	}
}