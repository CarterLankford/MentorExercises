public class RegularPolygon implements Shape{
	protected float lengthOfSide;
	private float numberOfSides;

	// TODO: Add parameter constrcutor

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

	public float getNumberOfSides() {
		return numberOfSides;
	}

	public void setLengthOfSide(float lengthOfSide) {
		this.lengthOfSide = lengthOfSide;
	}

	public void setNumberOfSides(float numberOfSides) {
		this.numberOfSides = numberOfSides;
	}

	// Why can't we combind it? - Ask at next meeting
	public void setRegularPolygonVar(float lengthOfSide, float numberOfSides) {
		this.lengthOfSide = lengthOfSide;
		this. numberOfSides = numberOfSides;
	}

	/*
•	perimeter = length of side * number of sides
•	area = perimeter * apothem / 2
•	apothem = length of side / ( 2 * tan (180 / num sides) )
	*/

}