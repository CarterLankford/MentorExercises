public class Geometry{
    public static void main(String[] args) {
        //TODO:
        //[*] write a test case for everything
        //[*] rewite test methods to include try/catch
            //[*] Circle
            //[*] Regular Polygon
            //[*] Square
            //[*] Triangle
        //[*] add edge cases, min, max, med, negitive
        //[*] Add error handling to RegularPolygon
        //[*] Add error handling to AbstractTriangle

        

        
        //RegularPolygon
        // unitTestingRegularPolygon((float)-4, -5, 0f, 0f, 0f);
        // unitTestingRegularPolygon((float)1, 1, 0f, 0f, 0f);
        // unitTestingRegularPolygon((float)6, 7, 42f, 135.10394f, 6.433521f);
        // unitTestingRegularPolygon((float)900, 900, 2f, 2f, 2f);

        
        // Square
        unitTestingSquare((float)-1, -1, 0f, 0f);
        unitTestingSquare((float)1, 1, 4f, 1f);
        unitTestingSquare((float)20, 20, 0f, 0f);
        unitTestingSquare((float)900, 900, 0f, 0f);

        /*
        //Circle
        unitTestingCircle((float)-1);
        unitTestingCircle((float)1);
        unitTestingCircle((float)20);
        unitTestingCircle((float)900);
        // VYH unitTestingCircle((float) 900, resultOfArea, resultOfPerimeter)

        //Triangle
        unitTestingTriangle((float)20, (float)10, (float)20, 80, 80, 30);
        unitTestingTriangle((float)-20, (float)-10, (float)-20, -80, -80, -30); 
        */
    }

    private static void displayPerimteter(Shape anyShape){
        System.out.println("Perimeter of " + anyShape.getClass().getName() + " is " + anyShape.getPerimeter());
    }

    private static void merpUnitTest(float lengthOfSide, int numberOfSides, float expectedPerimeter, float expectedArea, float expectedApothem){
        try {
            boolean passTest = false;
            RegularPolygon rp = new RegularPolygon();
            rp.setLengthOfSide((float)lengthOfSide);
            rp.setNumberOfSides(numberOfSides);

            if (rp.getPerimeter() == expectedPerimeter && rp.getArea() == expectedArea && rp.getApothem() == expectedApothem){
                passTest = !passTest;
            } 

            System.out.println("\nmerpUnitTest(float lengthOfSide,int numberOfSides)\n" 
                                + "lengthOfSide: " + lengthOfSide + " numberOfSides: " + numberOfSides + "\n"
                                + "Expected Results:\n\tPerimeter: " + expectedPerimeter + "\tArea: " + expectedArea + "\tApothem: " + expectedApothem + "\n"
                                + "Actual Results:\n\tPerimeter: " + rp.getPerimeter() + "\tArea: " + rp.getArea() + "\tApothem: " + rp.getApothem() + "\n"
                                + "Pass Test = " + passTest + "\n");
        } catch (IllegalArgumentException exception){
            System.out.println("\nmerpUnitTest(float lengthOfSide, int numberOfSides)\nPass Test = false, execption thrown\n");
        }

        
    }

    private static void unitTestingRegularPolygon(float lengthOfSide, int numberOfSides, float expectedPerimeter, float expectedArea, float expectedApothem) {
        //RegularPolygon()
        try {
            boolean passTest = false;
            RegularPolygon rp = new RegularPolygon();
            System.out.println("RegularPolygon()\nInput Values(lengthOfSide: " + lengthOfSide + ", numberOfSides:" + numberOfSides + ")");
            rp.setLengthOfSide((float)lengthOfSide);
            rp.setNumberOfSides(numberOfSides);

            if (rp.getPerimeter() == expectedPerimeter && rp.getArea() == expectedArea && rp.getApothem() == expectedApothem){
                passTest = true;
            } 

            System.out.println("Expected Results:\n\tPerimeter: " + expectedPerimeter + "\tArea: " + expectedArea + "\tApothem: " + expectedApothem + "\n"
                                + "Actual Results:\n\tPerimeter: " + rp.getPerimeter() + "\tArea: " + rp.getArea() + "\tApothem: " + rp.getApothem() + "\n"
                                + "Pass Test = " + passTest + "\n");
        } catch (IllegalArgumentException exception){
            System.out.println("Pass Test = false, execption thrown\n");
        }

        //RegularPolygon(lengthOfSide, numberOfSides)
        try {
            boolean passTest = false;            
            System.out.println("RegularPolygon(lengthOfSide, numberOfSides)\nInput Values(lengthOfSide: " + lengthOfSide + ", numberOfSides:" + numberOfSides + ")");
            RegularPolygon rp1 = new RegularPolygon(lengthOfSide, numberOfSides);

            if (rp1.getPerimeter() == expectedPerimeter && rp1.getArea() == expectedArea && rp1.getApothem() == expectedApothem){
                passTest = true;
            } 

            System.out.println("Expected Results:\n\tPerimeter: " + expectedPerimeter + "\tArea: " + expectedArea + "\tApothem: " + expectedApothem + "\n"
                                + "Actual Results:\n\tPerimeter: " + rp1.getPerimeter() + "\tArea: " + rp1.getArea() + "\tApothem: " + rp1.getApothem() + "\n"
                                + "Pass Test = " + passTest + "\n");
        } catch (IllegalArgumentException exception){
            System.out.println("Pass Test = false, execption thrown\n");
        }
    }

    private static void unitTestingSquare(float lengthOfSide, int numberOfSides, float expectedArea, float expectedPerimeter){
        //Square()
        try{
            boolean passTest = false;
            System.out.println("Square()\nInput Values(lengthOfSide: " + lengthOfSide + ", numberOfSides:" + numberOfSides + ")");
            Square sq = new Square();
            sq.setLengthOfSide(lengthOfSide);            
            if (sq.getPerimeter() == expectedPerimeter && sq.getArea() == expectedArea ){
                passTest = true;            
            }

            System.out.println("Expected Results:\n\tPerimeter: " + expectedPerimeter + "\tArea: " + expectedArea + "\n"
                                + "Actual Results:\n\tPerimeter: " + sq.getPerimeter() + "\tArea: " + sq.getArea() + "\n"
                                + "Pass Test = " + passTest + "\n");
        } catch (IllegalArgumentException exception) {
            System.out.println("Pass Test = false, execption thrown\n");
        }

        //Square((float)lengthOfSide)
        try{
            //TODO: add this
        } catch (IllegalArgumentException exception){
            System.out.println("Pass Test = false, execption thrown\n");
        }


        // System.out.println("Square()");
        // try {
        //     Square sq = new Square();
        //     sq.setLengthOfSide((float)lengthOfSide);
        //     System.out.println("Length of side: " + sq.getLengthOfSide() + " | " + "Number of Sides: " + sq.getNumberOfSides() + "\n" +
        //                        "Area: " + sq.getArea() + " | " + "Perimeter: " + sq.getPerimeter() + "\n");

        // } catch (IllegalArgumentException exception) {
        //     exception.printStackTrace();
        // }

        // System.out.println("Square((float)lengthOfSide)");
        // try {
        //     Square sqa = new Square((float)lengthOfSide);
        //     System.out.println("Length of side: " + sqa.getLengthOfSide() + " | " + "Number of Sides: " + sqa.getNumberOfSides() + "\n" +
        //                        "Area: " + sqa.getArea() + "\n" + "Perimeter: " + sqa.getPerimeter() + "\n");

        //     sqa.setNumberOfSides(numberOfSides);
        //     System.out.println("Square: input of length of sides after calling setNumberOfSides(" + numberOfSides + ")");
        //     System.out.println("Length of side: " + sqa.getLengthOfSide() + " | " + "Number of Sides: " + sqa.getNumberOfSides() + "\n" +
        //                        "Area: " + sqa.getArea() + " | " + "Perimeter: " + sqa.getPerimeter() + "\n");

        // } catch (IllegalArgumentException exception) {
        //     exception.printStackTrace();
        // }

    }

    private static void unitTestingCircle(float radius){
        //Circle()
        System.out.println("Circle()");
        try {
            Circle cir = new Circle();
            cir.setRadius((float)radius);
            // float per = cir.getPerimeter();
            // if(per !== expectedPerimeter){
            //   display error
            // }
            System.out.println("Radius: " + cir.getRadius() + " | " + "Diameter: " + cir.getDiameter() + "\n" +
                               "PI: " + cir.getPI() + " | " + "Area: " + cir.getArea() + " | " + "Perimeter: " + cir.getPerimeter() + "\n" +
                               "Number of Instances: " + cir.getNumberOfInstances() + "\n");

        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }

        //Circle((float)radius)
        System.out.println("Circle((float) radius)");
        try {
            Circle cir2 = new Circle((float)radius);            
            System.out.println("Radius: " + cir2.getRadius() + " | " + "Diameter: " + cir2.getDiameter() + "\n" +
                               "PI: " + cir2.getPI() + " | " + "Area: " + cir2.getArea() + "\n" +
                               "Perimeter: " + cir2.getPerimeter() + "\n");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }      
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
      System.out.println("EquilateralTriangle: \tArea: " + eqlt.getArea () + "\tPerimeter: " + eqlt.getPerimeter());      
    }
}