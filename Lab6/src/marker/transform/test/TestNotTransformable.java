package marker.transform.test;

import marker.transform.NotTransformableException;
import marker.transform.Sofa;
import marker.transform.Transformer;

public class TestNotTransformable {
    public static void main(String[] args) {
        Sofa sofa = new Sofa("Red", 5);
        Transformer transformer = new Transformer();

        try {
            transformer.transform(sofa);
        } catch (NotTransformableException e) {
            System.err.println(e.getMessage());
        }
    }
}

