package fri.shapesge;

import fri.shapesge.drawables.TextDrawable;

import java.awt.Color;
import java.awt.Font;
import java.util.EnumSet;

/**
 * Text Block is a block of text drawn on the game's window (the Canvas).
 * It makes use of {@link String} to display a single or multi-line text on screen.
 * <p>
 * By default, all text is single-line. To create a multi-line text block, add {@code \n}
 * to your text where appropriate (<b>with no spaces</b>, so "your<b>\n</b>text"), or use the {@link TextBlock#wrapText(int maxLength)} method to auto-wrap your text after
 * a given number of pixels.
 * </p>
 *
 * @author Ján Janech
 * @author trailblazercombi
 * @version 1.1  (July 2024)
 */

@SuppressWarnings("unused")
public class TextBlock {
    private final TextDrawable drawable;

    /**
     * Create a new TextBlock on the given position with default parameters.
     * <p>
     *     Default parameters:
     * <ul><li>
     *     Font: Serif
     * </li><li>
     *     Color: black
     * </li><li>
     *     Size: 12 pt (17 pixels high)
     * </li></ul>
     * </p>
     * <p>
     *     The text will be displayed at the given position,
     *     with the given position being the <b>top left corner</b>.
     * </p>
     * <p>
     *     You can change the position later using the {@link TextBlock#changePosition(int x, int y)} method.
     * </p>
     * @param text text to be displayed
     * @param x x-coordinate of the text
     *          (distance from the left border of the canvas)
     * @param y y-coordinate of the text
     *          (distance from the top border of the canvas)
     */
    @SuppressWarnings("unused")
    public TextBlock(String text, int x, int y) {
        this.drawable = new TextDrawable(x, y, Color.black, text, new Font(Font.SERIF, Font.PLAIN, 12));
    }

    /**
     * Create a new TextBlock at default position with default parameters.
     * <p>
     *     Default parameters:
     * <ul><li>
     *     Font: Serif
     * </li><li>
     *     Color: black
     * </li><li>
     *     Size: 12 pt (17 pixels high)
     * </li><li>
     *     Position X: 0 pixels from the left border of the canvas
     * </li><li>
     *     Position Y: 20 pixels from the top border of the canvas
     * </li></ul>
     * </p>
     * <p>
     *     You can change the position later using the {@link TextBlock#changePosition(int x, int y)} method.
     * </p>
     * @param text text to be displayed
     */
    @SuppressWarnings("unused")
    public TextBlock(String text) {
        this(text, 0, 20);
    }

    /**
     * Make this text visible.
     * If it was already visible, do nothing.
     * @implNote If you have multiple shapes on top of each other (overlapping),
     * the shapes will be displayed in the order you send this message in.
     * <p>
     *     For example, if you're creating a button that consists of a {@link Rectangle} and a label that's {@code TextBlock}, do this:
     *     <blockquote><pre>
     *         yourRectangle.makeVisible();
     *         yourTextBlock.makeVisible();
     *     </pre></blockquote>
     *     If you swap these two lines, <b>the text will be hidden below the rectangle.</b>
     * </p>
     */
    @SuppressWarnings("unused")
    public void makeVisible() {
        this.drawable.makeVisible();
    }

    /**
     * Make this text invisible.
     * If it was already invisible, do nothing.
     */
    @SuppressWarnings("unused")
    public void makeInvisible() {
        this.drawable.makeInvisible();
    }

    /**
     * Move the text a few pixels to the right.
     * This method always moves the shape by 20 pixels.
     */
    @SuppressWarnings("unused")
    public void moveRight() {
        this.drawable.moveBy(20, 0);
    }

    /**
     * Move the text a few pixels to the left.
     * This method always moves the shape by 20 pixels.
     */
    @SuppressWarnings("unused")
    public void moveLeft() {
        this.drawable.moveBy(-20, 0);
    }

    /**
     * Move the text a few pixels up.
     * This method always moves the shape by 20 pixels.
     */
    @SuppressWarnings("unused")
    public void moveUp() {
        this.drawable.moveBy(0, -20);
    }

    /**
     * Move the text a few pixels down.
     * This method always moves the shape by 20 pixels.
     */
    @SuppressWarnings("unused")
    public void moveDown() {
        this.drawable.moveBy(0, 20);
    }

