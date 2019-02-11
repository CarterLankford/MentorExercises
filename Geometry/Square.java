public class Square extends RegularPolygon {

    public Square(){
        super();
        super.setNumberOfSides((float)4);
    }

    @Override
    public float getArea() {
        return this.lengthOfSide * this.lengthOfSide; 
    }

    @Override
    public void setNumberOfSides(float numberOfSides){
        
    }

    // @Override
    // public String toString(){
        
    // }
}