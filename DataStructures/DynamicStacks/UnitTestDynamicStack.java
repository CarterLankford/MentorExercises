public class UnitTestDynamicStack{
    public static void main(String[] args){
        DynamicStack ds = new DynamicStack();
        DynamicStack dswm = new DynamicStack(5);



        

        
        System.out.println("Empty-" + dswm.isEmpty() + " | Current Size-" + dswm.size() + " | Value Added-" + dswm.push(1) + " | Peek-" + dswm.peek() + " | Full-" + dswm.isFull() + " | Node Count-" + dswm.size());
        System.out.println("Empty-" + dswm.isEmpty() + " | Current Size-" + dswm.size() + " | Value Added-" + dswm.push(2) + " | Peek-" + dswm.peek() + " | Full-" + dswm.isFull() + " | Node Count-" + dswm.size());
        System.out.println("Empty-" + dswm.isEmpty() + " | Current Size-" + dswm.size() + " | Value Added-" + dswm.push(3) + " | Peek-" + dswm.peek() + " | Full-" + dswm.isFull() + " | Node Count-" + dswm.size());
        System.out.println("Empty-" + dswm.isEmpty() + " | Current Size-" + dswm.size() + " | Value Added-" + dswm.push(4) + " | Peek-" + dswm.peek() + " | Full-" + dswm.isFull() + " | Node Count-" + dswm.size());
        System.out.println("Empty-" + dswm.isEmpty() + " | Current Size-" + dswm.size() + " | Value Added-" + dswm.push(5) + " | Peek-" + dswm.peek() + " | Full-" + dswm.isFull() + " | Node Count-" + dswm.size());
        System.out.println("Empty-" + dswm.isEmpty() + " | Current Size-" + dswm.size() + " | Value Added-" + dswm.push(6) + " | Peek-" + dswm.peek() + " | Full-" + dswm.isFull() + " | Node Count-" + dswm.size());
        System.out.println("Empty-" + dswm.isEmpty() + " | Current Size-" + dswm.size() + " | Value Added-" + dswm.push(7) + " | Peek-" + dswm.peek() + " | Full-" + dswm.isFull() + " | Node Count-" + dswm.size());
        //pop a few
        System.out.println("Empty-" + dswm.isEmpty() + " | Current Size-" + dswm.size() + " | Value Removed-" + dswm.pop() + " | Peek-" + dswm.peek() + " | Full-" + dswm.isFull() + " | Node Count-" + dswm.size());
        System.out.println("Empty-" + dswm.isEmpty() + " | Current Size-" + dswm.size() + " | Value Removed-" + dswm.pop() + " | Peek-" + dswm.peek() + " | Full-" + dswm.isFull() + " | Node Count-" + dswm.size());
        System.out.println("Empty-" + dswm.isEmpty() + " | Current Size-" + dswm.size() + " | Value Removed-" + dswm.pop() + " | Peek-" + dswm.peek() + " | Full-" + dswm.isFull() + " | Node Count-" + dswm.size());
        System.out.println("Empty-" + dswm.isEmpty() + " | Current Size-" + dswm.size() + " | Value Removed-" + dswm.pop() + " | Peek-" + dswm.peek() + " | Full-" + dswm.isFull() + " | Node Count-" + dswm.size());


        //Generating test data
        Integer[] testArray = new Integer[10];
        for (int i=0, j=4; i < testArray.length; i++) {
            System.out.println(i + " " + j);
            testArray[i] = j;
            j+=4;
        }

        //Testing paramaterless constructor 
        //In
        for (int i=0; i < 10; i++){
            System.out.println("Empty-" + ds.isEmpty() + " | Current Size-" + ds.size() + " | Value Added-" + ds.push(testArray[i]) + " | Peek-" + ds.peek() + " | Full-" + ds.isFull() + " | Node Count-" + ds.size());
        }
        //out
        for (int i=0; i <= 3; i++){
            System.out.println("Empty-" + ds.isEmpty() + " | Current Size-" + ds.size() + " | Value Removed-" + ds.pop() + " | Peek-" + ds.peek() + " | Full-" + ds.isFull() + " | Node Count-" + ds.size());
        }


        System.out.println("\n\n\n");






        // System.out.println(ds.isEmpty());
        // System.out.println("size: "+ds.size());
        // ds.push(1);
        // ds.push(2);
        // ds.push(3);
        // ds.push(4);
        // ds.push(5);
        // ds.push(6);
        // System.out.println("Peek at payload shows: " + ds.peek());
        // System.out.println("size: " + ds.size());
        // System.out.println(ds.pop());
        // System.out.println(ds.pop());
        // System.out.println(ds.pop());
        // ds.push(7);
        // ds.push(8);
        // ds.push(9);
        // System.out.println(ds.pop());
        // System.out.println(ds.pop());
        // System.out.println(ds.pop());
        // System.out.println(ds.pop());
        // System.out.println(ds.pop());
        // System.out.println(ds.pop());
        // System.out.println("size: "+ds.size());
        // System.out.println(ds.pop());
    }
}