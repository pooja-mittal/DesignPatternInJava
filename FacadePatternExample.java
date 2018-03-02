
class Inventory {
	String checkInventory(String orderId) {
		return "inventory checked";
		
	}
}

class Payment {
	String paymentDeduced(String orderId) {
		return "pament has been deducted";
	}
}

class Order{
	Payment p=new Payment();
	Inventory i=new Inventory();
	void placeOrder(String orderId) {
		String s1=i.checkInventory(orderId);
		String s2=p.paymentDeduced(orderId);
		System.out.println("steps are completes \n" + s1 + "\n "+ s2);
	}
}
public class FacadePatternExample {
	public static void main(String [] args) {
		Order ol=new Order();
		ol.placeOrder("OR1234");
		System.out.println();
		System.out.println("order processing completed ");
	}

}
