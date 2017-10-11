
public class test {
public static void main(String[] args){
	Shape[] myshape = new Shape[6];
	
	myshape[0] = new Circle(2.0);
	myshape[1] = new Square(2.0);
	myshape[2] = new Triangle(3,3,2);
	myshape[3] = new Sphere(2.0);
	myshape[4] = new Cube(2.0);
	myshape[5] = new Tetrahedron(1.0,1.0,1.0,  2.0,-1.0,-2.0,  3.0,-5.0,-1.0,  4.0,-1.0,2.0);
	
	
	for(Shape current : myshape){
		System.out.print(current);
		if(current instanceof ThreeDimensionalShape)
			System.out.printf(" ; and Area is : %,.4f ; Volume is : %,.4f\n", ((ThreeDimensionalShape)current).getArea() , ((ThreeDimensionalShape)current).getvolume());
		else
			System.out.printf(" ; and Area is : %,.4f\n", ((TwoDimensionalShape)current).getArea());
	}
}
}
