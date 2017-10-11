
public class Sphere extends ThreeDimensionalShape{
	private double r;
	
	public Sphere(){
		r = 0.0;
	}
	
	public Sphere(double input){
		r = input;
	}
	
	public double get_r(){
		return r;
	}
	
	@Override
	public double getArea(){
		return (4 * Math.PI) * get_r() * get_r();
	}
	
	@Override
	public double getvolume(){
		double c = 4/3;
		return (c * Math.PI) * get_r() * get_r() * get_r();
	}
	
	@Override
	public String toString(){
		return String.format("Radius : %,.4f , This Three-DimensionalShape is %s",get_r(),getClass().getName());
	}
}
