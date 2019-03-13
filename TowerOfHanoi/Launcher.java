import java.util.Scanner;

public class Launcher{
	public static void main(String[] args){
		boolean recivedExitCode = false;
		Scanner sc = new Scanner(System.in);
		String x = "";
		int currentTurn = 0;

		
		System.out.print("Plate Count: ");
		int plateCount = sc.nextInt();

		while(!x.equals("exit")){
			if (currentTurn > 0){
				//while looping the game magic happens here.
				x = sc.next(); 
				currentTurn++;
			} else {
				//all the preset up stuff can happen here.
				ArrayStack aStack = new ArrayStack();
				ArrayStack bStack = new ArrayStack();
				ArrayStack cStack = new ArrayStack();

				System.out.println("Towers of Hanoi");
				System.out.println("========================================");
				System.out.println(aStack.toString() + "\n" + bStack.toString() + "\n" + cStack.toString());
				currentTurn++;
			}
		}

		// ArrayStack aStack = new ArrayStack();
		// ArrayStack bStack = new ArrayStack();
		// ArrayStack cStack = new ArrayStack();

		// System.out.println("Towers of Hanoi");
		// System.out.println("========================================");
		// System.out.println(aStack.toString() + "\n" + bStack.toString() + "\n" + cStack.toString());

		// if (currentTurn > 0){
		// 	//while looping the game magic happens here. 
		// } else {
		// 	//all the preset up stuff can happen here.
		// }




		//TODO: 
		// Gather from user how many plates int plateCount
		// create the 3 arrays ABC and pass them the count variable
		// Load A with all the plates
		// Print the first screen
		// Check to see if player won



		// Scanner sc = new Scanner(System.in);
		// String x = "";
		// while (!x.equals("exit")){
		// 	x = sc.next();
		// 	System.out.println("time to loop");
		// }

		// System.out.println("exit code entered");
		
	}
}