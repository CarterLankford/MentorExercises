public class Geometry{
    public static void main(String[] args) {
        //TODO:
        //[*] Correct test cases for Circle
        //[] Correct test cases for Triangle

        
        //RegularPolygon
        unitTestingRegularPolygon((float)-4, -5, 0f, 0f, 0f);
        unitTestingRegularPolygon((float)1, 1, 0f, 0f, 0f);
        unitTestingRegularPolygon((float)6, 7, 42f, 135.10394f, 6.433521f);
        unitTestingRegularPolygon((float)90, 90, 8100f, 5218957f, 1288.6313f);

        
        // Square
        unitTestingSquare((float)-1, -1, 0f, 0f);
        unitTestingSquare((float)1, 1, 4f, 1f);
        unitTestingSquare((float)20, 20, 80f, 400f);
        unitTestingSquare((float)900, 900, 3600f, 810000f);

        
        //Circle
        unitTestingCircle((float)-1, 5f, 5f, 5f);
        unitTestingCircle((float)1, 6.28318f, 3.14159f, 2f);
        unitTestingCircle((float)20, 125.663605f, 1256.636f, 40f);
        unitTestingCircle((float)900, 5654.8623f, 2544688f, 1800f);


        //Triangle
        unitTestingTriangle((float)20, (float)10, (float)20, 80, 80, 30, 52.36068f, 100f);
        unitTestingTriangle((float)1, (float)1, (float)1, 1, 1, 1, 1f, 1f);
        unitTestingTriangle((float)-1, (float)-1, (float)-1, -1, -1, -1, 1f, 1f);

        
    }

    private static void displayPerimteter(Shape anyShape){
        System.out.println("Perimeter of " + anyShape.getClass().getName() + " is " + anyShape.getPerimeter());
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

    private static void unitTestingSquare(float lengthOfSide, int numberOfSides, float expectedPerimeter, float expectedArea){
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
            boolean passTest = false;
            System.out.println("Square((float)lengthOfSide)\nInput Values(lengthOfSide: " + lengthOfSide + ", numberOfSides:" + numberOfSides + ")");
            Square sqa = new Square((float)lengthOfSide);
            sqa.setNumberOfSides(numberOfSides);
            if (sqa.getPerimeter() == expectedPerimeter && sqa.getArea() == expectedArea){
                passTest = true;
            }

            System.out.println("Expected Results:\n\tPerimeter: " + expectedPerimeter + "\tArea: " + expectedArea + "\n"
                                + "Actual Results:\n\tPerimeter: " + sqa.getPerimeter() + "\tArea: " + sqa.getArea() + "\n"
                                + "Pass Test = " + passTest + "\n");
        } catch (IllegalArgumentException exception){
            System.out.println("Pass Test = false, execption thrown\n");
        }
    }

    private static void unitTestingCircle(float radius, float expectedPerimeter, float expectedArea, float expectedDiameter){
        //Circle()
        try{
            boolean passTest = false;
            System.out.println("Circle()\nInput Values(Circle.setRadius: " + radius + ")");
            Circle cir = new Circle();
            cir.setRadius((float)radius);
            if(cir.getPerimeter() == expectedPerimeter && cir.getArea() == expectedArea && cir.getDiameter() == expectedDiameter){
                passTest = true;
            }

            System.out.println("Expected Results:\n\tPerimeter: " + expectedPerimeter + "\tArea: " + expectedArea + "\tDiameter: " + expectedDiameter + "\n"
                                + "Actual Results:\n\tPerimeter: " + cir.getPerimeter() + "\tArea: " + cir.getArea() + "\tDiameter: " + cir.getDiameter() + "\n"
                                + "Pass Test = " + passTest + "\n");

        } catch (IllegalArgumentException exception){
            System.out.println("Pass Test = false, execption thrown\n");
        }

        //Circle((float)radius)
        try{
            boolean passTest = false;
            System.out.println("Circle((float)radius)\nInput Values(Radius: " + radius + ")");
            Circle cir2 = new Circle(radius);
            if(cir2.getPerimeter() == expectedPerimeter && cir2.getArea() == expectedArea && cir2.getDiameter() == expectedDiameter){
                passTest = true;
            }

            System.out.println("Expected Results:\n\tPerimeter: " + expectedPerimeter + "\tArea: " + expectedArea + "\tDiameter: " + expectedDiameter + "\n"
                                + "Actual Results:\n\tPerimeter: " + cir2.getPerimeter() + "\tArea: " + cir2.getArea() + "\tDiameter: " + cir2.getDiameter() + "\n"
                                + "Pass Test = " + passTest + "\n");


        } catch (IllegalArgumentException exception){
            System.out.println("Pass Test = false, execption thrown\n");
        }
    }

    //TODO: I see now each one of these should have their own test and not be lumped togheter. Need to rewrite. 
    private static void unitTestingTriangle(float s1, float s2, float s3, int a1, int a2, int a3, float expectedPerimeter, float expectedArea){
        //RightTriangle((float)s1, (float)s2, int a1)
        try {
            boolean passTest = false;
            System.out.println("RightTriangle((float)s1, (float)s2, int a1)\nInput Values(s1: " + s1 + ", s2: " + s2 + ", a1: " + a1 + ")");
            AbstractTriangle rt =  new RightTriangle((float)s1, (float)s2, (int)a1);
            if(rt.getPerimeter() == expectedPerimeter && rt.getArea() == expectedArea){
                passTest = true;
            }

            System.out.println("Expected Results:\n\tPerimeter: " + expectedPerimeter + "\tArea: " + expectedArea + "\n"
                                + "Actual Results:\n\tPerimeter: " + rt.getPerimeter() + "\tArea: " + rt.getArea() + "\n"
                                + "Pass Test = " + passTest + "\n");


        } catch (IllegalArgumentException exception){
            exception.printStackTrace();
        } finally{
            System.out.println(" ");
        }

        //IsoscelesTriangle((float)s1, (float)s2, int a1)
        try {
            boolean passTest = false;
            System.out.println("IsoscelesTriangle((float)s1, (float)s2, int a1)\nInput Values(s1: " + s1 + ", s2: " + s2 + ", a1: " + a1 + ")");
            AbstractTriangle ist =  new IsoscelesTriangle((float)s1, (float)s2, (int)a1);
            if(ist.getPerimeter() == expectedPerimeter && ist.getArea() == expectedArea){
                passTest = true;
            }

            System.out.println("Expected Results:\n\tPerimeter: " + expectedPerimeter + "\tArea: " + expectedArea + "\n"
                                + "Actual Results:\n\tPerimeter: " + ist.getPerimeter() + "\tArea: " + ist.getArea() + "\n"
                                + "Pass Test = " + passTest + "\n");


        } catch (IllegalArgumentException exception){
            exception.printStackTrace();
        } finally{
            System.out.println(" ");
        }

        // //EquilateralTriangle((float)s1)
        try {
            boolean passTest = false;
            System.out.println("EquilateralTriangle((float)s1)\nInput Values(s1: " + s1 + ")");
            AbstractTriangle elt =  new EquilateralTriangle((float)s1);
            if(elt.getPerimeter() == expectedPerimeter && elt.getArea() == expectedArea){
                passTest = true;
            }

            System.out.println("Expected Results:\n\tPerimeter: " + expectedPerimeter + "\tArea: " + expectedArea + "\n"
                                + "Actual Results:\n\tPerimeter: " + elt.getPerimeter() + "\tArea: " + elt.getArea() + "\n"
                                + "Pass Test = " + passTest + "\n");


        } catch (IllegalArgumentException exception){
            exception.printStackTrace();
        } finally{
            System.out.println(" ");
        }





      // // RightTriangle rt = new RightTriangle(s1, s2, a1);
      // // IsoscelesTriangle isot = new IsoscelesTriangle(s1, s2, a1);
      // EquilateralTriangle eqlt = new EquilateralTriangle(s1);

      // try {
      //   AbstractTriangle triangle = new IsoscelesTriangle(180f, 180f, 35);
      //   System.out.println("This will never be reached");
      // } catch (IllegalArgumentException exception){
      //   exception.printStackTrace();
      // } finally {
      //   System.out.print("\n");
      // }

      // System.out.println("Isosceles Triangle:");
      // try {
      //   AbstractTriangle isot = new IsoscelesTriangle(s1, s2, a1);
      //   System.out.println("Area: " + isot.getArea() + "\tPerimeter: " + isot.getPerimeter());
      // } catch (IllegalArgumentException exception){
      //   exception.printStackTrace();
      // } finally {
      //   System.out.print("\n");
      // }

      // System.out.println("Right Triangle" + "\tInput: \ts1:" + s1 + " \ts2:" + s2 + " \ta1:" + a1);
      // try {
      //   AbstractTriangle rt = new RightTriangle(s1, s2, a1);
      //   System.out.println("Area: " + rt.getArea() + "\tPerimeter: " + rt.getPerimeter());
      // } catch (IllegalArgumentException exception){
      //   exception.printStackTrace();
      // } finally {
      //   System.out.print("\n");
      // }
      // System.out.println("EquilateralTriangle: \tArea: " + eqlt.getArea () + "\tPerimeter: " + eqlt.getPerimeter());      
    }
}