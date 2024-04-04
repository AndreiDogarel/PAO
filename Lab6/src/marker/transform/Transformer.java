package marker.transform;

public class Transformer {
    public void transform(Object object) throws NotTransformableException {
        if (!(object instanceof Transformable)) {
            throw new NotTransformableException("Object is not transformable.");
        }
        System.out.println(object + " has been transformed.");
    }
}
