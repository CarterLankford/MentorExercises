public class Square implements Shape {
    private float side;

    @Override
    public float getArea() {
        return side * side; 
    }

    @Override
    public float getPerimeter() {
        return side * 4;
    }
    
    public float getSide() {
        return side;
    }

    public void setSide(float side) {
        this.side = side; 
    }

    // @Override
    // public String toString(){
        
    // }
}