package beverages_decorator;

public class Client {

	public static void main(String[] args) {
		

		
		Beverage coffee = new Cappuccino();
        System.out.println("Coffee");
		System.out.println(coffee.cost());
		
		

	}

}