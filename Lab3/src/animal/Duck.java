package animal;

import java.util.Objects;

public class Duck extends Bird {
    private int length;

    public Duck(String name, int numOfLegs, String colour, int length) {
        super(name, numOfLegs, colour);
        this.length = length;
    }

    @Override
    public void Move() {
        System.out.println("I can swim!");
    }

    @Override
    public void Sing() {
        System.out.println("I can quack!");
    }

    @Override
    public int hashCode() {
        return Objects.hash(length);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        Duck duck = (Duck) obj;
        if(this.length != duck.length){
            return false;
        }
        return true;
    }
}
