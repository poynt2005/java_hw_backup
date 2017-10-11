
public class Circle extends TwoDimensionalShape {
	
	private double r;
	
	public Circle(){
		r= 0.0;
	}
	
	public Circle(double input){
		r = input;
	}
	
	public double get_r(){
		return r;
	}
	
	@Override
	public double getArea(){
		return Math.PI * get_r() * get_r();
	}
	
	@Override
	public String toString()
	{
		return String.format("Radius : %,.4f, This Two-DimensionalShape is %s",get_r(),getClass().getName());
	}
}
