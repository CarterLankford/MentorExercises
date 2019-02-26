public class Geometry{
	public static void main(String[] args) {
  //       Circle cr = new Circle(); //creating object
  //       cr.setRadius((float)25); //setting object variable

  //       // System.out.println(cr.getArea()); //calling for return of object's area
        
  //       Square sq = new Square();
  //       sq.setSide((float)20);

  //       displayPerimteter(cr);
  //       displayPerimteter(sq);

  //       System.out.println(cr instanceof Object);
        
  //       System.out.println(sq instanceof Object);
  //       System.out.println(sq instanceof Shape);
  //       System.out.println(sq instanceof Square);
		
		// System.out.println("Hello" instanceof Object);
  //   	System.out.println("Hello" instanceof String);

  //   	System.out.println(new String("Hello") instanceof String);

  //   	String a = "Hello";
  //   	a = "Hello" + " World";


  //       RegularPolygon rp = new RegularPolygon();
  //       rp.setNumberOfSides((float)4);
  //       rp.setLengthOfSide((float)10);
  //       System.out.println(rp.getApothem());

    //TODO
    //write a test case for everything
    //add edge cases, min, max, med, negitive


    //RegularPolygon
    System.out.println("Regular Polygon Default constructor");
    RegularPolygon rgp = new RegularPolygon();
    rgp.setLengthOfSide((float)6);
    rgp.setNumberOfSides(7);
    System.out.println("Length of Side: " + rgp.getLengthOfSide() + "\n" +
                       "Number of Sides: " + rgp.getNumberOfSides() + "\n" +
                       "Area: " + rgp.getArea() + "\n" +
                       "Perimeter: " + rgp.getPerimeter() + "\n" +
                       "Apothem: " + rgp.getApothem() + "\n" + "\n");

    System.out.println("Regular Polygon: input num of sides & length of sides");
    RegularPolygon rgp2 = new RegularPolygon((float)6, 7);
    System.out.println("Length of Side: " + rgp2.getLengthOfSide() + "\n" +
                       "Number of Sides: " + rgp2.getNumberOfSides() + "\n" +
                       "Area: " + rgp2.getArea() + "\n" +
                       "Perimeter: " + rgp2.getPerimeter() + "\n" +
                       "Apothem: " + rgp2.getApothem() + "\n" + "\n");

    //Square
    System.out.println("Square Default constructor");
    Square sq = new Square();
    sq.setLengthOfSide((float)10);
    System.out.println("Length of side: " + sq.getLengthOfSide() + "\n" +
                       "Number of Sides: " + sq.getNumberOfSides() + "\n" +
                       "Area: " + sq.getArea() + "\n" +
                       "Perimeter: " + sq.getPerimeter() + "\n" + "\n");
    
    System.out.println("Square: input of length of sides");
    Square sqa = new Square((float)10);
    System.out.println("Length of side: " + sqa.getLengthOfSide() + "\n" +
                       "Number of Sides: " + sqa.getNumberOfSides() + "\n" +
                       "Area: " + sqa.getArea() + "\n" +
                       "Perimeter: " + sqa.getPerimeter() + "\n" + "\n");
    sqa.setNumberOfSides(7);
    System.out.println("Square: input of length of sides after calling setNumberOfSides()");
    System.out.println("Length of side: " + sqa.getLengthOfSide() + "\n" +
                       "Number of Sides: " + sqa.getNumberOfSides() + "\n" +
                       "Area: " + sqa.getArea() + "\n" +
                       "Perimeter: " + sqa.getPerimeter() + "\n" + "\n");


    //Circle
    System.out.println("Circle Default constructor");
    Circle cir = new Circle();
    cir.setRadius((float)5);
    System.out.println("Radius: " + cir.getRadius() + "\n" +
                       "Diameter: " + cir.getDiameter() + "\n" +
                       "PI: " + cir.getPI() + "\n" +
                       "Area: " + cir.getArea() + "\n" +
                       "Perimeter: " + cir.getPerimeter() + "\n" +
                       "Number of Instances: " + cir.getNumberOfInstances() + "\n" + "\n");

    System.out.println("Circle: input radius");
    Circle cir2 = new Circle((float)5);
    System.out.println("Radius: " + cir2.getRadius() + "\n" +
                       "Diameter: " + cir2.getDiameter() + "\n" +
                       "PI: " + cir2.getPI() + "\n" +
                       "Area: " + cir2.getArea() + "\n" +
                       "Perimeter: " + cir2.getPerimeter() + "\n" + "\n");

    // int value = 15;
    // assert value > 20;

    // RegularPolygon square = new RegularPolygon();
    // square.setNumberOfSides(4);
    // square.setLengthOfSide((float) 4);
        
    // Square sq = new Square();
    // sq.setLengthOfSide((float) 4);

    // System.out.println("RegularPolygon: " + square.getPerimeter() + " " + square.getArea());
    // System.out.println("Square: " + sq.getPerimeter() + " " + sq.getArea());

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