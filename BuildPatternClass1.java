import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Items {
	String name();

	String size();

	float price();
}

abstract class Pizza implements Items {

	abstract public float price();
}

abstract class SoftDrink implements Items {

	abstract public float price();
}

abstract class VegPizza extends Pizza {

	public abstract String name();

	public abstract String size();

	public abstract float price();
}

abstract class NonVegPizza extends Pizza {

	public abstract String name();

	public abstract String size();

	public abstract float price();
}

class SmallCheesePizza extends VegPizza {

	public String name() {
		return "cheese pizza";
	}

	public float price() {
		return 170.0f;
	}

	public String size() {
		return "small size";
	}
}

class MediumCheesePizza extends VegPizza {

	public String name() {
		return "cheese pizza";
	}

	public float price() {
		return 220.0f;
	}

	public String size() {
		return "Meedium size";
	}
}

class SmallOnionPizza extends VegPizza {

	public String name() {
		return "Onion pizza";
	}

	public float price() {
		return 120.0f;
	}

	public String size() {
		return "small size";
	}
}

class MediumOnionPizza extends VegPizza {

	public String name() {
		return "Onion pizza";
	}

	public float price() {
		return 150.0f;
	}

	public String size() {
		return "Medium size";
	}
}

class SmallMasalaPizza extends VegPizza {

	public String name() {
		return "Masala pizza";
	}

	public float price() {
		return 100.0f;
	}

	public String size() {
		return "small size";
	}
}

class MediumMasalaPizza extends VegPizza {

	public String name() {
		return "Masala pizza";
	}

	public float price() {
		return 120.0f;
	}

	public String size() {
		return "Medium size";
	}
}

class SmallNonVegPizza extends NonVegPizza {

	public String name() {
		return "NonVeg pizza";
	}

	public float price() {
		return 100.0f;
	}

	public String size() {
		return "small size";
	}
}

class MediumNonVegPizza extends NonVegPizza {

	public String name() {
		return "NonVeg pizza";
	}

	public float price() {
		return 150.0f;
	}

	public String size() {
		return "Medium size";
	}
}

abstract class PepsiDrink extends SoftDrink {

	public abstract String name();

	public abstract String size();

	public abstract float price();

}

abstract class CokeDrink extends SoftDrink {

	public abstract String name();

	public abstract String size();

	public abstract float price();

}

class SmallPepsi extends PepsiDrink {

	@Override
	public String name() {

		return "30 ml pepsi";
	}

	@Override
	public String size() {

		return "small size";
	}

	@Override
	public float price() {

		return 25.0f;
	}

}

class MediumPepsi extends PepsiDrink {

	@Override
	public String name() {

		return "50 ml pepsi";
	}

	@Override
	public String size() {

		return "small size";
	}

	@Override
	public float price() {

		return 50.0f;
	}

}

class SmallCoke extends CokeDrink {

	@Override
	public String name() {

		return "30 ml Coke";
	}

	@Override
	public String size() {

		return "small size";
	}

	@Override
	public float price() {

		return 40.0f;
	}

}

class MediumCoke extends CokeDrink {

	@Override
	public String name() {

		return "50 ml Coke";
	}

	@Override
	public String size() {

		return "Medium size";
	}

	@Override
	public float price() {

		return 80.0f;
	}

}

class OrderItems {
	List<Items> li = new ArrayList<Items>();

	void addItem(Items item) {
		li.add(item);
	}

	float getCost() {
		float cost = 0.0f;
		for (Items n : li) {
			cost += n.price();
		}
		return cost;
	}

	void showItem() {
		System.out.println("your order ");
		for (Items n : li) {
			System.out.println("item is  " + n.name());
			System.out.println("item's size  " + n.size());
			System.out.println(" cost is  " + n.price());

		}
	}
}

class OrderBuilder {
	OrderItems PreparePizza() {
		OrderItems oi = new OrderItems();
		Scanner scr = new Scanner(System.in);
		System.out.println("1. veg-pizza");
		System.out.println("2. Non veg-pizza");
		System.out.println("3. Exit");
		int choice = scr.nextInt();
		switch (choice) {
		case 1:
			System.out.println("you ordered veg pizza");
			System.out.println();
			System.out.println("enter the type of pizze");
			System.out.println("1 chesse piza");
			System.out.println("2 onion piza");
			System.out.println("3 medium piza");
			System.out.println("4 exit");
			int n = scr.nextInt();
			switch (n) {
			case 1:
				System.out.println("you order cheese pizza");
				System.out.println("1. you want small size");
				System.out.println("2 you want medium size");
				int cheesePizzaSize = scr.nextInt();
				switch (cheesePizzaSize) {
				case 1:
					oi.addItem(new SmallCheesePizza());
					break;
				case 2:
					oi.addItem(new MediumCheesePizza());
					break;

				}
				break;
			case 2:
				System.out.println("you ordered onion pizza");
				System.out.println("1 you want small size");
				System.out.println("2 you want medium size");
				int onionPizzaSize = scr.nextInt();
				switch (onionPizzaSize) {
				case 1:
					oi.addItem(new SmallOnionPizza());
					break;
				case 2:
					oi.addItem(new MediumOnionPizza());
					break;

				}
				break;
			case 3:
				System.out.println("you ordered masala pizza");
				System.out.println("1 you want small masala pizza");
				System.out.println("2 you want Medium masala pizza");
				int MasalaPizzaSize = scr.nextInt();
				switch (MasalaPizzaSize) {
				case 1:
					oi.addItem(new SmallMasalaPizza());
					break;
				case 2:
					oi.addItem(new MediumOnionPizza());
					break;
				}
				break;

			}
			break;
		case 2:
			System.out.println("you order non veg pizza");
			System.out.println();
			System.out.println("enter the non veg pizza size");
			System.out.println("1 small non veg pizzza");
			System.out.println("2 Medium non veg pizzza");
			System.out.println("3 exit");
			int nonVegPizzaSize = scr.nextInt();
			switch (nonVegPizzaSize) {
			case 1:
				oi.addItem(new SmallNonVegPizza());
				break;
			case 2:
				oi.addItem(new MediumNonVegPizza());
				break;

			}
			break;
		case 3:
		default:
			break;
		}

		System.out.println();
		System.out.println("enter the choice of drink");
		System.out.println("1 pesi");
		System.out.println("2 coke");
		System.out.println("exit");
		int coldDrinkChoice = scr.nextInt();
		switch (coldDrinkChoice) {
		case 1:
			System.out.println("you ordered pepsi");
			System.out.println("enter the pesi size");
			System.out.println("1 small size");
			System.out.println("2 medium size");
			int pepsiSize = scr.nextInt();
			switch (pepsiSize) {
			case 1:
				oi.addItem(new SmallPepsi());
				break;
			case 2:
				oi.addItem(new MediumPepsi());
				break;
			}
			break;
		case 2:
			System.out.println("you ordered coke ");
			System.out.println("enter coke size");
			System.out.println("1. small size");
			System.out.println("2 meeduim size");
			int cokeSize = scr.nextInt();
			switch (cokeSize) {
			case 1:
				oi.addItem(new SmallCoke());
				break;
			case 2:
				oi.addItem(new MediumCoke());
				break;

			}
			break;
		case 3:
		default:
			break;

		}
		return oi;
	}
}

public class BuildPatternClass1 {
	public static void main(String[] args) {
		OrderBuilder ob=new OrderBuilder();
		OrderItems op=ob.PreparePizza();
		op.showItem();
		System.out.println();
		System.out.println("total cost " + op.getCost());
		
	}
}
