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
    unitTestingRegularPolygon((float)-1, -1);
    unitTestingRegularPolygon((float)1, 1);
    unitTestingRegularPolygon((float)6, 7);
    unitTestingRegularPolygon((float)900, 900);


    //Square
    unitTestingSquare((float)-1, -1);
    unitTestingSquare((float)1, 1);
    unitTestingSquare((float)20, 20);
    unitTestingSquare((float)900, 900);


    //Circle
    unitTestingCircle((float)-1);
    unitTestingCircle((float)1);
    unitTestingCircle((float)20);
    unitTestingCircle((float)900);


    }

    private static void displayPerimteter(Shape anyShape){
    	System.out.println("Perimeter of " + anyShape.getClass().getName() + " is " + anyShape.getPerimeter());
    }

    private static void unitTestingRegularPolygon(float lengthOfSide, int numberOfSides) {
      RegularPolygon rgp = new RegularPolygon();
      RegularPolygon rgp2 = new RegularPolygon((float)lengthOfSide, numberOfSides);
      rgp.setLengthOfSide((float)lengthOfSide);
      rgp.setNumberOfSides(numberOfSides);

      System.out.println("RegularPolygon()");
      System.out.println("Length of Side: " + rgp.getLengthOfSide() + " | " + "Number of Sides: " + rgp.getNumberOfSides() + "\n" +
                         "Area: " + rgp.getArea() + " | " + "Perimeter: " + rgp.getPerimeter() + " | " + "Apothem: " + rgp.getApothem() + "\n");

      System.out.println("RegularPolygon((float)lengthOfside, numberOfSides)");      
      System.out.println("Length of Side: " + rgp2.getLengthOfSide() + " | " + "Number of Sides: " + rgp2.getNumberOfSides() + " | " + "\n" + 
                         "Area: " + rgp2.getArea() + " | " + "Perimeter: " + rgp2.getPerimeter() + " | " + "Apothem: " + rgp2.getApothem() + "\n");
    }

    private static void unitTestingSquare(float lengthOfSide, int numberOfSides){
      System.out.println("Square Default constructor");
      Square sq = new Square();
      sq.setLengthOfSide((float)lengthOfSide);
      Square sqa = new Square((float)lengthOfSide);      
      

      System.out.println("Square()");
      System.out.println("Length of side: " + sq.getLengthOfSide() + " | " + "Number of Sides: " + sq.getNumberOfSides() + "\n" +
                         "Area: " + sq.getArea() + " | " + "Perimeter: " + sq.getPerimeter() + "\n");
    
      System.out.println("Square((float)lengthOfSide)");    
      System.out.println("Length of side: " + sqa.getLengthOfSide() + " | " + "Number of Sides: " + sqa.getNumberOfSides() + "\n" +
                         "Area: " + sqa.getArea() + "\n" + "Perimeter: " + sqa.getPerimeter() + "\n");
      
      sqa.setNumberOfSides(numberOfSides);
      System.out.println("Square: input of length of sides after calling setNumberOfSides(" + numberOfSides + ")");
      System.out.println("Length of side: " + sqa.getLengthOfSide() + " | " + "Number of Sides: " + sqa.getNumberOfSides() + "\n" +
                         "Area: " + sqa.getArea() + " | " + "Perimeter: " + sqa.getPerimeter() + "\n");
    }

    private static void unitTestingCircle(float radius){
      Circle cir = new Circle();
      cir.setRadius((float)radius);
      Circle cir2 = new Circle((float)radius);

      System.out.println("Circle()");
      System.out.println("Radius: " + cir.getRadius() + " | " + "Diameter: " + cir.getDiameter() + "\n" +
                         "PI: " + cir.getPI() + " | " + "Area: " + cir.getArea() + " | " + "Perimeter: " + cir.getPerimeter() + "\n" +
                         "Number of Instances: " + cir.getNumberOfInstances() + "\n");

      System.out.println("Circle((float) radius)");
      System.out.println("Radius: " + cir2.getRadius() + " | " + "Diameter: " + cir2.getDiameter() + "\n" +
                         "PI: " + cir2.getPI() + " | " + "Area: " + cir2.getArea() + "\n" +
                         "Perimeter: " + cir2.getPerimeter() + "\n");
    }




    // private static void displayPerimteter(Circle anyCircle){
    // 	System.out.println("Perimeter of " + anyCircle.getClass().getName() + " is " + anyCircle.getPerimeter());	
    // }

    // private static void displayPerimteter(Square anySquare){
    // 	System.out.println("Perimeter of " + anySquare.getClass().getName() + " is " + anySquare.getPerimeter());	
    // }

}