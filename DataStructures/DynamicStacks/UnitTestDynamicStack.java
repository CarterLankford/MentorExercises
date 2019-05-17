public class UnitTestDynamicStack{
    public static void main(String[] args){
        DynamicStack ds = new DynamicStack();
        DynamicStack dswm = new DynamicStack(5);

        //Testing paramaterless constructor 
        int numberIn = 10;
        int numberOut = 3;
        TestDynamicStack(numberIn, numberOut, ds);
        System.out.println("\n\n\n");


        //Testing constructor with size limit
        numberIn = 8;
        numberOut = 3;
        TestDynamicStack(numberIn, numberOut, dswm);
        System.out.println("\n\n\n");


        Node nd = new Node()
            .withPayload(5);

        TestWithNode(nd, 5, null, null); //True

        Node nd2 = new Node()
            .withPayload(3)
            .withNext(nd);

        TestWithNode(nd2, 3, nd, 5); //True
        
        Node nd3 = new Node()
            .withPayload(9)
            .withNext(nd2);

        TestWithNode(nd3, 9, nd2, 20); //False       
    }

    public static void TestDynamicStack(int numberIn, int numberOut, DynamicStack nameOfStack){
        DynamicStack x = nameOfStack;

        Integer[] testArray = new Integer[(numberIn+1)];
        for (int i=0, j=4; i < testArray.length; i++) {
            testArray[i] = j;
            j+=4;
        }

        //In
        for (int i=0; i < numberIn; i++){
            System.out.println("Empty-" + x.isEmpty() + " | Current Size-" + x.size() + " | Value Added-" + x.push(testArray[i]) + " | Peek-" + x.peek() + " | Full-" + x.isFull() + " | Node Count-" + x.size());
        }
        //Out
        for (int i=0; i <= numberOut; i++){
            System.out.println("Empty-" + x.isEmpty() + " | Current Size-" + x.size() + " | Value Removed-" + x.pop() + " | Peek-" + x.peek() + " | Full-" + x.isFull() + " | Node Count-" + x.size());
        }
    }

    public static void TestWithNode(Node currentNode, int currentExpectedPayload, Node expectedNext, Integer expectedNextPayload){
        //Validate current node creation, with expected Payload
        if(currentNode.getPayload() == currentExpectedPayload) {
            System.out.println("CurrentNode Created Successfully: True");
        } else {
            System.out.println("CurrentNode Created Successfully: False");
        }

        //Printing what we have vs what we expect
        System.out.print("Input: CurrentNode = " + currentNode + ", CurrentPayload = " + currentExpectedPayload + " || ExpectedNextNode = " + expectedNext + ", ExpectedNextNodePayload = " + expectedNextPayload + " || ");

        Node nextNode = currentNode.getNext();
        //If Node is null it will throw an error, so let's check first
        if (nextNode != null) {
            Integer nextPayload = nextNode.getPayload();

            //Displays the output to console
            System.out.print(" Output: NextNode = " + nextNode + ", nextPayload = " + nextPayload + "\n");

            //Checks to see if both node and payload matches the expected, it either matches fully or not at all.
            if (nextNode.equals(expectedNext) && nextPayload == expectedNextPayload){
                System.out.println("NextNode Matches expected NextNode: True");                
            } else {
                System.out.println("NextNode Matches expected NextNode: False");
            }
        } else {
            System.out.print(" Output: NextNode = null, nextPayload = null\n");
            //If it's expected to be null/null
            //Checks to see if both node and payload matches the expected, it either matches fully or not at all.
            if (expectedNext == null && expectedNextPayload == null) {
                System.out.println("NextNode Matches expected NextNode: True");
            } else {
                System.out.println("NextNode Matches expected NextNode: False");
            }
        }

        //To keep the output clean        
        System.out.println("");
    }
}