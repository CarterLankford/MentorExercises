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

		while(!x.equals("exit")){ // equalsIgnoreCase
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

					// VYH: Add a function that receives fromStack toStack:

					/*
						boolean move(Stack fromStack, Stack toStack){
							boolean result = false;
							if(
							!fromStack.isEmpty() 
							&& (toStack.isEmpty() || fromStack.peek() < toStack.peek() )
							){
									toStack.push(fromStack.pop());
									result = true;
								}
							}
							return result;
						}

					Stack fromStack;
					Stack toStack;

					switch(fromOriginalArray){
						case 'a':
							fromStack = aStack;
							break;
						case 'b':
							fromStack = bStack;
							break;
						case 'c':
							fromStack = cStack;
							break;
						default:
							// TODO: add some error handling here
					}

					switch(toTargetArray){
						case 'a':
							toStack = aStack;
							break;
						case 'b':
							toStack = bStack;
							break;
						case 'c':
							toStack = cStack;
							break;
						default:
							// TODO: add some error handling here	
					}

					System.out.println(move(fromStack, toStack));
					*/

					switch (fromOriginalArray){
						case 'a':
							if(toTargetArray == 'b' && !aStack.isEmpty()){
								if (bStack.isEmpty() || aStack.peek() < bStack.peek()) {
									bStack.push(aStack.peek());
									aStack.pop();

									// bStack.push(aStack.pop()); ~ VYH	
								}								
							} else if(toTargetArray == 'c' && !aStack.isEmpty()){
								if (cStack.isEmpty() || aStack.peek() < cStack.peek()) {
									cStack.push(aStack.peek());
									aStack.pop();	
								}
							} else {
								System.out.println("False");
							}
							currentTurn++;
							break;
						case 'b':
							if(toTargetArray == 'c' && !bStack.isEmpty()){
								if (cStack.isEmpty() || bStack.peek() < cStack.peek()) {
									cStack.push(bStack.peek());
									bStack.pop();
								}
							} else if(toTargetArray == 'a' && !bStack.isEmpty()){
								if (aStack.isEmpty() || bStack.peek() < aStack.peek()) {
									aStack.push(bStack.peek());
									bStack.pop();
								}
							} else {
								System.out.println("False");
							}
							currentTurn++;
							break;
						case 'c':
							if(toTargetArray == 'a' && !cStack.isEmpty()){
								if (aStack.isEmpty() || cStack.peek() < aStack.peek()) {
									aStack.push(cStack.peek());
									cStack.pop();	
								}
							} else if(toTargetArray == 'b' && !cStack.isEmpty()){
								if (bStack.isEmpty() || cStack.peek() < bStack.peek()) {
									bStack.push(cStack.peek());
									cStack.pop();	
								}
							} else {
								System.out.println("False");
							}
							break;

						default:
							System.out.println("False");
							break;
					}
					
				} 

				if (x.equals("check")){
					System.out.println("aStack::\t" + aStack.size() + " " + aStack.isEmpty() + "\n" +
									   "bStack::\t" + bStack.size() + " " + bStack.isEmpty() + "\n" + 
									   "cStack::\t" + cStack.size() + " " + cStack.isEmpty() );
				}

				// System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println("Towers of Hanoi");
				System.out.println("========================================");
				System.out.println("A:" + aStack.toString() + "\n" + "B:" + bStack.toString() + "\n" + "C:" + cStack.toString());
				currentTurn++;

			} else {
				// VYH: All of this is game setup, should happen before the while
				for (int i = 0; i < plateCount; i++){
					aStack.push(plateCount - i);
				}

				// VYH: Write a function to print all towers: printTowers()
				System.out.println("Towers of Hanoi");
				System.out.println("========================================");
				System.out.println(aStack.toString() + "\n" + bStack.toString() + "\n" + cStack.toString());
				currentTurn++;
			}
		}

		//TODO: 
		// [] Gather from user how many plates int plateCount ~ VYH: done
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


		return true;
	}
}