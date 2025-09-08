package beverages_decorator;

public class SugarDecorator extends BeverageDecorator {

    public SugarDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int cost() {
        return beverage.cost() + 2; 
    }
}
