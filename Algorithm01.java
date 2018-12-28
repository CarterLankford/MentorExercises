/**
 * The HowManyOnes class was created to go with Algorithm01_Rawtext
 * to make the code concepts into an actual class.  
 */
class HowManyOnes {
    public static void main(String[] args) {
        //Manually creating the array
        int[] myArray;
        myArray = new int[17];
        myArray[0] = 0;
        myArray[1] = 0;
        myArray[2] = 1;
        myArray[3] = 1;
        myArray[4] = 0;
        myArray[5] = 0;
        myArray[6] = 0;
        myArray[7] = 1;
        myArray[8] = 0;
        myArray[9] = 0;
        myArray[10] = 1;
        myArray[11] = 1;
        myArray[12] = 1;
        myArray[13] = 0;
        myArray[14] = 1;
        myArray[15] = 1;
        myArray[16] = 0;
 

        //My idea of how to do this, used notepad and cmd to write/test
        //Copy and paste into git. 
        int highestCount = 0;
        int currentCount = 0;

        for (int x : myArray){ 
            if (x == 1) {
                currentCount++;
            } else if (x == 0) {
                if (currentCount > 0) {
                    if (currentCount > highestCount) {
                        highestCount = currentCount;
                    }
                    currentCount = 0; 
                }
            }           
        }
        System.out.println("output = " + highestCount);
    }
}

// [0,0,1,1,0,0,0,1,0,0,1,1,1,1,1,1,1] can't count a 0 if it's not there
