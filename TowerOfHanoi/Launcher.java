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
				
				if((bStack.isFull()) || (cStack.isFull())){
					System.out.println("Game over you won in " + currentTurn + " moves.");
					break;
				}

				x = sc.nextLine(); // Looks for next user entry
				char[] merp = x.toCharArray();
				char fromOriginalArray;
				char toTargetArray;
				int valueToMove = 0;

				//get it to work first, then optimize/refactor it
				if (merp.length == 3){
					fromOriginalArray = (char)Sanitize(merp[0]);
					toTargetArray = (char)Sanitize(merp[2]);


					//This is really ugly and I regret everything. Wanted to make it work before it was pretty/reworked
					if (fromOriginalArray == 'a' && toTargetArray == 'b') {
						System.out.println("a to b");
						if(!aStack.isEmpty()){
							if (bStack.isEmpty()){
								bStack.push(aStack.peek());
								aStack.pop();

								System.out.println("Towers of Hanoi");
								System.out.println("========================================");
								System.out.println(aStack.toString() + "\n" + bStack.toString() + "\n" + cStack.toString());
								currentTurn++;
							} else if (aStack.peek() < bStack.peek()) {
								bStack.push(aStack.peek());
								aStack.pop();

								System.out.println("Towers of Hanoi");
								System.out.println("========================================");
								System.out.println(aStack.toString() + "\n" + bStack.toString() + "\n" + cStack.toString());
								currentTurn++;
							} else {
								System.out.println("Invalid Move");
							}

							// System.out.println(aStack.peek() + " " + bStack.peek());
							// bStack.push(aStack.peek());
							// aStack.pop();

							// System.out.println("Towers of Hanoi");
							// System.out.println("========================================");
							// System.out.println(aStack.toString() + "\n" + bStack.toString() + "\n" + cStack.toString());
							// currentTurn++;
						} else {
							System.out.println("Invalid Move");
						}
					} else if (fromOriginalArray == 'a' && toTargetArray == 'c'){
						System.out.println("a to c");
					} else if (fromOriginalArray == 'b' && toTargetArray == 'a'){
						System.out.println("b to a");
						if(!bStack.isEmpty()){
							if (aStack.isEmpty()){
								aStack.push(bStack.peek());
								bStack.pop();

								System.out.println("Towers of Hanoi");
								System.out.println("========================================");
								System.out.println(aStack.toString() + "\n" + bStack.toString() + "\n" + cStack.toString());
								currentTurn++;
							} else if (bStack.peek() < aStack.peek()) {
								aStack.push(bStack.peek());
								bStack.pop();

								System.out.println("Towers of Hanoi");
								System.out.println("========================================");
								System.out.println(aStack.toString() + "\n" + bStack.toString() + "\n" + cStack.toString());
								currentTurn++;
							} else {
								System.out.println("Invalid Move");
							}
						}
					} else if (fromOriginalArray == 'b' && toTargetArray == 'c'){
						System.out.println("b to c");
					} else if (fromOriginalArray == 'c' && toTargetArray == 'a'){
						System.out.println("c to a");
					} else if (fromOriginalArray == 'c' && toTargetArray == 'b'){
						System.out.println("c to b");
					} else {
						System.out.println("Invalid move");
					}
					
				} 

				if (x.equals("check")){
					System.out.println("aStack::\t" + aStack.size() + " " + aStack.isEmpty() + "\n" + 
									   "bStack::\t" + bStack.size() + " " + bStack.isEmpty() );
				}


				currentTurn++;
			} else {
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
		// [] Gather from user how many plates int plateCount
		// [] create the 3 arrays ABC and pass them the count variable
		// [] Load A with all the plates
		// [] Print the first screen
		// [] Check to see if player won
	}

	private static int Sanitize(int inputChar){
		//To return lower case letter, 0-9, or -1
		int outputChar = inputChar;
		if (inputChar >= 65 && inputChar <= 67 || inputChar >= 97 && inputChar <= 99) {
			if(inputChar >= 65 && inputChar <= 67){
				//From Upper to Lower
				outputChar = inputChar + 32;
			} else if (inputChar >= 97 && inputChar <= 99) {
				//Returns lower or 0-9
				outputChar = inputChar;
			} else {
				//All other char will return -1
				outputChar = -1;
			}

			return outputChar;
		} else {
			return -1;
		}
	}

	private static boolean MoveValue(char fromOriginalArray, char toTargetArray){

		//System.out.println(aStack[0]);






		return true;
	}
}