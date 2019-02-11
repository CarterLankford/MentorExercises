public class Square extends RegularPolygon {

    public Square(){
        super();
        super.setNumberOfSides(4);
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