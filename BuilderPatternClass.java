import java.util.ArrayList;

interface Item {
	public String name();

	public float price();

	public Packing packing();
}

interface Packing {
	String Pack();
}

class Wrapper implements Packing {
	public String Pack() {
		return "Wrapper";
	}
}

class Bottle implements Packing {
	public String Pack() {
		return "Bottle";
	}
}

abstract class Burger implements Item {
	public Packing packing() {
		return new Wrapper();
	}

	public abstract float price();
}

abstract class ColdDrink implements Item {
	public Packing packing() {
		return new Bottle();
	}

	public abstract float price();
}

class VegBurger extends Burger {
	public float price() {
		return 25.0f;
	}

	public String name() {
		return "veg Burger";
	}
}

class NonVegBurger extends Burger {
	public float price() {
		return 90.0f;
	}

	public String name() {
		return "Non Veg Burger";
	}
}

class Coke extends ColdDrink {
	public float price() {
		return 50.0f;
	}

	public String name() {
		return "Coke";
	}
}

class Pepsi extends ColdDrink {
	public float price() {
		return 30.0f;
	}

	public String name() {
		return "Pepsi";
	}
}

class Meal {
	ArrayList<Item> l = new ArrayList<Item>();

	void addItem(Item it) {
		l.add(it);
	}

	float getcost() {
		float cost = 0.0f;
		for (Item it : l) {
			cost += it.price();

		}
		return cost;
	}

	void showItem() {
		for (Item it : l) {
			System.out.println(" item " + it.name());
			System.out.println("total cost " + it.price());
			System.out.println("your packing " + it.packing().Pack());
		}
	}
}

class MealBuilder {
	Meal prepareVegMeal() {
		Meal m = new Meal();
		m.addItem(new VegBurger());
		m.addItem(new Pepsi());
		return m;

	}

	Meal prepareNonVegMeal() {
		Meal m = new Meal();
		m.addItem(new NonVegBurger());
		m.addItem(new Coke());
		return m;

	}
}

public class BuilderPatternClass {
	
	public static void main(String[] args) {
		MealBuilder mb=new MealBuilder();
		System.out.println("veg meal");
		Meal vegMeal=mb.prepareVegMeal();
		vegMeal.showItem();
		System.out.println("total cost " + vegMeal.getcost());
		System.out.println();
		
		System.out.println("Non Veg Meal");
		Meal NonvegMeal=mb.prepareNonVegMeal();
		NonvegMeal.showItem();
		System.out.println("total cost " + NonvegMeal.getcost());
		
		
	}
}
