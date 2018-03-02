
interface Car {
	void assemble();
}

class Basiccar implements Car {
	public void assemble() {
		System.out.println("basic car");
	}
}

class DecoraterCar implements Car {
	Car c;

	DecoraterCar(Car c) {
		this.c = c;

	}

	public void assemble() {
		this.c.assemble();
	}

}

class SportsCar extends DecoraterCar {
	Car c;
	SportsCar(Car c) {
		super(c);
	}
	
	public void assemble() {
		super.assemble();
		System.out.println("adding feature of sports car");
	}
}

class LuxuryCar extends DecoraterCar {
	
	LuxuryCar(Car c) {
		super(c);
	}
	
	public void assemble() {
		super.assemble();
		System.out.println("adding feature of luxury car");
	}
}


public class DecoraterPatternExample {
	public static void main(String[] args) {
		Car c=new SportsCar(new Basiccar());
		c.assemble();
		System.out.println();
		
		Car ck=new LuxuryCar(new Basiccar());
		ck.assemble();
		
	}

}
