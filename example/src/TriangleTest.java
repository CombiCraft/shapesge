import fri.shapesge.*;

public class TriangleTest {
    public static void main(String[] args) {
        var tri = new Trojuholnik();
        tri.changePosition(300, 300);
        tri.makeVisible();
        tri.changeSize(-50, 50);
//        new Square(500, 500).makeVisible();
//        new Rectangle().makeVisible();
//        new Circle().makeVisible();
//        new Ellipse().makeVisible();
        new Obrazok("test.jpg").changeSize(-30, 45);
    }
}
