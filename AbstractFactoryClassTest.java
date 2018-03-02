import java.util.Scanner;

interface Bank {
	String getBankName();
}

class HDFC implements Bank {
	private final String name;

	HDFC() {
		name = "HDFC";
	}

	@Override
	public String getBankName() {
		return name;
	}

}

class ICICI implements Bank {
	private final String name;

	ICICI() {
		name = "HDFC";
	}

	@Override
	public String getBankName() {
		return name;
	}

}

class SBI implements Bank {
	private final String name;

	SBI() {
		name = "HDFC";
	}

	@Override
	public String getBankName() {
		return name;
	}

}

abstract class Loan {
	protected double rate;

	abstract void getInterestRate(double rate);

	void caculatePayment(double loanAmount, int years) {

		int n;
		n = years * 12;
		rate = rate / 1200;
		double EMI = ((rate * Math.pow((1 + rate), n)) / ((Math.pow((1 + rate), n)) - 1)) * loanAmount;

		System.out.println(" monthly EMI " + EMI + " for the amount " + loanAmount);

	}
}

class HomeLoan extends Loan {

	void getInterestRate(double r) {
		rate = r;
	}
}

class EducationLoan extends Loan {

	void getInterestRate(double r) {
		rate = r;
	}
}

class BusinessLoan extends Loan {

	void getInterestRate(double r) {
		rate = r;
	}
}

abstract class AbstractFactory {
	abstract Bank getBank(String bank);

	abstract Loan getLoan(String loan);
}

class Bankfactory extends AbstractFactory {

	Loan getLoan(String Loan) {
		return null;
	}

	Bank getBank(String bank) {
		if (bank == null)
			return null;
		else if (bank.equalsIgnoreCase("HDFC"))
			return new HDFC();
		else if (bank.equalsIgnoreCase("ICICI"))
			return new ICICI();
		else if (bank.equalsIgnoreCase("SBI"))
			return new SBI();
		return null;
	}
}

class LoanFactory extends AbstractFactory {
	Bank getBank(String name) {
		return null;
	}

	Loan getLoan(String l) {
		if (l == null)
			return null;
		else if (l.equalsIgnoreCase("HomeLoan"))
			return new HomeLoan();
		else if (l.equalsIgnoreCase("EduationLoan"))
			return new EducationLoan();
		else if (l.equalsIgnoreCase("BusinesLoan"))
			return new BusinessLoan();
		return null;

	}

}

class factory {
	public static AbstractFactory getClass(String name) {
		if (name.equalsIgnoreCase("Bank"))
			return new Bankfactory();
		else if (name.equalsIgnoreCase("Loan"))
			return new LoanFactory();
		return null;

	}
}

public class AbstractFactoryClassTest {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		System.out.println("enter the bank name from where you want take loan amount");
		String bankName = scr.nextLine();
		System.out.println();

		System.out.println("enter the type of loan e.g home loan, business loan or educational loan ");
		String loanName = scr.nextLine();

		AbstractFactory bankfact = factory.getClass("bank");
		Bank b = bankfact.getBank(bankName);

		System.out.println();
		System.out.println("enter the interest rate for this " + b.getBankName());
		double rate = scr.nextDouble();

		System.out.println();
		System.out.println("enter the amount for loan");
		double loanamt = scr.nextDouble();

		System.out.println("enter the year in which you will pay your loan amount ");
		int year = scr.nextInt();

		System.out.println();
		System.out.println("so you are taking loan from " + b.getBankName());

		AbstractFactory Loanfact = factory.getClass("Loan");
		Loan l = Loanfact.getLoan(loanName);
		l.getInterestRate(rate);
		l.caculatePayment(loanamt, year);

	}

}