    /**
     * Move the shape horizontally by a given amount of pixels.
     * @param distance how many <b>pixels</b> to move the object.
     * Positive numbers ({@code distance} > 0) move the shape to the right.
     * Negative numbers ({@code distance} < 0) move the shape to the left.
     */
    @SuppressWarnings("unused")
    public void moveHorizontal(int distance) {
        this.drawable.moveBy(distance, 0);
    }

    /**
     * Move the shape vertically by a given amount of pixels.
     * @param distance how many <b>pixels</b> to move the object.
     * Positive numbers ({@code distance} > 0) move the shape down.
     * Negative numbers ({@code distance} < 0) move the shape up.
     */
    @SuppressWarnings("unused")
    public void moveVertical(int distance) {
        this.drawable.moveBy(0, distance);
    }

    /**
     * Change the font according to the new specification.
     * <p>
     * This will also <b>change the width and height</b> of the {@code TextBlock}.
     * </p>
     * @param fontFamily name of the font
     *                   <p>
     *                   The font name has to be a {@link String}.
     *                   </p><p>
     *                   (e.g. {@code "Arial"}, {@code "Times New Roman"}, {@code "Courier New"})
     *                   </p>
     * @param style      style of the font
     *                   <p>
     *                   Use a {@link FontStyle} enum constant.
     *                   </p><p>
     *                   (e.g. {@link FontStyle#BOLD}, {@link FontStyle#ITALIC}, {@link FontStyle#UNDERLINE})
     *                   </p>
     * @param size       size of the font in pt (same pt as Microsoft Office)
     *                   <p>
     *                   The <b>actual height</b> of the TextBlock returned by {@link TextBlock#getHeight()} <b>may be different!</b>
     *                   </p>
     * @implNote You can combine multiple {@link FontStyle}s (for e.g. bold italic text), see {@link TextBlock#changeFont(String, EnumSet, int)}
     */
    @SuppressWarnings("unused")
    public void changeFont(String fontFamily, FontStyle style, int size) {
        this.drawable.changeFont(fontFamily, style == FontStyle.BOLD, style == FontStyle.ITALIC, style == FontStyle.UNDERLINE, size, this.drawable.getLineSpacing());
    }

    /**
     * Change the font according to the new specification.
     * <p>
     * This will also <b>change the width and height</b> of the {@code TextBlock}.
     * </p>
     * @param fontFamily name of the font
     *                   <p>
     *                   The font name has to be a {@link String}.
     *                   </p><p>
     *                   (e.g. {@code "Arial"}, {@code "Times New Roman"}, {@code "Courier New"})
     *                   </p>
     * @param style      style of the font
     *                   <p>
     *                   Use a {@link FontStyle} enum constant.
     *                   </p><p>
     *                   (e.g. {@link FontStyle#BOLD}, {@link FontStyle#ITALIC}, {@link FontStyle#UNDERLINE})
     *                   </p>
     * @param size       size of the font in pt (same pt as Microsoft Office)
     *                   <p>
     *                   The <b>actual height</b> of the TextBlock returned by {@link TextBlock#getHeight()} <b>may be different!</b>
     *                   </p>
     * @param lineSpacing spacing between lines in pixels
     *                   <p>
     *                   This is only applicable to multi-line {@code TextBlock}s.
     *                   </p>
     * @implNote You can combine multiple {@link FontStyle}s (for e.g. bold italic text), see {@link TextBlock#changeFont(String, EnumSet, int, int)}
     */
    public void changeFont(String fontFamily, FontStyle style, int size, int lineSpacing) {
        this.drawable.changeFont(fontFamily, style == FontStyle.BOLD, style == FontStyle.ITALIC, style == FontStyle.UNDERLINE, size, lineSpacing);
    }

    /**
     * Change the font according to the new specification.
     * <p>
     * This will also <b>change the width and height</b> of the {@code TextBlock}.
     * </p>
     * @param fontFamily name of the font
     *                   <p>
     *                   The font name has to be a {@link String}.
     *                   </p><p>
     *                   (e.g. {@code "Arial"}, {@code "Times New Roman"}, {@code "Courier New"})
     *                   </p>
     * @param style      style of the font
     *                   <p>
     *                   Use {@link EnumSet#of()} and write the desired {@link FontStyle}s into the parentheses ().
     *                   </p><p>
     *                   (e.g. {@code EnumSet.of(FontStyle.BOLD, FontStyle.ITALIC)})
     *                   </p>
     * @param size       size of the font in pt (same pt as Microsoft Office)
     *                   <p>
     *                   The <b>actual height</b> of the TextBlock returned by {@link TextBlock#getHeight()} <b>may be different!</b>
     *                   </p>
     */
    @SuppressWarnings("unused")
    public void changeFont(String fontFamily, EnumSet<FontStyle> style, int size) {
        this.drawable.changeFont(fontFamily, style.contains(FontStyle.BOLD), style.contains(FontStyle.ITALIC), style.contains(FontStyle.UNDERLINE), size, this.drawable.getLineSpacing());
    }

