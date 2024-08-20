package fri.shapesge;

import fri.shapesge.drawables.ImageDrawable;

/**
 * Obrázok, ktorý sa zobrazí v hernom okne (na plátne).
 * Táto trieda dokáže spracovať obrázky formátu PNG alebo JPEG, vrátane priehľadnosti (alpha channel).
 * Obrázok načítaš použitím jeho <b>absolútnej alebo relatívnej cesty</b> ako parameter vo formáte {@link String}.
 * <br><br>
 * <h3>Použitie absolútnej cesty k súboru</h3>
 * <p>
 *     <b>Windows:</b>
 *     <ol>
 *         <p>Absolútna cesta začína písmenkom disku (napr. {@code C:\})</p>
 *         <li>Nájdi svoj obrázok v programe <b>Prieskumník (File Explorer</b> 📁)</li>
 *         <li>Klikni na obrázok pravým tlačidlom myši</li>
 *         <li>Zvoľ možnosť <b>Skopírovať cestu (Copy as path)</b></li>
 *     </ol>
 *     <b>MacOS:</b>
 *     <ol>
 *         <p>Absolútna cesta začína <i>priečinkom root</i>. ({@code /})</p>
 *         <li>Nájdi svoj obrázok v programe <b>Finder</b></li>
 *         <li>Klikni na obrázok pravým tlačidlom myši</li>
 *         <li>Slač a drž klávesu <b>OPTION</b></li>
 *         <li>Zvoľ možnosť <b>Skopírovať cestu (Copy as Filepath)</b></li>
 *     </ol>
 *     <b>Linux:</b>
 *     <ul>
 *         <p>Absolútna cesta začína <i>priečinkom root</i>. ({@code /})</p>
 *         <p>Presnejšie inštrukcie nájdeš v používateľskom návode konkrétnej distribúcie.</p>
 *     </ul>
 * </p>
 * <b><u>DÔLEŽITÉ:</u></b> Absolútnu cestu nepoužívaj v serióznych projektoch (vrátane semestrálnych prác).
 * Ak budeš projekt musieť otvoriť na inom počítači, obrázky sa nenačítajú!!!
 * Preto radšej použi relatívnu cestu.
 * <br><br>
 * <h3>Použitie relatívnej csty k súboru</h3>
 * <p>Relatívna cesta začína priečinkom, v ktorom sa nachádza tvoj projekt.</p>
 * <p>
 *     <b>BlueJ:</b>
 *     <ol>
 *         <li>Obrázok skopíruj do priečinka s tvojím projektom</li>
 *         <li>Pri tvorbe obrázka napíš už iba jeho názov</li> (napr. {@code "image.png"})
 *         <p>Tvoje obrázky môžeš vkladať aj do podpriečinkov v tvojom projekte, v takom prípade použi {@code "folder/image.png"}.</p>
 *     </ol>
 *     <b>IntelliJ IDEA:</b>
 *     <ol>
 *         <li>Klikni pravým na <b>Project pane</b> (vľavo, kde sú všetky triedy)</li>
 *         <li>Vyber možnosť <b>New -> Directory</b>, pomenuj priečinok a stlač ENTER</li>
 *         <li>Klikni pravým na tento priečinok</li>
 *         <li>Vyber možnosť <b>Mark Directory as -> Resources root</b></li>
 *         <li>Tvoj obrázok skopíruj a vlož do tohto priečinka.</li>
 *         <li>Pri tvorbe obrázka napíš už iba jeho názov</li> (napr. {@code "image.png"})
 *  *         <p>Tvoje obrázky môžeš vkladať aj do podpriečinkov v tvojom projekte, v takom prípade použi {@code "folder/image.png"}.</p>
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
     * Vytvor nový obrázok na predvolenej pozícii.
     * <p>
     * Predvolená pozícia:
     * <ul>
     * <li>Pozícia X: 100 pixelov od ľavého okraja plátna</li>
     * <li>Pozícia Y: 100 pixelov od horného okraja plátna</li>
     * </p>
     * @param cestaKObrazku <b>absolútna alebo relatívna cesta</b> k obrázku vo formáte {@link String}.
     *                  <p>(napr. {@code "C:\folder\image.png"}, {@code "folder/image.png"}).</p>
     *                  <p>Viac informácii nájdeš v popise triedy {@link Obrazok} .</p>
     * @throws fri.shapesge.engine.ShapesGEException ak sa na ceste nenachádza žiadny obrázok
     */
    @SuppressWarnings("unused")
    public Obrazok(String cestaKObrazku) {
        this(new DataObrazku(cestaKObrazku));
    }

    /**
     * Vytvor nový obrázok na predvolenej pozícii.
     * <p>
     * Predvolená pozícia:
     * <ul>
     * <li>Pozícia X: 100 pixelov od ľavého okraja plátna</li>
     * <li>Pozícia Y: 100 pixelov od horného okraja plátna</li>
     * </p>
     * @param dataObrazku objekt {@link DataObrazku} ktorý obsahuje nový obrázok.
     *                  <p>Túto metódu použi ak vytváraš {@link DataObrazku} samostatne.</p>
     */
    @SuppressWarnings("unused")
    public Obrazok(DataObrazku dataObrazku) {
        this(dataObrazku, 100, 100);
    }

    /**
     * Vytvor nový obrázok na danej pozícii.
     * @param cestaKObrazku <b>absolútna alebo relatívna cesta</b> k obrázku vo formáte {@link String}.
     *                  <p>(napr. {@code "C:\folder\image.png"}, {@code "folder/image.png"}).</p>
     *                  <p>Viac informácii nájdeš v popise triedy {@link Obrazok} .</p>
     * @param x pozícia X ľavého horného rohu tvaru.
     * 	 Pozícia X je vzdialenosť od ľavého okraja plátna.
     * @param y pozícia Y ľavého horného rohu tvaru.
     * 	 Pozícia Y je vzdialenosť od horného okraja plátna.
     * @throws fri.shapesge.engine.ShapesGEException ak sa na ceste nenachádza žiadny obrázok
     */
    @SuppressWarnings("unused")
    public Obrazok(String cestaKObrazku, int x, int y) {
        this(new DataObrazku(cestaKObrazku), x, y);
    }

    /**
     * Vytvor nový obrázok na danej pozícii.
     * @param dataObrazku objekt {@link DataObrazku} ktorý obsahuje nový obrázok.
     *                  <p>Túto metódu použi ak vytváraš {@link DataObrazku} samostatne.</p>
     @param x pozícia X ľavého horného rohu tvaru.
      * 	 Pozícia X je vzdialenosť od ľavého okraja plátna.
      * @param y pozícia Y ľavého horného rohu tvaru.
     * 	 Pozícia Y je vzdialenosť od horného okraja plátna.
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
     * Zmeň obrázok za iný.
     * @param cestaKObrazku <b>absolútna alebo relatívna cesta</b> k obrázku vo formáte {@link String}.
     *                  <p>(napr. {@code "C:\folder\image.png"}, {@code "folder/image.png"}).</p>
     *                  <p>Viac informácii nájdeš v popise triedy {@link Obrazok} .</p>
     * @throws fri.shapesge.engine.ShapesGEException ak sa na ceste nenachádza žiadny obrázok
     * @implNote Táto metóda vykreslí nový obrázok v jeho originálnej veľkosti a orientácii.
     *           <p>Ak potrebuješ zmeniť obrázok a zachovať veľkosť aj orientáciu, použí {@link Obrazok#zmenObrazokAZachovajParametre(String)}.</p>
     */
    @SuppressWarnings("unused")
    public void zmenObrazok(String cestaKObrazku) {
        this.zmenObrazok(new DataObrazku(cestaKObrazku));
    }

    /**
     * Zmeň obrázok za iný a zachovaj veľkosť, otočenie a orientáciu pôvodného.
     * @param cestaKObrazku <b>absolútna alebo relatívna cesta</b> k obrázku vo formáte {@link String}.
     *                  <p>(napr. {@code "C:\folder\image.png"}, {@code "folder/image.png"}).</p>
     *                  <p>Viac informácii nájdeš v popise triedy {@link Obrazok} .</p>
     * @throws fri.shapesge.engine.ShapesGEException ak sa na ceste nenachádza žiadny obrázok
     * @implNote Táto metóda vykreslí nový obrázok v rovnakej veľkosti a orientácii ako ten pôvodný.
     *           <p>Ak potrebuješ vykresliť originál nového obrázku (tzn. v jeho originálnej veľkosti
     *           a orientácii), použí {@link Obrazok#zmenObrazok(String)}.</p>
     */
    public void zmenObrazokAZachovajParametre(String cestaKObrazku) {
        this.zmenObrazokAZachovajParametre(new DataObrazku(cestaKObrazku));
    }

    /**
     * Zmeň obrázok za iný.
     * @param dataObrazku objekt {@link DataObrazku} ktorý obsahuje nový obrázok.
     *                  <p>Túto metódu použi ak vytváraš {@link DataObrazku} samostatne.</p>
     * @implNote Táto metóda vykreslí nový obrázok v jeho originálnej veľkosti a orientácii.
     *           <p>Ak potrebuješ zmeniť obrázok a zachovať veľkosť aj orientáciu, použí {@link Obrazok#zmenObrazokAZachovajParametre(String)}.</p>
     */
    @SuppressWarnings("unused")
    public void zmenObrazok(DataObrazku dataObrazku) {
        this.drawable.changeImage(dataObrazku.getImage(), false);
    }

    /**
     * Zmeň obrázok za iný a zachovaj veľkosť, otočenie a orientáciu pôvodného.
     * @param dataObrazku objekt {@link DataObrazku} ktorý obsahuje nový obrázok.
     *                  <p>Túto metódu použi ak vytváraš {@link DataObrazku} samostatne.</p>
     * @implNote Táto metóda vykreslí nový obrázok v rovnakej veľkosti a orientácii ako ten pôvodný.
     *           <p>Ak potrebuješ vykresliť originál nového obrázku (tzn. v jeho originálnej veľkosti
     *           a orientácii), použí {@link Obrazok#zmenObrazok(String)}.</p>
     */
    public void zmenObrazokAZachovajParametre(DataObrazku dataObrazku) {
        this.drawable.changeImage(dataObrazku.getImage(),true);
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
     * 	 Pozícia Y je vzdialenosť od horného okraja plátna.
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
     * Obráť obrázok vodorovne.
     * @param obratene Zadaj {@code true} aby bol obrázok obrátený. Zadaj {@code false} aby bol obrázok v pôvodnej orientácii.
     */
    public void obratVodorovne(boolean obratene) {
        this.drawable.flipHorizontal(obratene);
    }

    /**
     * Obráť obrázok vodorovne.
     * Táto metóda obrázok obráti vždy. Ak už bol obrátený, vráti ho do pôvodnej orientácie.
     */
    public void obratVodorovne() {
        this.drawable.flipHorizontal();
    }

    /**
     * Obráť obrázok zvisle.
     * @param obratene Zadaj {@code true} aby bol obrázok obrátený. Zadaj {@code false} aby bol obrázok v pôvodnej orientácii.
     */
    public void obratZvisle(boolean obratene) {
        this.drawable.flipVertical(obratene);
    }

    /**
     * Obráť obrázok zvisle.
     * Táto metóda obrázok obráti vždy. Ak už bol obrátený, vráti ho do pôvodnej orientácie.
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
