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
        myArray[13] = 1; //was 0
        myArray[14] = 1;
        myArray[15] = 1;
        myArray[16] = 1; //was 0

        int highestCount = 0;
        int currentCount = 0;


        for (int x : myArray){ 
            if (x == 0) {
                currentCount = 0;
            } else {
                currentCount++;
            }

            if (highestCount <= currentCount && currentCount > 0){
                    highestCount = currentCount;
            }

            //System.out.println("c:" + currentCount + " h:" + highestCount);           
        }
        System.out.println("output = " + highestCount);
    }
}


