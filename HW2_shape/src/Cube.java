
public class Cube extends ThreeDimensionalShape{
	private double l;
	
	public Cube(){
		l = 0.0;
	}
	
	public Cube(double input){
		l = input;
	}
	
	public double get_l(){
		return l;
	}
	
	@Override
	public double getArea(){
		return 6 * get_l() * get_l();
	}
	
	@Override
	public double getvolume(){
		return get_l() * get_l() * get_l();
	}
	
	@Override
	public String toString(){
		return String.format("side : %,.4f , This Three-DimensionalShape is %s",get_l(),getClass().getName());
	}
}