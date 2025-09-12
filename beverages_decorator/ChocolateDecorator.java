package beverages_decorator;

public class ChocolateDecorator extends Beverage{
    Beverage beverage;

    public ChocolateDecorator(Beverage b){
        this.beverage = b;
    }
    @Override
    public int cost() {
        return this.beverage.cost() + 100;
    }
    
}
