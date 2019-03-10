public class IsoscelesTriangle extends AbstractTriangle {

    public IsoscelesTriangle(float s1, float s2, int a1){
        super(s1, s2, s1, a1, 90 - a1/2, 90 - a1/2);
    }

    @Override
    public float getArea(){
        float a2 = this.getS1() * this.getS1();
	  	float b2 = this.getS2() * this.getS2();
        return this.getS2()/4 * (float)Math.sqrt(4*a2-b2);
    }
}
