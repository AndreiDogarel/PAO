package interfaces.ex3.vehicles;

public class Car implements Vehicle {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void start() {
        System.out.println(name + "started");
    }

    @Override
    public void stop(){
        System.out.println(name + "stopped");
    }

    public void horn(){
        System.out.println("Beep Beep!");
    }
}
