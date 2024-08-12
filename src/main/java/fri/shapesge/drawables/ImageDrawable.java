package fri.shapesge.drawables;

import fri.shapesge.engine.Game;
import fri.shapesge.engine.ShapesGEException;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class ImageDrawable extends TranslatableDrawable {
    private BufferedImage image;
    private BufferedImage original;

    private boolean mirroredHorizontal = false;
    private boolean mirroredVertical = false;

    public ImageDrawable(int x, int y, int angle, BufferedImage image) {
        super(x, y, angle);
        this.image = image;
        this.original = image;
    }

    public void changeImage(BufferedImage image, boolean preserveParameters) {

        // Grabbing parameters of the old image
        int sizeX = this.getWidth();
        int sizeY = this.getHeight();
        boolean flipHorizontal = this.mirroredHorizontal;
        boolean flipVertical = this.mirroredVertical;

        this.image = image;
        this.original = this.image;

        if (!preserveParameters) {
            // Reset the parameters...
            sizeX = this.getWidth();
            sizeY = this.getHeight();
            flipHorizontal = false;
            flipVertical = false;
            this.changeAngle(0);
        }

        this.updateImage(sizeX, sizeY, flipHorizontal, flipVertical);
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

    public void flipHorizontal(boolean mirrorParameter) {
        this.updateImage(this.getWidth(), this.getHeight(), mirrorParameter, this.mirroredVertical);
    }

    public void flipHorizontal() {
        this.flipHorizontal(!this.mirroredHorizontal);
    }

    public void flipVertical(boolean mirrorParameter) {
        this.updateImage(this.getWidth(), this.getHeight(), this.mirroredHorizontal, mirrorParameter);
    }

    public void flipVertical() {
        this.flipVertical(!this.mirroredVertical);
    }

    public void changeSize(int newWidth, int newHeight) {
        if (newWidth < 0 || newHeight < 0) {
            throw new ShapesGEException("Image size cannot be 0 or negative!");
        }
        this.updateImage(newWidth, newHeight, this.mirroredHorizontal, this.mirroredVertical);
    }

    @SuppressWarnings("SpellCheckingInspection")
    private void updateImage(int newWidth, int newHeight, boolean mirroredHorizontal, boolean mirroredVertical) {
        this.mirroredHorizontal = mirroredHorizontal;
        this.mirroredVertical = mirroredVertical;

        int startX, startY, width, height;

        if (this.mirroredHorizontal) {
            startX = newWidth;
            width = -newWidth;
        } else {
            startX = 0;
            width = newWidth;
        }

        if (this.mirroredVertical) {
            startY = newHeight;
            height = -newHeight;
        } else {
            startY = 0;
            height = newHeight;
        }

        /*
         * StackOverflow: "Resize image in Java without losing transparency"
         * asked Sep 23, 2012 at 11:55 by Nick Russler
         * answered Mar 27, 2021 at 21:30 by Larjak
         * https://stackoverflow.com/questions/12552144/resize-image-in-java-without-losing-transparency
         *
         * StackOverflow: "Flip image with Graphics2D"
         * asked Mar 4, 2012 at 21:30 by Fuze && edited Jun 26, 2018 at 2:58 by Neuron
         * answered Nov 11, 2013 at 17:44 by hsirkar && edited Feb 14, 2017 at 6:46 by samgak
         * https://stackoverflow.com/questions/9558981/flip-image-with-graphics2d
         *
         * Adapted for use with ShapesGE by trailblazercombi
         */

        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(this.original, startX, startY, width, height, null);
        graphics2D.dispose();

        this.image = resizedImage;
    }
}
