package marker.transform.test;

import marker.transform.Bumblebee;
import marker.transform.NotTransformableException;
import marker.transform.Transformer;

public class TestTransformable {
    public static void main(String[] args) {
        Bumblebee bumblebee = new Bumblebee("Yellow", true);
        Transformer transformer = new Transformer();

        try {
            transformer.transform(bumblebee);
        } catch (NotTransformableException e) {
            System.err.println(e.getMessage());
        }
    }
}

