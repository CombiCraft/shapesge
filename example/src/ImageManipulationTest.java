import fri.shapesge.Obrazok;
import fri.shapesge.Manazer;

public class ImageManipulationTest {
    public static void main(String[] args) {
        new ImageManipulationTest();
    }

    int step = 0;
    Obrazok image = new Obrazok("test.jpg");

    public ImageManipulationTest() {
        this.image.makeVisible();
        new Manazer().spravujObjekt(this);
    }

    public void step() {
        this.step++;
        switch (this.step) {
            case 1:
                this.image.changeSize(25, 100);
                break;
            case 2:
                this.image.zmenObrazokAZachovajParametre("arrow.png");
                break;
            case 3:
                this.image.zmenUhol(275);
                this.image.obratVodorovne(true);
                break;
            case 4: this.image.zmenObrazok("test.jpg");
                break;
            default:
                System.exit(404);
        }
    }
}
