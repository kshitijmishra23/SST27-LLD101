package beverages_decorator;

public class Client {
    public static void main(String[] args) {
        Beverage coffee = new Cappuccino();
        System.out.println("Base Coffee: " + coffee.cost());

        coffee = new MilkDecorator(coffee);
        System.out.println("With Milk: " + coffee.cost());

        coffee = new SugarDecorator(coffee);
        System.out.println("With Milk & Sugar: " + coffee.cost());

        Beverage latte = new SugarDecorator(new MilkDecorator(new Latte()));
        System.out.println("Latte with Milk & Sugar: " + latte.cost());
    }
}
