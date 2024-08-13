import fri.shapesge.Image;
import fri.shapesge.Manazer;

public class ImageManipulationTest {
    public static void main(String[] args) {
        new ImageManipulationTest();
    }

    int step = 0;
    Image image = new Image("test.jpg");

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
                this.image.changeImageAndPreserveParameters("arrow.png");
                break;
            case 3:
                this.image.changeAngle(275);
                this.image.mirrorHorizontal(true);
                break;
            case 4: this.image.changeImage("test.jpg");
                break;
            default:
                System.exit(404);
        }
    }
}
