
interface Food {
	String prepareFood();

	double foodPrice();
}

class vegFood implements Food {

	@Override
	public String prepareFood() {
		// TODO Auto-generated method stub
		return "veg food";
	}

	@Override
	public double foodPrice() {
		// TODO Auto-generated method stub
		return 50.0;
	}

}

class FoodDecorater implements Food {
	Food f;

	FoodDecorater(Food f) {
		this.f = f;

	}

	public String prepareFood() {
		return f.prepareFood();
	}

	public double foodPrice() {
		return f.foodPrice();
	}
}

class NonVeg extends FoodDecorater {
	NonVeg(Food f) {
		super(f);
	}

	public String prepareFood() {
		return super.prepareFood() + " with chicken";
	}

	public double foodPrice() {
		return f.foodPrice() + 150;
	}
}

class chinease extends FoodDecorater {
	chinease(Food f) {
		super(f);
	}

	public String prepareFood() {
		return super.prepareFood() + " with rice and curry";
	}

	public double foodPrice() {
		return f.foodPrice() + 100;
	}
}

public class DecoraterPattern1 {

	public static void main(String[] args) {
		
		Food f2=new vegFood();
		System.out.println("you selected vegfood");
		System.out.println("food " + f2.prepareFood());
		System.out.println("cost " + f2.foodPrice());
		System.out.println();
		
		
		Food f=new chinease(new vegFood() );
		System.out.println("you selected chinease");
		System.out.println("food " + f.prepareFood());
		System.out.println("cost " + f.foodPrice());
		System.out.println();
		
		Food f1=new NonVeg(new vegFood() );
		System.out.println("you nonveg chinease");
		System.out.println("food " + f1.prepareFood());
		System.out.println("cost " + f1.foodPrice());
		System.out.println();
		

	}

}
