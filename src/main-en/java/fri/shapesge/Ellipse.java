package fri.shapesge;

import fri.shapesge.drawables.EllipticalDrawable;

import java.awt.Color;

/**
 * A ellipse that can be manipulated and that draws itself on a canvas.
 *
 * @author original: Michael Kölling and David J. Barnes
 * @author engine: Ján Janech
 * @version 1.1 (July 2024)
 */

@SuppressWarnings("unused")
public class Ellipse {
    private final EllipticalDrawable drawable;

    /**
     * Create a new Ellipse on the default position with default parameters.
     * <p>
     *     Default parameters:
     *     <ul>
     *         <li>Width: 60 pixels</li>
     *         <li>Height: 30 pixels</li>
     *         <li>Position X: 20 pixels from the left border of the canvas</li>
     *         <li>Position Y: 60 pixels from the top border of the canvas</li>
     *         <li>Color: blue</li>
     *     </ul>
     *     <p>
     *          You can change the position, size and color later using the {@link Ellipse#changePosition(int x, int y)},
     *          {@link Ellipse#changeSize(int width, int height)} and {@link Ellipse#changeColor(String)} methods.
     *     </p>
     * </p>
     */
    @SuppressWarnings("unused")
    public Ellipse() {
        this(20, 60);
    }

    /**
     * Create a new Ellipse on the given position with default parameters.
     * <p>
     *     Default parameters:
     *     <ul>
     *         <li>Width: 60 pixels</li>
     *         <li>Height: 30 pixels</li>
     *         <li>Color: blue</li>
     *     </ul>
     *     <p>
     *          You can change the position, size and color later using the {@link Ellipse#changePosition(int x, int y)},
     *          {@link Ellipse#changeSize(int width, int height)} and {@link Ellipse#changeColor(String)} methods.
     *     </p>
     * </p>
     * @param x x-coordinate of the shape's top left corner
     *          (distance from the left border of the canvas)
     * @param y y-coordinate of the shape's top left corner
     *          (distance from the top border of the canvas)
     */
    @SuppressWarnings("unused")
    public Ellipse(int x, int y) {
        this.drawable = new EllipticalDrawable(x, y, 60, 30, Color.blue);
    }

    /**
     * Make this shape visible. If it was already visible, do nothing.
     * @implNote If you have multiple shapes on top of each other (overlapping),
     * the shapes will be displayed in the order you send this message in.
     * <p>
     *     For example, if you need to place a {@link Circle} on top of a {@link Square}, do this:
     *     <blockquote><pre>
     *         yourSquare.makeVisible();
     *         yourCircle.makeVisible();
     *     </pre></blockquote>
     *     If you swap these two lines, <b>the {@link Circle} will be hidden behind the {@link Square} .</b>
     * </p>
     */
    @SuppressWarnings("unused")
    public void makeVisible() {
        this.drawable.makeVisible();
    }

    /**
     * Make this ellipse invisible. If it was already invisible, do nothing.
     */
    @SuppressWarnings("unused")
    public void makeInvisible() {
        this.drawable.makeInvisible();
    }

    /**
     * Move the ellipse a few pixels to the right.
     * This method always moves the shape by 20 pixels.
     */
    @SuppressWarnings("unused")
    public void moveRight() {
        this.drawable.moveBy(20, 0);
    }

    /**
     * Move the ellipse a few pixels to the left.
     * This method always moves the shape by 20 pixels.
     */
    @SuppressWarnings("unused")
    public void moveLeft() {
        this.drawable.moveBy(-20, 0);
    }

    /**
     * Move the ellipse a few pixels up.
     * This method always moves the shape by 20 pixels.
     */
    @SuppressWarnings("unused")
    public void moveUp() {
        this.drawable.moveBy(0, -20);
    }

    /**
     * Move the ellipse a few pixels down.
     * This method always moves the shape by 20 pixels.
     */
    @SuppressWarnings("unused")
    public void moveDown() {
        this.drawable.moveBy(0, 20);
    }

    /**
     * Move the shape horizontally by a given amount of pixels.
     * @param distance how many <b>pixels</b> to move the object.
     * Positive numbers ({@code distance > 0}) move the shape to the right.
     * Negative numbers ({@code distance < 0}) move the shape to the left.
     * Zero ({@code distance == 0} does not move the shape at all.
     */
    @SuppressWarnings("unused")
    public void moveHorizontal(int distance) {
        this.drawable.moveBy(distance, 0);
    }

    /**
     * Move the shape vertically by a given amount of pixels.
     * @param distance how many <b>pixels</b> to move the object.
     * Positive numbers ({@code distance > 0}) move the shape down.
     * Negative numbers ({@code distance < 0}) move the shape up.
     * Zero ({@code distance == 0} does not move the shape at all.
     */
    @SuppressWarnings("unused")
    public void moveVertical(int distance) {
        this.drawable.moveBy(0, distance);
    }

    /**
     * Resize the shape.
     * @param newWidth the new width of the shape.
     *                The width cannot be lower than 0 ({@code newWidth < 0}).
     * @param newHeight the new height of the shape.
     *                The height cannot be lower than 0 ({@code newHeight < 0}).
     */
    @SuppressWarnings("unused")
    public void changeSize(int newWidth, int newHeight) {
        this.drawable.changeSize(newWidth, newHeight);
    }

    /**
     * Change the color of the shape.
     * @param newColor new color from <b>Colors in sbge.ini</b> or in <b>plain #rrggbb format</b> as {@link String} (e.g. {@code "blue"}, {@code "yellow"}, {@code "#ba9000"}).
     *                 <h3>Colors in sbge.ini:</h3>
     *                 <p>The default supported colors are {@code "red"}, {@code "blue"}, {@code "yellow"}, {@code "green"}, {@code "magenta"}, {@code "white"}, {@code "brown"} and {@code "black"}</p>
     *                 <p>Visit <a href="https://github.com/infjava/shapesge/wiki">ShapesGE Wiki on GitHub</a> to learn more.</p>
     *                 <h3>Plain #rrggbb:</h3>
     *                 <p>
     *                     This is a HEX color code. To find this code for your desired color, use an online HEX color picker tool
     *                     (on e.g. <a href="https://g.co/kgs/RmaEk8D">Google</a>, <a href="https://www.bing.com/search?q=hex+color+picker">Bing</a>, etc.)
     *                 </p>
     */
    @SuppressWarnings("unused")
    public void changeColor(String newColor) {
        this.drawable.changeColor(newColor);
    }

    /**
     * Change the position according to the parameters.
     * @param x x-coordinate of the ellipse
     *          (distance from left border of the canvas)
     * @param y y-coordinate of the ellipse
     *          (distance from top border of the canvas)
     */
    @SuppressWarnings("unused")
    public void changePosition(int x, int y) {
        this.drawable.moveTo(x, y);
    }

    /**
     * @return the x-coordinate of the shape's top left corner.
     * <p>The x-coordinate is the distance (in pixels) from the <b>left border</b> of the game window.</p>
     */
    public int getPositionX() {
        return this.drawable.getXPosition();
    }

    /**
     * @return the y-coordinate of the shape's top left corner.
     * <p>The y-coordinate is the distance (in pixels) from the <b>top border</b> of the game window.</p>
     */
    public int getPositionY() {
        return this.drawable.getYPosition();
    }

    /**
     * @return the width of the shape in <b>pixels</b>.
     */
    public int getWidth() {
        return this.drawable.getDiameterX();
    }

    /**
     * @return the height of the shape in <b>pixels</b>.
     */
    public int getHeight() {
        return this.drawable.getDiameterY();
    }
}
