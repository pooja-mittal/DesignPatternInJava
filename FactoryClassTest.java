import java.util.Scanner;

abstract class Plan {
	double rate;

	abstract void getRate();

	public double  calculateBill(int unit) {
		double d=rate*unit;
		System.out.println(d);
		return d;
	}

}

class DomesticPlan extends Plan {
	
	public void getRate() {
		rate=3.50;
	}
}

class CommericialPlan extends Plan {
	
	public void getRate() {
		rate=7.50;
	}
	
}

class InstituionalPlan extends Plan {
	
	public void getRate() {
		rate=5.50;
	}
	
}

class FactoryClass {
	
	public static Plan getPlan(String planType) {
		if(planType==null) {
			return null; 			
		}
		else if(planType.equalsIgnoreCase("DomesticPlan")) {
			return new DomesticPlan();
			
		}
		 
		else if(planType.equalsIgnoreCase("CommericialPlan")) {
				return new CommericialPlan();
				
			}
		
		else if(planType.equalsIgnoreCase("InstituionalPlan")) {
			return new InstituionalPlan();
			
		}
		return null;
	}
}
public class FactoryClassTest {
	public static void main(String[] args) {
		Scanner scr=new Scanner(System.in);
		System.out.println("enter the plan type ");
		String str=scr.nextLine();
		
		System.out.println("enter the no of unit required for bill generation");
		int n=scr.nextInt();
		
		Plan p=FactoryClass.getPlan(str);
		p.getRate();
		double finalrate=p.calculateBill(n);
		
		//System.out.println(p.calculateBill(n));
		
		
	}
	
	
}
