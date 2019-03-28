public class Geometry{
    public static void main(String[] args) {
        //TODO:
        //[*] write a test case for everything
        //[] rewite test methods to include try/catch
            //[] Circle
            //[] Regular Polygon
            //[] Square
            //[] Triangle
        //[*] add edge cases, min, max, med, negitive
        //[] Add error handling to RegularPolygon
        //[*] Add error handling to AbstractTriangle


        //RegularPolygon
        unitTestingRegularPolygon((float)-4, -5);
        unitTestingRegularPolygon((float)1, 1);
        System.out.println("Start");
        unitTestingRegularPolygon((float)6, 7);
        System.out.println("End");
        unitTestingRegularPolygon((float)900, 900);


    // //Square
    // unitTestingSquare((float)-1, -1);
    // unitTestingSquare((float)1, 1);
    // unitTestingSquare((float)20, 20);
    // unitTestingSquare((float)900, 900);


    //Circle
    // try {
    //   unitTestingCircle((float)-1);
    //   System.out.println("this one");
    // } catch (IllegalArgumentException exception) {
    //   exception.printStackTrace();
    // } finally {
      
    // }
    // unitTestingCircle((float)-1);
    // unitTestingCircle((float)1);
    // unitTestingCircle((float)20);
    // unitTestingCircle((float)900);


    // unitTestingTriangle((float)20, (float)10, (float)20, 80, 80, 30);
    // unitTestingTriangle((float)-20, (float)-10, (float)-20, -80, -80, -30);


    // try {
    //   AbstractTriangle triangle = new IsoscelesTriangle(180f, 180f, 35);
    //   System.out.println("This will never be reached");
    // } catch (IllegalArgumentException exception){
    //   exception.printStackTrace();
    // } finally {

    // }


    }

    private static void displayPerimteter(Shape anyShape){
        System.out.println("Perimeter of " + anyShape.getClass().getName() + " is " + anyShape.getPerimeter());
    }

    private static void unitTestingRegularPolygon(float lengthOfSide, int numberOfSides) {
        //RegularPolygon()
        try {
            RegularPolygon rgp = new RegularPolygon();
            rgp.setLengthOfSide((float)lengthOfSide);
            rgp.setNumberOfSides(numberOfSides);

            System.out.println("RegularPolygon()");
            System.out.println("Length of Side: " + rgp.getLengthOfSide() + " | " + "Number of Sides: " + rgp.getNumberOfSides() + "\n" +
                               "Area: " + rgp.getArea() + " | " + "Perimeter: " + rgp.getPerimeter() + " | " + "Apothem: " + rgp.getApothem() + "\n");

        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();            
        } 
        
        //RegularPolygon(lengthofSide, numberOfSides)
        try {
            RegularPolygon rgp2 = new RegularPolygon((float)lengthOfSide, numberOfSides);
            System.out.println("RegularPolygon((float)lengthOfside, numberOfSides)");      
            System.out.println("Length of Side: " + rgp2.getLengthOfSide() + " | " + "Number of Sides: " + rgp2.getNumberOfSides() + " | " + "\n" + 
                               "Area: " + rgp2.getArea() + " | " + "Perimeter: " + rgp2.getPerimeter() + " | " + "Apothem: " + rgp2.getApothem() + "\n");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
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

    private static void unitTestingTriangle(float s1, float s2, float s3, int a1, int a2, int a3){
      // RightTriangle rt = new RightTriangle(s1, s2, a1);
      // IsoscelesTriangle isot = new IsoscelesTriangle(s1, s2, a1);
      EquilateralTriangle eqlt = new EquilateralTriangle(s1);

      try {
        AbstractTriangle triangle = new IsoscelesTriangle(180f, 180f, 35);
        System.out.println("This will never be reached");
      } catch (IllegalArgumentException exception){
        exception.printStackTrace();
      } finally {
        System.out.print("\n");
      }

      System.out.println("Isosceles Triangle:");
      try {
        AbstractTriangle isot = new IsoscelesTriangle(s1, s2, a1);
        System.out.println("Area: " + isot.getArea() + "\tPerimeter: " + isot.getPerimeter());
      } catch (IllegalArgumentException exception){
        exception.printStackTrace();
      } finally {
        System.out.print("\n");
      }

      System.out.println("Right Triangle" + "\tInput: \ts1:" + s1 + " \ts2:" + s2 + " \ta1:" + a1);
      try {
        AbstractTriangle rt = new RightTriangle(s1, s2, a1);
        System.out.println("Area: " + rt.getArea() + "\tPerimeter: " + rt.getPerimeter());
      } catch (IllegalArgumentException exception){
        exception.printStackTrace();
      } finally {
        System.out.print("\n");
      }

      // System.out.println("Right Triangle: \tArea: " + rt.getArea() + "\tPerimeter: " + rt.getPerimeter());

      // IsoscelesTriangle isot = new IsoscelesTriangle(20, 10, 20);
      // System.out.println("IsoscelesTriangle: \tArea: " + isot.getArea() + "\tPerimeter: " + isot.getPerimeter());

      // EquilateralTriangle eqlt = new EquilateralTriangle(5);
      System.out.println("EquilateralTriangle: \tArea: " + eqlt.getArea () + "\tPerimeter: " + eqlt.getPerimeter());
      
    }






    // private static void displayPerimteter(Circle anyCircle){
    //  System.out.println("Perimeter of " + anyCircle.getClass().getName() + " is " + anyCircle.getPerimeter());   
    // }

    // private static void displayPerimteter(Square anySquare){
    //  System.out.println("Perimeter of " + anySquare.getClass().getName() + " is " + anySquare.getPerimeter());   
    // }

}