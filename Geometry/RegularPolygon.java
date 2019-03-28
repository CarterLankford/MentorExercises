public class RegularPolygon implements Shape{
    protected float lengthOfSide;
    private int numberOfSides;
    
    public RegularPolygon() {
        // System.out.println("Creating a RegularPolygon");
        // RegularPolygon.validateNumberOfSides(numberOfSides);
        // RegularPolygon.validateLengthOfSide(lengthOfSide);
    }

    public RegularPolygon(float lengthOfSide, int numberOfSides) {
        RegularPolygon.validateNumberOfSides(numberOfSides);
        RegularPolygon.validateLengthOfSide(lengthOfSide);
        this.lengthOfSide = lengthOfSide;
        this.numberOfSides = numberOfSides;
        // if (lengthOfSide > 0 && numberOfSides >= 3) {
        //     this.lengthOfSide = lengthOfSide;
        //     this.numberOfSides = numberOfSides;
        // } else {
        //     throw new IllegalArgumentException("Invalid value passed to constructor");
        // }
        
    }

    @Override
    public float getArea() {
        return this.getPerimeter() * this.getApothem() / 2;
    }

    @Override
    public float getPerimeter() {
        return lengthOfSide * numberOfSides;
    }

    public float getApothem() {
        // return lengthOfSide / ( 2 * tan (180 / numberOfSides) );
        // return (float) Math.tan(4.0);
        double angle = Math.toRadians(180 / numberOfSides);
        return lengthOfSide / ((float)2 * (float)Math.tan(angle));  
    }

    public float getLengthOfSide() {
        return lengthOfSide;
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }

    public void setLengthOfSide(float lengthOfSide) {
        this.lengthOfSide = lengthOfSide;
    }

    public void setNumberOfSides(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    // Why can't we combind it? - Ask at next meeting
    public void setRegularPolygonVar(float lengthOfSide, int numberOfSides) {
        this.lengthOfSide = lengthOfSide;
        this. numberOfSides = numberOfSides;
    }

    private static void validateNumberOfSides(int numberOfSides){
        if ( numberOfSides <= 2) {
            throw new IllegalArgumentException("Not enough sides to be a regular polygon");
        }

    }

    private static void validateLengthOfSide(float lengthOfSide){
        if (lengthOfSide < 0) {
            throw new IllegalArgumentException("lengthOfSide can't be less than 0");
        }
    }

    /*
•   perimeter = length of side * number of sides
•   area = perimeter * apothem / 2
•   apothem = length of side / ( 2 * tan (180 / num sides) )
    */

}