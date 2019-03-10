public class EquilateralTriangle extends AbstractTriangle {
    private static final float COEFFICIENT = (float)Math.sqrt(3) / 4;
    private static final int ANGLE = 60;

    public EquilateralTriangle(float s1){
        super(s1, s1, s1, ANGLE, ANGLE, ANGLE);
    }

    @Override
    public float getArea(){
        return COEFFICIENT * this.getS1() * this.getS1();
    }
}
