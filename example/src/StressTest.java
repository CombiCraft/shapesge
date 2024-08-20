import fri.shapesge.Image;
import fri.shapesge.Manager;

import java.util.ArrayList;
import java.util.Random;

public class StressTest {
    public static void main(String[] args) {
        new StressTest();
    }

    ArrayList<Image> images = new ArrayList<>();

    public StressTest() {
        new Manager().manageObject(this);
    }

    public void tick() {
        var e = new Image("arrow.png");
        this.images.add(e);
        e.makeVisible();
        Random r = new Random();
        var image = this.images.get(this.images.size() - 1);
//        for (Image image : this.images) {
            image.changePosition(r.nextInt(1000), r.nextInt(1000));
            image.changeSize(r.nextInt(200) + 84, r.nextInt(100) + 78);
            image.changeAngle(r.nextInt(360));
            image.mirrorVertical();
            image.mirrorHorizontal();
//        }
    }
}
