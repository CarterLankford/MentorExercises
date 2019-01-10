public class Circle {
    //radius
    //diameter = 2xradius
    //circumfrence = PI x diameter = 2xPI x radius where PI=3.14159
    //area = PI x radius(squared)

    private static final double PI = 3.14159; // turned into constant to better utilize memory
    private static int numberOfInstances = 0; // example to show static vs instance: is it independent or dependant on the instance; circle example

    private double radius; 

    public Circle(){
    	Circle.numberOfInstances++;  // counts amount of new instances of the object created; 
    }

    public static void main(String[] args){
    	Circle cr = new Circle();
    	Circle cr1 = new Circle();
    	Circle cr2 = new Circle();
    	Circle cr3 = new Circle();
    	Circle cr4 = new Circle();
    	Circle cr5 = new Circle();
    	cr.setRadius(1.5);

    	System.out.println(cr.getDiameter());
    	System.out.println(cr.getArea());
    	System.out.println(cr.getCircumfrence());

    	System.out.println(Circle.getNumberOfInstances());

    }

    public static double getPI(){
    	return PI;
    }

    public static int getNumberOfInstances(){
    	return numberOfInstances; // Returns the count for amount of class instances created. 
    }

    public double getDiameter(){
    	return this.radius * 2;
    }

    public double getCircumfrence(){
    	return Circle.PI * this.getDiameter(); //simpflication of the mthod
    }

    public double getArea(){
    	return Circle.PI * this.radius * this.radius; // since all multiplacation don't need ()
    }

    public void setRadius(double radius){
    	this.radius = radius;
    }

    public double getRadius(){
    	return this.radius; //Allows the value of radius to be called. 
    }
}
