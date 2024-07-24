package fri.shapesge.drawables;

import fri.shapesge.engine.Game;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class ImageDrawable extends TranslatableDrawable {
    private BufferedImage image;

    public ImageDrawable(int x, int y, int angle, BufferedImage image) {
        super(x, y, angle);
        this.image = image;
    }

    public void changeImage(BufferedImage image) {
        this.image = image;

        Game.getGame().somethingHasChanged();
    }

    @Override
    protected Point2D.Double getCenter() {
        double centerX = this.image.getWidth() / 2.0;
        double centerY = this.image.getHeight() / 2.0;
        return new Point2D.Double(centerX, centerY);
    }

    @Override
    public void draw(Graphics2D canvas) {
        if (!this.isVisible()) {
            return;
        }

        canvas.drawImage(this.image, this.getTransform(), null);
    }

    public int getWidth() {
        return this.image.getWidth();
    }

    public int getHeight() {
        return this.image.getHeight();
    }

    public void changeSize(int newWidth, int newHeight) {
        throw new RuntimeException("Not yet implemented!");
//        int origWidth = this.image.getWidth();
//        int origHeight = this.image.getHeight();
//
//        int scaleWidth = newWidth / origWidth;
//        int scaleHeight = newHeight / origHeight;
//
//        var transform = new AffineTransform();
//        transform.scale(scaleWidth, scaleHeight);
//
//        var newImage = new BufferedImage(newWidth, newHeight, this.image.getType());
//
//        var g2d = newImage.createGraphics();
//        g2d.drawImage(this.image, transform, null);
//        g2d.dispose();
//
////        this.image = newImage;
//
//        Game.getGame().somethingHasChanged();
    }

    public void flipHorizontal(boolean mirrored) {

    }

    public void fripVertical(boolean mirrored) {

    }
}
