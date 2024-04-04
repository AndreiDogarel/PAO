package marker.transform;

public class Sofa {
    private String colour;
    private int age;

    public Sofa(String colour, int age) {
        this.colour = colour;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Sofa{" +
                "colour='" + colour + '\'' +
                ", age=" + age +
                '}';
    }
}

