package animal;

import java.util.Objects;

public class Bird extends Animal {
    private String colour;

    public Bird(String name, int numOfLegs, String colour) {
        super(name, numOfLegs);
        this.colour = colour;
    }

    @Override
    public void Move() {
        System.out.println("I can fly!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bird bird = (Bird) o;
        return Objects.equals(colour, bird.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colour);
    }

    public void Sing() {
        System.out.println("I can chirp!");
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
