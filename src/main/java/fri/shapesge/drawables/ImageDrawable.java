package fri.shapesge.drawables;

import fri.shapesge.engine.Game;

import java.awt.Graphics2D;
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
        /*
         * StackOverflow: "Resize image in Java without losing transparency"
         * asked Sep 23, 2012 at 11:55 by Nick Russler
         * answered Mar 27, 2021 at 21:30 by Larjak
         * https://stackoverflow.com/questions/12552144/resize-image-in-java-without-losing-transparency
         * Adapted for use with ShapesGE by trailblazercombi
         */
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(this.image, 0, 0, newWidth, newHeight, null);
        graphics2D.dispose();

        this.changeImage(resizedImage);
    }


    public void flipHorizontal(boolean mirrored) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void fripVertical(boolean mirrored) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
