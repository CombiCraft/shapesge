package fri.shapesge;

import fri.shapesge.drawables.EllipticalDrawable;

import java.awt.Color;

/**
 * Circle is a circle drawn on the game's window (the Canvas).
 *
 * @author original: Michael Kölling and David J. Barnes
 * @author engine: Ján Janech
 * @version 1.0  (9.11.2022)
 */

@SuppressWarnings("unused")
public class Circle {
    private final EllipticalDrawable drawable;

    /**
     * Create a new Circle on the default position with default parameters.
     * <p>
     *     Default parameters:
     *     <ul>
     *         <li>Diameter: 30 pixels</li>
     *         <li>Position X: 20 pixels from the left border of the canvas</li>
     *         <li>Position Y: 60 pixels from the top border of the canvas</li>
     *         <li>Color: blue</li>
     *     </ul>
     *     <p>
     *          You can change the position, size and color later using the {@link Circle#changePosition(int x, int y)},
     *          {@link Circle#changeSize(int newDiameter)} and {@link Circle#changeColor} methods.
     *     </p>
     * </p>
     */
    @SuppressWarnings("unused")
    public Circle() {
        this(20, 60);
    }

    /**
     * Create a new Circle on the given position with default parameters.
     * <p>
     *     Default parameters:
     *     <ul>
     *         <li>Diameter: 30 pixels</li>
     *         <li>Color: blue</li>
     *     </ul>
     *     <p>
     *          You can change the position, size and color later using the {@link Circle#changePosition(int x, int y)},
     *          {@link Circle#changeSize(int newDiameter)} and {@link Circle#changeColor} methods.
     *     </p>
     * </p>
     */
    @SuppressWarnings("unused")
    public Circle(int x, int y) {
        this.drawable = new EllipticalDrawable(x, y, 30, 30, Color.blue);
    }

    /**
     * Make this circle visible. If it was already visible, do nothing.
     * @implNote If you have multiple shapes on top of each other (overlapping),
     * the shapes will be displayed in the order you send this message in.
     * <p>
     *     For example, if you need to place a {@link Circle} on top of a {@link Square}, do this:
     *     <blockquote><pre>
     *         yourRectangle.makeVisible();
     *         yourImage.makeVisible();
     *     </pre></blockquote>
     *     If you swap these two lines, <b>the {@link Circle} will be hidden behind the {@link Square} .</b>
     * </p>
     */
    @SuppressWarnings("unused")
    public void makeVisible() {
        this.drawable.makeVisible();
    }

    /**
     * Make this circle invisible. If it was already invisible, do nothing.
     */
    @SuppressWarnings("unused")
    public void makeInvisible() {
        this.drawable.makeInvisible();
    }

    /**
     * Move the circle a few pixels to the right.
     */
    @SuppressWarnings("unused")
    public void moveRight() {
        this.drawable.moveBy(20, 0);
    }

    /**
     * Move the circle a few pixels to the left.
     * This method always moves the shape by 20 pixels.
     */
    @SuppressWarnings("unused")
    public void moveLeft() {
        this.drawable.moveBy(-20, 0);
    }

    /**
     * Move the circle a few pixels up.
     * This method always moves the shape by 20 pixels.
     */
    @SuppressWarnings("unused")
    public void moveUp() {
        this.drawable.moveBy(0, -20);
    }

    /**
     * Move the circle a few pixels down.
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
     * @param newDiameter the new width and height of the shape.
     *                The size cannot be lower than 0 ({@code newDiameter < 0}).
     */
    @SuppressWarnings("unused")
    public void changeSize(int newDiameter) {
        this.drawable.changeSize(newDiameter, newDiameter);
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
     * @param x x-coordinate of the circle
     *          (distance from left border of the canvas)
     * @param y y-coordinate of the circle
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
     * @return the diameter (width) of the shape in <b>pixels</b>.
     */
    public int getDiameter() {
        return this.drawable.getDiameterX();
    }
}