    /**
     * Change the font according to the new specification.
     * <p>
     * This will also <b>change the width and height</b> of the {@code TextBlock}.
     * </p>
     * @param fontFamily name of the font
     *                   <p>
     *                   The font name has to be a {@link String}.
     *                   </p><p>
     *                   (e.g. {@code "Arial"}, {@code "Times New Roman"}, {@code "Courier New"})
     *                   </p>
     * @param style      style of the font
     *                   <p>
     *                   Use {@link EnumSet#of()} and write the desired {@link FontStyle}s into the parentheses ().
     *                   </p><p>
     *                   (e.g. {@code EnumSet.of(FontStyle.BOLD, FontStyle.ITALIC)})
     *                   </p>
     * @param size       size of the font in pt (same pt as Microsoft Office)
     *                   <p>
     *                   The <b>actual height</b> of the TextBlock returned by {@link TextBlock#getHeight()} <b>may be different!</b>
     *                   </p>
     * @param lineSpacing spacing between lines in pixels
     *                   <p>
     *                    This is only applicable to multi-line {@code TextBlock}s.
     *                   </p>
     */
    public void changeFont(String fontFamily, EnumSet<FontStyle> style, int size, int lineSpacing) {
        this.drawable.changeFont(fontFamily, style.contains(FontStyle.BOLD), style.contains(FontStyle.ITALIC), style.contains(FontStyle.UNDERLINE), size, lineSpacing);
    }

    /**
     * Change the color of the text in the entire block.
     * @param newColor new color from <b>Colors in sbge.ini</b> or in <b>plain #rrggbb format</b> as {@link String} (e.g. {@code "blue"}, {@code "yellow"}, {@code "#ba9000"}).
     *                 <h3>Colors in sbge.ini:</h3>
     *                 <p>The default supported colors are {@code "red"}, {@code "blue"}, {@code "yellow"}, {@code "green"}, {@code "magenta"}, {@code "white"}, {@code "brown"} and {@code "black"}</p>
     *                 <p>Visit <a href="https://github.com/infjava/shapesge/wiki">ShapesGE Wiki on GitHub</a> to learn more.</p>
     *                 <h3>Plain #rrggbb:</h3>
     *                 <p>This is a HEX color code. To find this code for your desired color, use an online HEX color picker tool.</p>
     *                 <p>Visit <a href="https://w3schools.com/colors/colors-hexadecimal.asp">W3Schools' article on HEX colors</a> to learn more.</p>
     */
    @SuppressWarnings("unused")
    public void changeColor(String newColor) {
        this.drawable.changeColor(newColor);
    }

    /**
     * Change the text.
     * @param text new text
     */
    @SuppressWarnings("unused")
    public void changeText(String text) {
        this.drawable.changeText(text);
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
     * @return the width of the shape.
     */
    public int getWidth() {
        return this.drawable.getWidth();
    }

    /**
     * @return the height of the shape.
     */
    public int getHeight() {
        return this.drawable.getHeight();
    }

    /**
     * Controls automatic text wrapping.
     * Lines that are too long get automatically wrapped into the next line at the limit (in pixels).
     * Manual text wrapping using {@code \n} is unaffected.
     * @param maxWidth maximum width in pixels before the line will be wrapped. Set to 0 (or lower) to disable text wrapping.
     * @implNote When this is enabled, the return width of {@link TextBlock#getWidth()} will be,
     * at most, the number you put in as {@code maxWidth}. (It may be lower, if the text is short or wraps on a very long word).
     */
    public void wrapText(int maxWidth) {
        if (maxWidth <= 0) {
            this.drawable.disableTextWrapping();
        } else {
            this.drawable.enableTextWrapping(maxWidth);
        }
    }
}
