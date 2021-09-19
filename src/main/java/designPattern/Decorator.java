package designPattern;
/**
 * Decorator Design Pattern
 * https://www.journaldev.com/1540/decorator-design-pattern-in-java-example
 */
interface Car{
    void assemble();
}
class BasicCar implements Car{

      @Override
    public void assemble(){
        System.out.println("Implementing Basic Car ");
        System.out.println("Basic Car Implemented");
        System.out.println("_____________\n");
    }

}

class CarDecorator implements Car{

    protected Car car;

    public CarDecorator(Car car){

        this.car = car;
    }
    @Override
    public void assemble(){

        this.car.assemble();
    }
}

class SportsCar extends CarDecorator{

    SportsCar(Car car){
        super(car);
    }
    @Override
    public void assemble(){
        super.assemble();
        System.out.println("Adding feature of Sports Car");
        System.out.println("Added Sport Car Feature");
        System.out.println("_____________\n");
    }
}

class LuxuryCar extends CarDecorator{

    public LuxuryCar(Car car) {
        super(car);
    }
    @Override
    public void assemble(){


        super.assemble();
        System.out.println("Adding Feature of Luxury Car");
        System.out.println("Added Feature of Luxury Car");
        System.out.println("_____________\n");
    }
}
class DecoratorTest{
    public static void main(String[] args) {
        SportsCar sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();

        LuxuryCar  luxuryCar = new LuxuryCar(new BasicCar());
        luxuryCar.assemble();
    }
}
