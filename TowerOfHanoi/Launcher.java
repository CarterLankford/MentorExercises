import java.util.Scanner;

public class Launcher{
	private String[] choices;
	public static void main(String[] args){
		boolean recivedExitCode = false;
		Scanner sc = new Scanner(System.in);
		String x = "";
		int currentTurn = 0;

		
		System.out.print("Plate Count: ");
		int plateCount = sc.nextInt();
		ArrayStack aStack = new ArrayStack(plateCount);
		ArrayStack bStack = new ArrayStack(plateCount);
		ArrayStack cStack = new ArrayStack(plateCount);

		while(!x.equals("exit")){
			if (currentTurn > 0){
				//while looping the game magic happens here.
				//at the beginning of the loop check to see if player won. 
				String y = "";
				if((bStack.isFull()) || (cStack.isFull())){
					System.out.println("Game over you won in " + currentTurn + " moves.");
					break;
				}

				x = sc.nextLine(); // Looks for next user entry
				
				
				//going to cheat to force the win
				// PS this could break the game if the array has anything in it maybe....need to test that. 
				if(x.equals("cheat")){
					for (int i = 0; i < plateCount; i++){
						cStack.push(plateCount - i);
					}
				}


				currentTurn++;
			} else {
				//all the preset up stuff can happen here.
				// ArrayStack aStack = new ArrayStack(plateCount);
				// ArrayStack bStack = new ArrayStack(plateCount);
				// ArrayStack cStack = new ArrayStack(plateCount);

				for (int i = 0; i < plateCount; i++){
					aStack.push(plateCount - i);
				}

				System.out.println("Towers of Hanoi");
				System.out.println("========================================");
				System.out.println(aStack.toString() + "\n" + bStack.toString() + "\n" + cStack.toString());
				currentTurn++;
			}
		}

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