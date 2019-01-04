/**
 * The exercise: Design and write a Square class to represent geomtrical square
 * For your design consider this:
 *     - What attributes do you need to represent squares?
 *     - We would like to have methods to get the area and perimeter of the square
 *     - What other actions/methods do you think that can be added to the square?
 */



public class Square {
    private double side;

    public static void main(String[] args) {
        for(String arg : args){
            System.out.println(arg);
        }
        Square sq = new Square(); //Create the object

        // float a = 5.1;
        // double b = 5.1;

        // short c = 2;
        // int d = 2;

        sq.setSide(5.1); //Set the value of the object

	    System.out.println(sq.getArea()); //Show result of a function
    }

    public double getArea() {
        return side * side; 
    }

    public double getPerimeter() {
        return side * 4;
    }
    
    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side; 
    }

    private static boolean isValidValue(double x) {
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
