public class RegularPolygon implements Shape{
	private float lengthOfSide;
	private float numberOfSides;

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
		return (float) Math.tan(4.0);	
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

	/*
•	perimeter = length of side * number of sides
•	area = perimeter * apothem / 2
•	apothem = length of side / ( 2 * tan (180 / num sides) )
	*/

}