public class RightTriangle extends AbstractTriangle {
    private static final int ANGLE = 90;

    public RightTriangle(float s1, float s2, int a1){
        super(s1, s2, (float)Math.sqrt(s1*s1 + s2*s2), ANGLE, a1, ANGLE - a1);
    }

    @Override
    public float getArea(){
        return this.getS2() * this.getS1() / 2;
    }
}
