public class Circle {
    //radius
    //diameter = 2xradius
    //circumfrence = Pi x diameter = 2xPI x radius where pi=3.14159
    //area = pi x radius(squared)

    private double radius;
    private double pi = 3.14159;


    public static void main(String[] args){
    	Circle cr = new Circle();
    	cr.setRadius(1.5);

    	System.out.println(cr.getDiameter());
    	System.out.println(cr.getArea());
    	System.out.println(cr.getCircumfrence());
    }

    public double getDiameter(){
    	return radius * 2;
    }

    public double getCircumfrence(){
    	return ((2 * pi) * radius);
    }

    public double getArea(){
    	return pi * (radius * radius);
    }

    public void setRadius(double radius){
    	this.radius = radius;
    }
}
