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


        Node nd = new Node().withPayload(5).withNext();
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
}