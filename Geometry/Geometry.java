public class Geometry{
	public static void main(String[] args) {
        Circle cr = new Circle(); //creating object
        cr.setRadius((float)25); //setting object variable

        // System.out.println(cr.getArea()); //calling for return of object's area
        
        Square sq = new Square();
        sq.setSide((float)20);

        displayPerimteter(cr);
        displayPerimteter(sq);

        System.out.println(cr instanceof Object);
        
        System.out.println(sq instanceof Object);
        System.out.println(sq instanceof Shape);
        System.out.println(sq instanceof Square);
		
		System.out.println("Hello" instanceof Object);
    	System.out.println("Hello" instanceof String);

    	System.out.println(new String("Hello") instanceof String);

    	String a = "Hello";
    	a = "Hello" + " World";


        RegularPolygon rp = new RegularPolygon();
        rp.setNumberOfSides((float)4);
        rp.setLengthOfSide((float)10);
        System.out.println(rp.getApothem());

        RegularPolygon square = new RegularPolygon();
        square.setNumberOfSides((float)4);
        

    }

    private static void displayPerimteter(Shape anyShape){
    	System.out.println("Perimeter of " + anyShape.getClass().getName() + " is " + anyShape.getPerimeter());
    }

    // private static void displayPerimteter(Circle anyCircle){
    // 	System.out.println("Perimeter of " + anyCircle.getClass().getName() + " is " + anyCircle.getPerimeter());	
    // }

    // private static void displayPerimteter(Square anySquare){
    // 	System.out.println("Perimeter of " + anySquare.getClass().getName() + " is " + anySquare.getPerimeter());	
    // }

}