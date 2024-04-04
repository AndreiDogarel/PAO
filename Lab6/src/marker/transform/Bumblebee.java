package marker.transform;

public class Bumblebee implements Transformable {
    private String color;
    private boolean friendly;

    public Bumblebee(String color, boolean friendly) {
        this.color = color;
        this.friendly = friendly;
    }

    @Override
    public String toString() {
        return "Bumblebee{" +
                "color='" + color + '\'' +
                ", friendly=" + friendly +
                '}';
    }
}

