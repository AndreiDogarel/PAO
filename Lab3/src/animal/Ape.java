package animal;

import java.util.Objects;

public class Ape extends Animal {
    private String size;

    public Ape(String name, int numOfLegs, String size) {
        super(name, numOfLegs);
        this.size = size;
    }

    @Override
    public void Move() {
        System.out.println("I can jump!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ape ape = (Ape) o;
        return Objects.equals(size, ape.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
