package fri.shapesge;

import fri.shapesge.drawables.ImageDrawable;

/**
 * Image is an image drawn on the game's window (the Canvas).
 * It can load and display PNG and JPEG, including transparency (alpha channel).
 * To load the image, use the <b>absolute or relative file path</b> of your image as {@link String}.
 * <br><br>
 * <h3>How to use the absolute file path</h3>
 * <p>This is the full system path, starting at the system root.</p>
 * <p>
 *     <b>On Windows:</b>
 *     <ol>
 *         <p>The absolute file path starts from your drive letter (e.g. {@code C:\})</p>
 *         <li>Find the image in <b>File Explorer</b> (📁)</li>
 *         <li>Right click the image</li>
 *         <li>Select <b>Copy as path</b></li>
 *     </ol>
 *     <b>On MacOS:</b>
 *     <ol>
 *         <p>The absolute file path starts from the <i>root directory</i>. ({@code /})</p>
 *         <li>Find the image in <b>Finder</b></li>
 *         <li>Right click the image</li>
 *         <li>Hold down the <b>OPTION</b> key</li>
 *         <li>Select <b>Copy as Filepath</b></li>
 *     </ol>
 *     <b>On Linux:</b>
 *     <ul>
 *         <p>The absolute file path starts from the <i>root directory</i>. ({@code /})
 *         Please consult <b>your distro Help page</b> for specific steps.</p>
 *     </ul>
 * </p>
 * <b><u>IMPORTANT NOTE:</u></b> Do not use Absolute file path for serious projects (including semester works).
 * If you have to open the project on a different computer, it won't be able to find any files!
 * Instead, please use the Relative File Path when possible.
 * <br><br>
 * <h3>How to use the relative file path</h3>
 * <p>This is the file path relative to your project's folder.</p>
 * <p>
 *     <b>In BlueJ:</b>
 *     <ol>
 *         <li>Copy and paste the image file to your project's folder</li>
 *         <li>Use just the file name, no path needed (e.g. {@code "image.png"})
 *         (the path is <b>relative</b> to the project folder)</li>
 *         <p>You can also put these files into folders in your project. If you do that, use {@code "folder/image.png"}.</p>
 *     </ol>
 *     <b>In IntelliJ IDEA:</b>
 *     <ol>
 *         <li>Right click on your <b>Project pane</b> (on the left)</li>
 *         <li>Select <b>New -> Directory</b>, name it and press ENTER</li>
 *         <li>Right click the new folder</li>
 *         <li>Select <b>Mark Directory as -> Resources root</b></li>
 *         <li>Copy and paste the image file to this folder</li>
 *         <li>Use just the file name, no path needed (e.g. {@code "image.png"})
 *         (the path is <b>relative</b> to the Resources folder)</li>
 *         <p>You can also put these files into folders in your project. If you do that, use {@code "folder/image.png"}.</p>
 *         <p>You can also use Java's implementation of Resources to load and process your Images.</p>
 *     </ol>
 * </p>
 *
 * @author original: Miroslav Kvaššay and Michal Varga
 * @author engine: Ján Janech
 * @author version 2.0: trailblazercombi
 * @version 2.0  (August 2024)
 */
@SuppressWarnings("unused")
public class Image {
    private final ImageDrawable drawable;

    /**
     * Create a new image on the default position.
     * <p>
     * Default position:
     * <ul>
     * <li>Position X: 0 pixels from the left border of the canvas</li>
     * <li>Position Y: 20 pixels from the top border of the canvas</li>
     * </p>
     * @param imagePath the <b>absolute or relative file path</b> to the image as {@link String}
     *                  <p>(e.g. {@code "C:\folder\image.png"}, {@code "folder/image.png"}).</p>
     * @throws fri.shapesge.engine.ShapesGEException if the file doesn't exist on that path
     */
    @SuppressWarnings("unused")
    public Image(String imagePath) {
        this(new DataObrazku(imagePath));
    }

    /**
     * Create a new image on the default position.
     * <p>
     * Default position:
     * <ul>
     * <li>Position X: 0 pixels from the left border of the canvas</li>
     * <li>Position Y: 20 pixels from the top border of the canvas</li>
     * </p>
     * @param imageData the {@link DataObrazku} for this image.
     *                  <p>Use this method if you created {@link DataObrazku} manually.</p>
     */
    @SuppressWarnings("unused")
    public Image(DataObrazku imageData) {
        this(imageData, 100, 100);
    }

    /**
     * Create a new image on the given position.
     *
     * @param imagePath the <b>absolute or relative file path</b> to the image as {@link String}
     *                  <p>(e.g. {@code "C:\folder\image.png"}, {@code "folder/image.png"}).</p>
     * @param x x-coordinate of the image
     *          (distance from left border of the canvas)
     * @param y y-coordinate of the image
     *          (distance from top border of the canvas)
     * @throws fri.shapesge.engine.ShapesGEException if the file doesn't exist on that path
     */
    @SuppressWarnings("unused")
    public Image(String imagePath, int x, int y) {
        this(new DataObrazku(imagePath), x, y);
    }

