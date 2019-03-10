public abstract class AbstractTriangle implements Shape {
	private float s1, s2, s3;
	private int a1, a2, a3;

	// Parameter constructor
	public AbstractTriangle(float s1, float s2, float s3, int a1, int a2, int a3) {
		AbstractTriangle.validateAngles(a1, a2, a3);
		AbstractTriangle.validateSides(s1, s2, s3);

		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		this.a1 = a1;
		this.a2 = a2;
		this.a3 = a3;
	}

	//Getters and Setters
	@Override
    public float getPerimeter(){
        return s1 + s2 + s3;
    }

    public int getA1(){
    	return a1;
    }

    public int getA2(){
    	return a2;
    }

    public int getA3(){
    	return a3;
    }

    public void setA1(int a1){
    	this.a1 = a1;
    }

    public void setA2(int a2){
    	this.a2 = a2;
    }

    public void setA3(int a3){
    	this.a3 = a3;
    }

    public float getS1(){
    	return s1;
    }

    public float getS2(){
    	return s2;
    }

    public float getS3(){
    	return s3;
    }

    public void setS1(float s1){
    	this.s1 = s1;
    }

    public void setS2(float s2){
    	this.s2 = s2;
    }

    public void setS3(float s3){
    	this.s3 = s3;
    }


	// Validation methods
	private static void validateAngles(int a1, int a2, int a3){
        // the sum of all angles should be 180 degrees
        if(180 != a1 + a2 + a3){
            // TODO: this is an error!!
            throw new IllegalArgumentException("Angles proviided do not add up to 180");
        }
    }

    private static void validateSides(float s1, float s2, float s3){
        // the sum of any two sides cannot be less than or equal than the third side
        if(s1 + s2 <= s3 || s2 + s3 <= s1 || s3 + s1 <= s2){
            // TODO: this is an error!!
            throw new IllegalArgumentException("Sides provided do not meet triangle inequality");
        }
    }


	
}