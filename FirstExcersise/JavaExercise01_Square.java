/**
 * Square class created to represent gemoetrical squares and supporting functions
 * To show the world how to be Square, but to do it with class. /s 
 */

class Square {
    public static void main(String[] args) {

        double myArea = GetArea(2);
        double myPerimeter = GetPerimeter(5);

        if (myArea == -1) {
            System.out.println("Invalid Value");
        } else {
            System.out.println("Area: " + myArea);
        }


        if (myPerimeter == -1) {
            System.out.println("Invalid Value");
        } else {
            System.out.println("Perimeter: " + myPerimeter);
        }

    }

    private static double GetArea(double x) {
        double result = -1;

        if (IsValidValue(x)) {
            result = x * x;
        } 

        return result;
    }

    private static double GetPerimeter(double x) {
        double result = -1;

        if(IsValidValue(x)) {
            result = x * 4;
        }  
    
        return result;
    }

    private static boolean IsValidValue(double x) {
        boolean isValidValue = false;

        if (x >= 0){
            isValidValue = true;
        }

        return isValidValue;
    }

}

// change to "public double getArea()", create object and call, read slides. 


/**
 * Square mySquare = new Square(4);
 * 
 * System.out.println(mySquare.getArea());
 * 
 * //later
 * try{
 * 	mySquare = new Square(0);
 * }catch(IllegalArgumentException e){
 * ...
 * }
 */
