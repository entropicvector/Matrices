//Christian Krenzlin

import java.util.Scanner;
public class Matrix {
	static double[][] inverse = new double[3][3];
	static double[][] inverse2 = new double[2][2];
	public static void main(String[] args){
		System.out.println("Matrix inverse calculator");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.println("How many rows");
		int r = sc.nextInt();
		System.out.println("How many columns");
		int c = sc.nextInt();
		if(r==c){
		double[][] matrix = new double[r][c];
		for(int i =0;i<matrix.length;i++){
			for(int j = 0;j<matrix[i].length;j++){
				System.out.println("Enter a number");
				double num = sc.nextDouble();
				matrix[i][j] = num;
			}
		}
			if(r == 2){
				System.out.println();
				double det = solve2(matrix);
				inverse2(matrix,det);
			}
			else if(r == 3){
				System.out.println();
				solve3(matrix);
				inverse3(matrix);
			}
		}
		else{
			System.out.println("Not a square matrix");
		}
	}

	
	public static double solve2(double[][] m){
		double result = ((m[0][0] * m[1][1]) - (m[0][1] * m[1][0]));
		return result;
		
				
	}
	public static void inverse2(double[][] m, double d){
		double det = 1/d;
		System.out.println("Determinant is: "+d);
		System.out.println();
		inverse2[0][0] = m[1][1];
		inverse2[0][1] = -m[0][1];
		inverse2[1][0] = -m[1][0];
		inverse2[1][1] = m[0][0];
		inverse2[0][0] *= det;
		inverse2[0][1] *= det;
		inverse2[1][0] *= det;
		inverse2[1][1] *= det;
		
		for (double[] row : inverse2) {
	        //for each number in the row
	        for (double j : row) {
	            System.out.print(j + " ");
	        }
	        System.out.println("");
	    }
	}
	
	public static double solve3(double[][] m){
		double a = m[0][0];
		double b = m[0][1];
		double c = m[0][2];
		double d = m[1][0];
		double e = m[1][1];
		double f = m[1][2];
		double g = m[2][0];
		double h = m[2][1];
		double i = m[2][2];
		double result = (a*((e*i)-(f*h))-(b*((d*i)-(f*g)))+(c*((d*h)-(e*g))));
		return result;
		
	}
	public static void inverse3(double[][] m){
		double det = solve3(m);
		minors(m);
		tran();
		adj();
		fin(det);
		for (double[] row : inverse) {
	        //for each number in the row
	        for (double j : row) {
	            System.out.print(j + " ");
	        }
	        System.out.println("");
	    }
	}
	public static double[][] minors(double[][] m){
		double a = m[0][0];
		double b = m[0][1];
		double c = m[0][2];
		double d = m[1][0];
		double e = m[1][1];
		double f = m[1][2];
		double g = m[2][0];
		double h = m[2][1];
		double i = m[2][2];
		double na = ((e*i)-(f*h));
		double nb = ((d*i)-(f*g));
		double nc = ((d*h)-(e*g));
		double nd = ((b*i)-(c*h));
		double ne = ((a*i)-(g*c));
		double nf = ((a*h)-(g*b));
		double ng = ((b*f)-(e*c));
		double nh = ((a*f)-(d*c));
		double ni = ((a*e)-(d*b));
		inverse[0][0] = na;
		inverse[0][1] = nb;
		inverse[0][2] = nc;
		inverse[1][0] = nd;
		inverse[1][1] = ne;
		inverse[1][2] = nf;
		inverse[2][0] = ng;
		inverse[2][1] = nh;
		inverse[2][2] = ni;
		return inverse;
		
	}
	public static double[][] tran(){
		inverse[0][1] = -inverse[0][1];
		inverse[1][0] = -inverse[1][0];
		inverse[1][2] = -inverse[1][2];
		inverse[2][1] = -inverse[2][1];
		return inverse;
	}
	public static double[][] adj(){
		double temp;
		temp = inverse[0][1];
		inverse[0][1] = inverse[1][0];
		inverse[1][0] = temp;
		temp = inverse[0][2];
		inverse[0][2] = inverse[2][0];
		inverse[2][0] = temp;
		temp = inverse[1][2];
		inverse[1][2] = inverse[2][1];
		inverse[2][1] = temp;
		return inverse;
	}
	public static double[][] fin(double det){
		double Det = 1/det;
		System.out.println("Determinant is: "+det);
		System.out.println();
		inverse[0][0] *= Det;
		inverse[0][1] *= Det;
		inverse[0][2] *= Det;
		inverse[1][0] *= Det;
		inverse[1][1] *= Det;
		inverse[1][2] *= Det;
		inverse[2][0] *= Det;
		inverse[2][1] *= Det;
		inverse[2][2] *= Det;
		return inverse;
		
	}
}
