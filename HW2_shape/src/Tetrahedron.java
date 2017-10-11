import java.util.Arrays; 
public class Tetrahedron extends ThreeDimensionalShape{
	private double[] a = new double[3];
	private double[] b = new double[3];
	private double[] c = new double[3]; 
	private double[] d = new double[3];
	
	
	public Tetrahedron(){
		Arrays.fill(a,0.0);
		Arrays.fill(b,0.0);
		Arrays.fill(c,0.0);
		Arrays.fill(d,0.0);
	}
	
	public Tetrahedron(double a0,double a1,double a2,double b0,double b1,double b2,double c0,double c1,double c2,double d0,double d1,double d2){
		
		a[0] = a0;
		a[1] = a1;
		a[2] = a2;
	
		b[0] = b0;
		b[1] = b1;
		b[2] = b2;
		
		c[0] = c0;
		c[1] = c1;
		c[2] = c2;
		
		d[0] = d0;
		d[1] = d1;
		d[2] = d2;	
	}
	
	public double[] getVertex_a()
	{
		return a;
	}
	
	public double[] getVertex_b(){
		return b;
	}
	
	public double[] getVertex_c(){
		return c;
	}
	
	public double[] getVertex_d(){
		return d;
	}
	
	private double[] getVector_AB(){
		double vector_ab[] = new double[3];
		double[] y = getVertex_b();
		double[] x = getVertex_a();
		
		vector_ab[0] = y[0] - x[0];
		vector_ab[1] = y[1] - x[1];
		vector_ab[2] = y[2] - x[2];
		return vector_ab;
	}
	
	private double[] getVector_AC(){
		double vector_ac[] = new double[3];
		double[] y = getVertex_c();
		double[] x = getVertex_a();
		
		vector_ac[0] = y[0] - x[0];
		vector_ac[1] = y[1] - x[1];
		vector_ac[2] = y[2] - x[2];
		
		return vector_ac;
	}
	
	private double[] getVector_AD(){
		double vector_ad[] = new double[3];
		double[] y = getVertex_d();
		double[] x = getVertex_a();
		
		vector_ad[0] = y[0] - x[0];
		vector_ad[1] = y[1] - x[1];
		vector_ad[2] = y[2] - x[2];
		
		return vector_ad;
	}
	
	private double[] getVector_BC(){
		double vector_bc[] = new double[3];
		double[] y = getVertex_c();
		double[] x = getVertex_b();
		
		vector_bc[0] = y[0] - x[0];
		vector_bc[1] = y[1] - x[1];
		vector_bc[2] = y[2] - x[2];
		
		return vector_bc;
	}
	
	private double[] getVector_BD(){
		double vector_bd[] = new double[3];
		double[] y = getVertex_d();
		double[] x = getVertex_b();
		
		vector_bd[0] = y[0] - x[0];
		vector_bd[1] = y[1] - x[1];
		vector_bd[2] = y[2] - x[2];
		
		return vector_bd;
	}
	
	private double calculate_vector_Absolute_value(double[] input){
		double a = input[0];
		double b = input[1];
		double c = input[2];
		double S = a*a + b*b + c*c;
		return Math.sqrt(S);
	}
	
	private double[] calculate_vcp(double[] x,double[] y){		
		double[] vector_cross = new double[3];
		vector_cross[0] = (x[1]*y[2]) - (x[2]*y[1]);
		vector_cross[1] = (x[2]*y[0]) - (x[0]*y[2]);
		vector_cross[2] = (x[0]*y[1]) - (x[1]*y[0]);		
		return vector_cross;
	}
	
	private double calculate_vdp(double[] x,double[] y){
		return  (x[0]*y[0]) + (x[1]*y[1]) + (x[2]*y[2]);
	}
	
	private double get_triangle_area(double[] x,double[] y){
		double m = calculate_vector_Absolute_value(x);
		double n = calculate_vector_Absolute_value(y);
		double m_dot_n = calculate_vdp(x,y);
		return Math.sqrt( (m*m)*(n*n) - (m_dot_n*m_dot_n) );
	}
	
	@Override
	public double getArea(){
		//area of vector ab and ac
		double ab_ac_area = get_triangle_area(getVector_AB(),getVector_AC());
		
		//area of vector ac and ad
		double ac_ad_area = get_triangle_area(getVector_AC(),getVector_AD());
		
		//area of vector ab and ad
		double ab_ad_area = get_triangle_area(getVector_AC(),getVector_AD());
		
		//area of vector bc and bd
		double bc_ad_area = get_triangle_area(getVector_BC(),getVector_BD());
		
		//sum 
		return ab_ac_area + ac_ad_area + ab_ad_area + bc_ad_area;
	}
	
	@Override
	public double getvolume(){
		//cross product of ab and ac
		double[] ab_cross_ac = calculate_vcp(getVector_AB(),getVector_AC());
		
		//dot product of ab_cross_ac and ad
		double S = calculate_vdp(ab_cross_ac,getVector_AD());
		
		//formula of tetrahedron's volume
		return Math.abs(S)/6;	
	}
	
	@Override
	public String toString(){
		
		double[] A = new double[3];
		A = getVertex_a();
		
		double[] B = new double[3];
		B = getVertex_b();
		
		double[] C = new double[3];
		C = getVertex_c();
		
		double[] D = new double[3];
		D = getVertex_d();
		
		return String.format("Vertex A = {%,.4f,%,.4f,%,.4f}; Vertex B = {%,.4f,%,.4f,%,.4f}; Vertex C = {%,.4f,%,.4f,%,.4f}; Vertex D = {%,.4f,%,.4f,%,.4f};  This Three-DimensionalShape is %s", A[0],A[1],A[2] , B[0],B[1],B[2] , C[0],C[1],C[2] , D[0],D[1],D[2],getClass().getName());
	}
}
