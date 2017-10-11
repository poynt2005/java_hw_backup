
public class Triangle extends TwoDimensionalShape{
	private double side1,side2,side3;
	
	public Triangle(){
		side1 = side2 = side3 = 0.0;
	}
	
	public Triangle(double input){
		side1 = input;
		side2 = side3 = 0.0;
	}
	
	public Triangle(double input1,double input2){
		side1 = input1;
		side2 = input2;
		side3 = 0.0;
	}
	
	public Triangle(double input1,double input2,double input3){
		side1 = input1;
		side2 = input2;
		side3 = input3;
	}
	
	public double getSide1(){
		return side1;
	}
	
	public double getSide2(){
		return side2;
	}
	
	public double getSide3(){
		return side3;
	}
	
	private double Heron_formula(){
		double a = getSide1();
		double b = getSide2();
		double c = getSide3();
		
		if(c==0) return 0;
		else{
		double s = (a + b + c) / (double)2;
		double un_root = s*(s-a)*(s-b)*(s-c);
		return  Math.sqrt(un_root);
		}
	}
	
	@Override
	public double getArea(){
		return Heron_formula();
	}
	
	public String toString()
	{
		return String.format("side1 : %,.4f, side2 : %,.4f, side3 : %,.4f, This Two-DimensionalShape is %s",getSide1(),getSide2(),getSide3(),getClass().getName());
	}

}