    /**
     * Create a new image on the given position.
     *
     * @param imageData the {@link DataObrazku} for this image.
     *                  <p>Use this method if you created {@link DataObrazku} manually.</p>
     * @param x x-coordinate of the image
     *          (distance from left border of the canvas)
     * @param y y-coordinate of the image
     *          (distance from top border of the canvas)
     */
    public Image(DataObrazku imageData, int x, int y) {
        this.drawable = new ImageDrawable(x, y, 0, imageData.getImage());
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
     * Make this image invisible.
     * If it was already invisible, do nothing.
     */
    @SuppressWarnings("unused")
    public void makeInvisible() {
        this.drawable.makeInvisible();
    }

    /**
     * Move the image a few pixels to the right.
     * This method always moves the shape by 20 pixels.
     */
    @SuppressWarnings("unused")
    public void moveRight() {
        this.drawable.moveBy(20, 0);
    }

    /**
     * Move the image a few pixels to the left.
     * This method always moves the shape by 20 pixels.
     */
    @SuppressWarnings("unused")
    public void moveLeft() {
        this.drawable.moveBy(-20, 0);
    }

    /**
     * Move the image a few pixels up.
     * This method always moves the shape by 20 pixels.
     */
    @SuppressWarnings("unused")
    public void moveUp() {
        this.drawable.moveBy(0, -20);
    }

    /**
     * Move the image a few pixels down.
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
     * Change the drawn image.
     * @param imagePath the <b>absolute or relative file path</b> to the image as {@link String}
     *                  <p>(e.g. {@code "C:\folder\image.png"}, {@code "folder/image.png"}).</p>
     *                  <p>See the {@link Image} class description for more information.</p>
     * @throws fri.shapesge.engine.ShapesGEException if the file doesn't exist on that path
     * @implNote This method will draw the new Image in its original size and mirroring.
     *           <p>If you need to preserve the size and mirroring across the changes, use {@link Image#changeImageAndPreserveParameters(String)}.</p>
     */
    @SuppressWarnings("unused")
    public void changeImage(String imagePath) {
        this.changeImage(new DataObrazku(imagePath));
    }

    /**
     * Change the drawn image.
     * @param imagePath the <b>absolute or relative file path</b> to the image as {@link String}
     *                  <p>(e.g. {@code "C:\folder\image.png"}, {@code "folder/image.png"}).</p>
     *                  <p>See the {@link Image} class description for more information.</p>
     * @throws fri.shapesge.engine.ShapesGEException if the file doesn't exist on that path
     * @implNote This method will draw the new Image in the same size and mirroring as the current one.
     *           <p>If you need to always get the original, use {@link Image#changeImage(String)}.</p>
     */
    public void changeImageAndPreserveParameters(String imagePath) {
        this.changeImageAndPreserveParameters(new DataObrazku(imagePath));
    }

    /**
     * Change the drawn image.
     * @param imageData the {@link DataObrazku} for this image.
     *                  <p>Use this method if you created {@link DataObrazku} manually.</p>
     */
    @SuppressWarnings("unused")
    public void changeImage(DataObrazku imageData) {
        this.drawable.changeImage(imageData.getImage(), false);
    }

    public void changeImageAndPreserveParameters(DataObrazku imageData) {
        this.drawable.changeImage(imageData.getImage(),true);
    }

    /**
     * Change the image rotation angle according to the parameter.
     * @param angle the angle in <b>degrees</b> clockwise.
     *              The angle ranges from 0 to 360 (same as on e.g. a compass).
     *              <ul>
     *                  <li> ↑ {@code angle == 0} sets the image to point upwards.</li>
     *                  <li> → {@code angle == 90} sets the image to point to the right.</li>
     *                  <li> ↓ {@code angle == 180} sets the image to point downwards.</li>
     *                  <li> ← {@code angle == 270} sets the image to point to the left.</li>
     *              </ul>
     * @implNote When rotating the Image, it'll be rotated around its center.
     */
    @SuppressWarnings("unused")
    public void changeAngle(int angle) {
        this.drawable.changeAngle(angle);
    }

    /**
     * Change the position according to the parameters.
     * <p>This will set the position of the top left corner of the shape.</p>
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
     * Resize the image.
     * The image will still be anchored from the top left, and rotated around its center.
     * @param newWidth the new width of the shape.
     *                The width cannot be lower than 0 ({@code newWidth < 0}).
     * @param newHeight the new height of the shape.
     *                The height cannot be lower than 0 ({@code newHeight < 0}).
     */
    public void changeSize(int newWidth, int newHeight) {
        this.drawable.changeSize(newWidth, newHeight);
    }

    /**
     * Mirror the image horizontally.
     * @param mirrored Use {@code true} to make the image mirrored. Use {@code false} to get the original orientation.
     */
    public void mirrorHorizontal(boolean mirrored) {
        this.drawable.flipHorizontal(mirrored);
    }

    /**
     * Mirror the image horizontally.
     * This method will always mirror the image, regardless of its current orientation.
     */
    public void mirrorHorizontal() {
        this.drawable.flipHorizontal();
    }

    /**
     * Mirror the image vertically.
     * @param mirrored Use {@code true} to make the image mirrored. Use {@code false} to get the original orientation.
     */
    public void mirrorVertical(boolean mirrored) {
        this.drawable.flipVertical(mirrored);
    }

    /**
     * Mirror the image vertically.
     * This method will always mirror the image, regardless of its current orientation.
     */
    public void mirrorVertical() {
        this.drawable.flipVertical();
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
        return this.drawable.getWidth();
    }

    /**
     * @return the height of the shape in <b>pixels</b>.
     */
    public int getHeight() {
        return this.drawable.getHeight();
    }

    /**
     * @return the angle of the shape in <b>degrees</b>.
     */
    public int getAngle() {
        return this.drawable.getAngle();
    }
}
