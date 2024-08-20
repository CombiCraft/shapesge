import fri.shapesge.Obrazok;
import fri.shapesge.Manazer;

import java.util.ArrayList;
import java.util.Random;

public class StressTest {
    public static void main(String[] args) {
        new StressTest();
    }

    ArrayList<Obrazok> images = new ArrayList<>();

    public StressTest() {
        new Manazer().spravujObjekt(this);
    }

    public void tick() {
        Obrazok e = new Obrazok("arrow.png");
        this.images.add(e);
        e.makeVisible();
        Random r = new Random();
        var image = this.images.get(this.images.size() - 1);
//        for (Image image : this.images) {
            image.changePosition(r.nextInt(1000), r.nextInt(1000));
            image.changeSize(r.nextInt(200) + 84, r.nextInt(100) + 78);
            image.zmenUhol(r.nextInt(360));
            image.obratZvisle();
            image.obratZvisle();
//        }
    }
}
