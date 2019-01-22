public class Circle implements Shape{
    private static final float PI = (float)3.14159; // turned into constant to better utilize memory
    private static int numberOfInstances = 0; // example to show static vs instance: is it independent or dependant on the instance; circle example
    private float radius; 

    public Circle(){
    	Circle.numberOfInstances++;  // counts amount of new instances of the object created; 
    }

    public static float getPI(){
    	return PI;
    }

    @Override
    public float getPerimeter(){
    	return Circle.PI * this.getDiameter(); //simpflication of the method, was named circumfrence, changed to match course instructions.
    }

    @Override
    public float getArea(){
    	return Circle.PI * this.radius * this.radius; // since all multiplacation don't need ()
    }

    public float getDiameter(){
    	return this.radius * 2;
    }

    public static int getNumberOfInstances(){
    	return numberOfInstances; // Returns the count for amount of class instances created. 
    }

    public void setRadius(float radius){
    	this.radius = radius;
    }

    public float getRadius(){
    	return this.radius; //Allows the value of radius to be called. 
    }
}
