package Misc;

//Newton's method
public class CalculateRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double ErrorMargin =0.001;
		double x =25;
		double result = squareroot(x, ErrorMargin);
		System.out.println("Final result:" + result);
	}
	
	public static double squareroot(double x, double ErrorMargin){
	    if(x<0)
	    	return -1; //Error
	    double a = 1;
	    double b = x;
	    System.out.println("Init a: "+a);
        System.out.println("Init b: "+b);
	    while (Math.abs(a-b)>ErrorMargin){ 
	        a = (a+b)/2;
	        System.out.println("a: "+a);
	        b = x/a;
	        System.out.println("b: "+b);
	    }
	    return a;	
	}

}
