import Transforms.Rotation;

public class Main {

    public static void main(String[] args) throws Exception {
        Rotation r = new Rotation(45);
        System.out.println(r.getMatrix());
        Rotation r2 = new Rotation(45, 5, 10);
        System.out.println(r2.getMatrix());
    }
}
