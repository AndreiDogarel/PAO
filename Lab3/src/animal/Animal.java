package animal;

import java.util.Objects;

public class Animal {
    private String name;
    private int numOfLegs;

    public Animal() {

    }

    public Animal(String name, int numOfLegs) {
        this.name = name;
        this.numOfLegs = numOfLegs;
    }

    public String getName() {
        return name;
    }

    public int getNumOfLegs() {
        return numOfLegs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumOfLegs(int numOfLegs) {
        this.numOfLegs = numOfLegs;
    }

    public void Move() {
        System.out.println("I can move!");
    }

    public void Eat() {
        System.out.println("I can eat!");
    }

    public void Eat(String food) {
        System.out.println("I can eat " + food + "!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return numOfLegs == animal.numOfLegs && Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numOfLegs);
    }
}
