import java.util.Scanner;

interface Prototype {
	Prototype getClone();
}

class Employee implements Prototype {

	int id;
	String name, address, designation;
	double salary;

	Employee(int id, String name, String designation, String address, double salary) {
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.address = address;
		this.salary = salary;
	}

	public void showRecord() {
		System.out.println(" id " + id + "\nname " + name + "\ndesignation" + designation + "\n salary" + salary
				+ "\naddress" + address);
	}

	public Prototype getClone() {
		return new Employee(id, name, designation, address, salary);
	}
}

public class PrototypePattern {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		System.out.println("enter Id");
		int id = scr.nextInt();

		System.out.println("enter name ");
		String name = scr.next();

		System.out.println("enter designation");
		String des = scr.next();
		scr.nextLine();
		System.out.println("enter address");
		String add = scr.nextLine();

		System.out.println("enter salary");
		double salary = scr.nextDouble();

		System.out.println();

		Employee e1 = new Employee(id, name, des, add, salary);
		e1.showRecord();
		System.out.println();
		Employee e2 = (Employee) e1.getClone();
		e2.showRecord();

	}

}
