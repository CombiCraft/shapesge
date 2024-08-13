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
public class Obrazok {
    private final ImageDrawable drawable;

    /**
     * Create a new image on the default position.
     * <p>
     * Default position:
     * <ul>
     * <li>Position X: 0 pixels from the left border of the canvas</li>
     * <li>Position Y: 20 pixels from the top border of the canvas</li>
     * </p>
     * @param cestaKObrazku the <b>absolute or relative file path</b> to the image as {@link String}
     *                  <p>(e.g. {@code "C:\folder\image.png"}, {@code "folder/image.png"}).</p>
     * @throws fri.shapesge.engine.ShapesGEException if the file doesn't exist on that path
     */
    @SuppressWarnings("unused")
    public Obrazok(String cestaKObrazku) {
        this(new DataObrazku(cestaKObrazku));
    }

    /**
     * Create a new image on the default position.
     * <p>
     * Default position:
     * <ul>
     * <li>Position X: 0 pixels from the left border of the canvas</li>
     * <li>Position Y: 20 pixels from the top border of the canvas</li>
     * </p>
     * @param dataObrazku the {@link DataObrazku} for this image.
     *                  <p>Use this method if you created {@link DataObrazku} manually.</p>
     */
    @SuppressWarnings("unused")
    public Obrazok(DataObrazku dataObrazku) {
        this(dataObrazku, 100, 100);
    }

    /**
     * Create a new image on the given position.
     *
     * @param cestaKObrazku the <b>absolute or relative file path</b> to the image as {@link String}
     *                  <p>(e.g. {@code "C:\folder\image.png"}, {@code "folder/image.png"}).</p>
     * @param x x-coordinate of the image
     *          (distance from left border of the canvas)
     * @param y y-coordinate of the image
     *          (distance from top border of the canvas)
     * @throws fri.shapesge.engine.ShapesGEException if the file doesn't exist on that path
     */
    @SuppressWarnings("unused")
    public Obrazok(String cestaKObrazku, int x, int y) {
        this(new DataObrazku(cestaKObrazku), x, y);
    }

    /**
     * Create a new image on the given position.
     *
     * @param dataObrazku the {@link DataObrazku} for this image.
     *                  <p>Use this method if you created {@link DataObrazku} manually.</p>
     * @param x x-coordinate of the image
     *          (distance from left border of the canvas)
     * @param y y-coordinate of the image
     *          (distance from top border of the canvas)
     */
    public Obrazok(DataObrazku dataObrazku, int x, int y) {
        this.drawable = new ImageDrawable(x, y, 0, dataObrazku.getImage());
    }

    /**
     * Zobraz tvar na plátne. Ak už bol viditeľný, nič sa nestane.
     * @implNote Ak sa prekrýva viacero tvarov na sebe,
     * tvary budú zobrazované v takom poradí, v akom sú poslané správy.
     * <p>
     *     Napríklad, ak chceš {@link Kruh} viditeľný na štvorci ({@link Stvorec}), správy pošli v tomto poradí:
     *     <blockquote><pre>
     *         tvojStvorec.zobraz();
     *         tvojKruh.zobraz();
     *     </pre></blockquote>
     *     Ak tieto správy pošleš v opačnom poradí, {@link Kruh} sa ti skryje pod {@link Stvorec}.</b>
     * </p>
     */
    @SuppressWarnings("unused")
    public void zobraz() {
        this.drawable.makeVisible();
    }

    /**
     * Skry tvar z plátna. Ak už skrytý bol, nič sa nestane.
     */
    @SuppressWarnings("unused")
    public void skry() {
        this.drawable.makeInvisible();
    }

    /**
     * Posuň tvar o niekoľko pixelov vpravo.
     * Táto metóda vždy posúva tvar o 20 pixelov.
     */
    @SuppressWarnings("unused")
    public void posunVpravo() {
        this.drawable.moveBy(20, 0);
    }

    /**
     * Posuň tvar o niekoľko pixelov vľavo.
     * Táto metóda vždy posúva tvar o 20 pixelov.
     */
    @SuppressWarnings("unused")
    public void posunVlavo() {
        this.drawable.moveBy(-20, 0);
    }

    /**
     * Posuň tvar o niekoľko pixelov hore.
     * Táto metóda vždy posúva tvar o 20 pixelov.
     */
    @SuppressWarnings("unused")
    public void posunHore() {
        this.drawable.moveBy(0, -20);
    }

    /**
     * Posuň tvar o niekoľko pixelov dolu.
     * Táto metóda vždy posúva tvar o 20 pixelov.
     */
    @SuppressWarnings("unused")
    public void posunDole() {
        this.drawable.moveBy(0, 20);
    }

    /**
     * Posuň tvar o daný počet pixelov vodorovne.
     * @param vzdialenost o koľko <b>pixelov</b> sa má tvar posunúť.
     * Kladné čísla ({@code vzdialenost > 0}) posunú tvar doprava.
     * Záporné čísla ({@code vzdialenost < 0}) posunú tvar doľava.
     * Nula ({@code vzdialenost == 0} tvar nikam neposunie.
     */
    @SuppressWarnings("unused")
    public void posunVodorovne(int vzdialenost) {
        this.drawable.moveBy(vzdialenost, 0);
    }

