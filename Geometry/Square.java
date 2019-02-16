public class Square extends RegularPolygon {

    public Square(){
        // super(); << Implicitly added by the compiler
        super.setNumberOfSides(4);
    }

    public Square(float lengthOfSide){
        super(lengthOfSide, 4);
    }

    @Override
    public float getArea() {
        return this.lengthOfSide * this.lengthOfSide; 
    }

    @Override
    public void setNumberOfSides(int numberOfSides){
        
    }

    // @Override
    // public String toString(){
        
    // }
}