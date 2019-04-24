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

        TestWithNode(nd, 5);

        Node nd2 = new Node().withPayload(3).withNext(nd);
        TestWithNode(nd2, 3);



        // Node nd = new Node().withPayload(5);
        // if(nd.getNext() == null) {
        //     System.out.println("No next available");
        // }




        // Node nd = new Node()
        //     .withPayload(5)
        //     .withNext(null);

        // Node nd2 = new Node()
        //     .withPayload(3)
        //     .withNext(nd);

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

    public static void TestWithNode(Node node, int payload){
        Node x = node;
        String outputPart1 = new String();
        String outputPart2 = new String();

        if(x.getNext() == null){
            outputPart1 = "No next available";
            // System.out.println("No next available");
        } else {
            // System.out.println("Next is available");
            outputPart1 = "Next is available";
        }

        if(x.getPayload() == payload){
            // System.out.println("payload available, and is equal to " + payload);
            outputPart2 = "payload available and is equal to " + payload;
        } else {
            // System.out.println("Payload doen't equal expected value");
            outputPart2 = "Payload doen't equal expected value";
        }

        System.out.println(outputPart1 + ", " + outputPart2);

    }
}