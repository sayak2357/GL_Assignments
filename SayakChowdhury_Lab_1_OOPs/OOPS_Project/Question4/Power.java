import java.util.Scanner;
public class Power{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("enter a number X = ");
		int p,x;
		p = sc.nextInt();
		System.out.print("enter power (N) = ");
		x = sc.nextInt();
		System.out.println(p+" to the power "+x+" is "+powerX(p,x));

	}
	private static long powerX(int p, int x){
		if(x==0)
			return 1;
		long halfPower = powerX(p,x/2);
		if(x%2==0)
			return halfPower*halfPower;
		return halfPower*halfPower*p;
	}
}