package fri.shapesge;

import fri.shapesge.drawables.TriangularDrawable;

import java.awt.*;

/**
 * Triangle is an Isosceles triangle (<b>Δ</b>) drawn on the game's window (the Canvas).
 * This triangle consists of a horizontal base and two equally long sides, with the tip pointing upwards.
 * <p>
 *     <u>IMPORTANT NOTE:</u> Unlike other shapes, the position of Triangle is calculated based on the
 *     tip rather than the top left corner.
 * </p>
 *
 * @author original: Michael Kölling and David J. Barnes
 * @author engine: Ján Janech
 * @version 1.1  (July 2024)
 */

@SuppressWarnings("unused")
public class Triangle {
    private final TriangularDrawable drawable;

    /**
     * Create a new Triangle on the default position with default parameters.
     * <p>
     *     Default parameters:
     *     <ul>
     *         <li>Width: 40 pixels</li>
     *         <li>Height: 30 pixels</li>
     *         <li>Position X: 50 pixels from the left border of the canvas</li>
     *         <li>Position Y: 15 pixels from the top border of the canvas</li>
     *         <li>Color: green</li>
     *     </ul>
     *     <p>
     *          You can change the position and size later using the {@link Triangle#changePosition(int x, int y)}
     *          and {@link Triangle#changeSize(int width, int height)} methods.
     *     </p>
     * </p>
     */
    @SuppressWarnings("unused")
    public Triangle() {
        this(50, 15);
    }

    /**
     * Create a new Triangle on the given position with default parameters.
     * <p>
     *     Default parameters:
     *     <ul>
     *         <li>Width: 40 pixels</li>
     *         <li>Height: 30 pixels</li>
     *         <li>Color: green</li>
     *     </ul>
     * </p>
     * @param x x-coordinate of the shape's tip
     *          (distance from the left border of the canvas)
     * @param y y-coordinate of the shape's tip
     *          (distance from the top border of the canvas)
     */
    @SuppressWarnings("unused")
    public Triangle(int x, int y) {
        this.drawable = new TriangularDrawable(x, y, 40, 30, Color.green);
    }

    /**
     * Make this image visible. If it was already visible, do nothing.
     * @implNote If you have multiple shapes on top of each other (overlapping),
     * the shapes will be displayed in the order you send this message in.
     * <p>
     *     For example, if you need to place a {@link Circle} on top of a {@link Stvorec}, do this:
     *     <blockquote><pre>
     *         yourSquare.makeVisible();
     *         yourCircle.makeVisible();
     *     </pre></blockquote>
     *     If you swap these two lines, <b>the {@link Circle} will be hidden behind the {@link Stvorec} .</b>
     * </p>
     */
    @SuppressWarnings("unused")
    public void makeVisible() {
        this.drawable.makeVisible();
    }

    /**
     * Make this triangle invisible. If it was already invisible, do nothing.
     */
    @SuppressWarnings("unused")
    public void makeInvisible() {
        this.drawable.makeInvisible();
    }

    /**
     * Move the triangle a few pixels to the right.
     * This method always moves the shape by 20 pixels.
     */
    @SuppressWarnings("unused")
    public void moveRight() {
        this.drawable.moveBy(20, 0);
    }

    /**
     * Move the triangle a few pixels to the left.
     * This method always moves the shape by 20 pixels.
     */
    @SuppressWarnings("unused")
    public void moveLeft() {
        this.drawable.moveBy(-20, 0);
    }

    /**
     * Move the triangle a few pixels up.
     * This method always moves the shape by 20 pixels.
     */
    @SuppressWarnings("unused")
    public void moveUp() {
        this.drawable.moveBy(0, -20);
    }

    /**
     * Move the triangle a few pixels down.
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
     * @param newWidth the new width of the image.
     * @param newHeight the new height of the image.
     * @implNote It is possible to flip Triangles upside down by setting {@code newHeight} lower than 0.
     */
    @SuppressWarnings("unused")
    public void changeSize(int newHeight, int newWidth) {
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
     * <p>This will set the position of the tip of the Triangle.</p>
     * @param x x-coordinate of the shape
     *          (distance from left border of the game window)
     * @param y y-coordinate of the shape
     *          (distance from top border of the game window)
     */
    @SuppressWarnings("unused")
    public void changePosition(int x, int y) {
        this.drawable.moveTo(x, y);
    }

    /**
     * @return the x-coordinate of the triangle's tip.
     * <p>The x-coordinate is the distance (in pixels) from the <b>left border</b> of the game window.</p>
     */
    public int getPositionX() {
        return this.drawable.getXPosition();
    }

    /**
     * @return the y-coordinate of the triangle's tip.
     * <p>The y-coordinate is the distance (in pixels) from the <b>top border</b> of the game window.</p>
     */
    public int getPositionY() {
        return this.drawable.getYPosition();
    }

    /**
     * @return the width of the shape in <b>pixels</b>.
     */
    public int getWidth() {
        return this.drawable.getWidth();
    }

    /**
     * @return the height of the shape in <b>pixels</b>.
     */
    public int getHeight() {
        return this.drawable.getHeight();
    }
}
