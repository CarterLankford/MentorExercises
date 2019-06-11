import java.util.Scanner;

public class Launcher{
    private String[] choices;
    //private static DynamicStack moveHistory = new DynamicStack();

    public static void main(String[] args){
        boolean recivedExitCode = false;
        Scanner sc = new Scanner(System.in);
        String x = "";
        int currentTurn = 0;

        //Game set up
        //TODO: Make set up class; currnetly am able to enter 0 or 1 plates, needs minimum of 3
        System.out.print("Plate Count: ");
        int plateCount = sc.nextInt();
        sc.nextLine();

        Stack[] stacks = new Stack[3];
        stacks[0] = new ArrayStack(plateCount);
        stacks[1] = new ArrayStack(plateCount);
        stacks[2] = new ArrayStack(plateCount);

        DynamicStack moveHistory = new DynamicStack();


        for (int i = 0; i < plateCount; i++){
            stacks[0].push(plateCount - i);
        }

        System.out.println("Towers of Hanoi");
        System.out.println("========================================");
        printBoard(stacks);
        

        while(!x.equalsIgnoreCase("exit")){ // equalsIgnoreCase            
            //while looping the game magic happens here.
            //at the beginning of the loop check to see if player won. 
                
            if((stacks[1].isFull()) || (stacks[2].isFull())){
                System.out.println("Game over you won in " + currentTurn + " moves.");
                break;
            }

            System.out.print("> ");
            System.out.flush();
            x = sc.nextLine(); // Looks for next user entry

            char[] merp = x.toCharArray();
            int fromOriginalArray;
            int toTargetArray;
            int valueToMove = 0;

            try {
                if (x.equalsIgnoreCase("undo")){
                    Integer moveFrom = moveHistory.pop();
                    Integer moveTo = moveHistory.pop();
                    if (moveFrom != null && moveTo != null){
                        System.out.println(moveMe(stacks[moveFrom], stacks[moveTo]));
                        currentTurn++;
                    } 
                } else if (merp.length == 3 && (int)merp[1] ==32) {
                    fromOriginalArray = Sanitize(merp[0]);
                    toTargetArray = Sanitize(merp[2]);
                    System.out.println(moveMe(stacks[fromOriginalArray], stacks[toTargetArray]));

                    moveHistory.push(fromOriginalArray);
                    moveHistory.push(toTargetArray);

                    currentTurn++;
                } else if (x.equals("check")){
                    System.out.println("aStack::\t" + stacks[0].size() + " " + stacks[0].isEmpty() + "\n" +
                                       "bStack::\t" + stacks[1].size() + " " + stacks[1].isEmpty() + "\n" + 
                                       "cStack::\t" + stacks[2].size() + " " + stacks[2].isEmpty() );
                } else {
                    // throw new IllegalArgumentException("Must enter two values seperated by a space.");
                    System.err.println("Must enter two values separated by a space.");
                }
            } catch (IllegalArgumentException exception) {
                System.err.println(exception.getMessage());
            } finally {
                System.out.println("\n\n");
                printBoard(stacks);                
            }
        }
    }

    private static int Sanitize(int inputChar){
        //to return 0-3 
        if (inputChar >= 65 && inputChar <= 67 || inputChar >= 97 && inputChar <= 99) {
            if(inputChar >= 65 && inputChar <= 67){
                //Upercase to 0-3
                return inputChar - 65;
            } else if (inputChar >= 97 && inputChar <= 99) {
                //lower case to 0-3
                return inputChar - 97;
            }
        }

        throw new IllegalArgumentException("Incorrect value entered");
    }

    private static void printBoard(Stack[] stacks){
        System.out.println("A:" + stacks[0].toString() + "\n" + "B:" + stacks[1].toString() + "\n" + "C:" + stacks[2].toString());

    }

    private static boolean moveMe(Stack fromStack, Stack toStack){
        boolean result = false;
        if(!fromStack.isEmpty() && (toStack.isEmpty() || fromStack.peek() < toStack.peek())){
            toStack.push(fromStack.pop());
            result = true;
        }
        return result;
    }
}