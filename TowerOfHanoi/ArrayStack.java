public class ArrayStack implements Stack{
    
    private Integer[] anArray;
    private int arrayCount = 0;
    private int stackElementCount = 0;


    public ArrayStack() { 
        anArray = new Integer[5];
        this.arrayCount = 5;
    }

    public ArrayStack(int arrayCount) {
        this.arrayCount = arrayCount;
        anArray = new Integer[arrayCount];
    }


    @Override //work here
    public boolean push(int inputValue){
        if(isFull()){
            System.out.println("Already Full");
            return false;
        }

        int q = stackElementCount;
        for (int i=0; i < stackElementCount; i++) {
            int y = q -1;
            anArray[q] = anArray[y];
            q--;
        }
        anArray[0] = inputValue;
        stackElementCount++;
        return true; 
    }

    @Override
    public boolean isFull(){
        return stackElementCount == arrayCount; 
    }

    @Override
    public boolean isEmpty(){
        return stackElementCount == 0;
    }

    @Override //work here
    public Integer pop(){
        if(isEmpty()){
            System.out.println("Already empty");
            return null;
        }

        int popVar = anArray[0];
        int q = stackElementCount;
        for (int i = 1; i < stackElementCount; i++){
            anArray[i - 1] = anArray[i];
            anArray[i] = null;
        }

        stackElementCount--;
        return popVar; 
    }

    @Override
    public Integer peek(){
        return anArray[0]; // want the top value which will always be index 0, need to add logic to check if empty or not
    }

    @Override
    public int size(){
        return stackElementCount;
    }

    @Override
    public String toString(){
        String result = "[";
        for (int i = 0; i < stackElementCount; i++){
            // result = result + anArray[i] + " "; 
            if (i > 0) {
                result = result + " " + anArray[i];
            } else {
                result = result + anArray[i];
            }
            
        }
        result += "]";
        return result;
    }
}