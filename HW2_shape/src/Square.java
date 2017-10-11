
public class Square extends TwoDimensionalShape{
	private double l;
	
	public Square(){
		l = 0.0;
	}
	
	public Square(double input){
		l = input;
	}
	
	public double get_l(){
		return l;
	}
	
	@Override
	public double getArea(){
		return get_l()*get_l();
	}
	
	@Override
	public String toString()
	{
		return String.format("length : %,.4f, This Two-DimensionalShape is %s",get_l(),getClass().getName());
	}
}