    /**
     * Posuň tvar o daný počet pixelov zvisle.
     * @param vzdialenost o koľko <b>pixelov</b> sa má tvar posunúť.
     * Kladné čísla ({@code vzdialenost > 0}) posunú tvar doprava.
     * Záporné čísla ({@code vzdialenost < 0}) posunú tvar doľava.
     * Nula ({@code vzdialenost == 0} tvar nikam neposunie.
     */
    @SuppressWarnings("unused")
    public void posunZvisle(int vzdialenost) {
        this.drawable.moveBy(0, vzdialenost);
    }

    /**
     * Change the drawn image.
     * @param imagePath the <b>absolute or relative file path</b> to the image as {@link String}
     *                  <p>(e.g. {@code "C:\folder\image.png"}, {@code "folder/image.png"}).</p>
     *                  <p>See the {@link Obrazok} class description for more information.</p>
     * @throws fri.shapesge.engine.ShapesGEException if the file doesn't exist on that path
     * @implNote This method will draw the new Image in its original size and mirroring.
     *           <p>If you need to preserve the size and mirroring across the changes, use {@link Obrazok#zmenObrazokAZachovajParametre(String)}.</p>
     */
    @SuppressWarnings("unused")
    public void zmenObrazok(String imagePath) {
        this.zmenObrazok(new DataObrazku(imagePath));
    }

    /**
     * Change the drawn image.
     * @param cestaKObrazku the <b>absolute or relative file path</b> to the image as {@link String}
     *                  <p>(e.g. {@code "C:\folder\image.png"}, {@code "folder/image.png"}).</p>
     *                  <p>See the {@link Obrazok} class description for more information.</p>
     * @throws fri.shapesge.engine.ShapesGEException if the file doesn't exist on that path
     * @implNote This method will draw the new Image in the same size and mirroring as the current one.
     *           <p>If you need to always get the original, use {@link Obrazok#zmenObrazok(String)}.</p>
     */
    public void zmenObrazokAZachovajParametre(String cestaKObrazku) {
        this.zmenObrazokAZachovajParametre(new DataObrazku(cestaKObrazku));
    }

    /**
     * Change the drawn image.
     * @param dataObrazku the {@link DataObrazku} for this image.
     *                  <p>Use this method if you created {@link DataObrazku} manually.</p>
     */
    @SuppressWarnings("unused")
    public void zmenObrazok(DataObrazku dataObrazku) {
        this.drawable.changeImage(dataObrazku.getImage(), false);
    }

    public void zmenObrazokAZachovajParametre(DataObrazku imageData) {
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
    public void zmenUhol(int angle) {
        this.drawable.changeAngle(angle);
    }

    /**
     * Zmeň pozíciu podľa parametrov.
     * @param x pozícia X ľavého horného rohu tvaru.
     * 	 Pozícia X je vzdialenosť od ľavého okraja plátna.
     * @param y pozícia Y ľavého horného rohu tvaru.
     * 	 Pozícia X je vzdialenosť od horného okraja plátna.
     */
    @SuppressWarnings("unused")
    public void zmenPoziciu(int x, int y) {
        this.drawable.moveTo(x, y);
    }

    /**
     * Zmeň veľkosť tvaru.
     * @param novaSirka nová šírka tvaru v <b>pixeloch</b>
     *                Šírka nesmie byť menšia ako 0 ({@code novaSirka < 0}).
     * @param novaVyska nová výška tvaru v <b>pixeloch</b>.
     *                Výška nesmie byť menšia ako 0 ({@code novaVyska < 0}).
     */
    @SuppressWarnings("unused")
    public void zmenVelkost(int novaSirka, int novaVyska) {
        this.drawable.changeSize(novaSirka, novaVyska);
    }

    /**
     * Mirror the image horizontally.
     * @param obratene Use {@code true} to make the image obratene. Use {@code false} to get the original orientation.
     */
    public void obratVodorovne(boolean obratene) {
        this.drawable.flipHorizontal(obratene);
    }

    /**
     * Mirror the image horizontally.
     * This method will always mirror the image, regardless of its current orientation.
     */
    public void obratVodorovne() {
        this.drawable.flipHorizontal();
    }

    /**
     * Mirror the image vertically.
     * @param obratene Use {@code true} to make the image obratene. Use {@code false} to get the original orientation.
     */
    public void obratZvisle(boolean obratene) {
        this.drawable.flipVertical(obratene);
    }

    /**
     * Mirror the image vertically.
     * This method will always mirror the image, regardless of its current orientation.
     */
    public void obratZvisle() {
        this.drawable.flipVertical();
    }

    /**
     * @return pozíciu X ľavého horného rohu tvaru.
     * <p>Pozícia X je vzdialenosť (v pixeloch) od ľavého okraja plátna.</p>
     */
    public int getPoziciaX() {
        return this.drawable.getXPosition();
    }

    /**
     * @return pozíciu Y ľavého horného rohu tvaru.
     *      * <p>Pozícia Y je vzdialenosť (v pixeloch) od horného okraja plátna.</p>
     */
    public int getPoziciaY() {
        return this.drawable.getYPosition();
    }

    /**
     * @return šírka tvaru v <b>pixeloch</b>.
     */
    public int getSirka() {
        return this.drawable.getWidth();
    }

    /**
     * @return výška tvaru v <b>pixeloch</b>.
     */
    public int getVyska() {
        return this.drawable.getHeight();
    }

    /**
     * @return uhol obrázka v <b>stupňoch</b>.
     */
    public int getUhol() {
        return this.drawable.getAngle();
    }
}
