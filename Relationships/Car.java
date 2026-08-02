class Engine {

    void start() {
        System.out.println("Engine Started");
    }
}

class Car {

    Engine engine = new Engine();   // Has-A Relationship

    void drive() {
        engine.start();
        System.out.println("Car is Moving");
    }
}