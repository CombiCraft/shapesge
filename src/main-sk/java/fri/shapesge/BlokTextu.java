package fri.shapesge;

import fri.shapesge.drawables.TextDrawable;

import java.awt.Color;
import java.awt.Font;
import java.util.EnumSet;

/**
 * Blok textu je odsek textu, ktorý sa zobrazí na plátne.
 * Text v bloku je typu {@link String} a dokáže zobraziť text na jeden alebo viac riadkov.
 * <p>
 *     Predvolene je každý text iba v jednom riadku. Zalomiť text môžeš vložením {@code \n}
 *     do tvojho textu (<b>bez medzier</b>, čiže "tvoj<b>\n</b>text"), alebo použitím metódy
 *     {@link BlokTextu#zalomText(int maxDlzka)} pre automatické zalamovanie po určitej
 *     dĺžke v pixeloch.
 * </p>
 *
 * @author Ján Janech
 * @author trailblazercombi
 * @version 1.1  (July 2024)
 */

@SuppressWarnings("unused")
public class BlokTextu {
    private final TextDrawable drawable;

    /**
     * Vytvorí nový Blok Textu na danej pozícii s predvolenými parametrami.
     * <p>
     *     Predvolené parametre:
     * <ul><li>
     *     Font: Serif
     * </li><li>
     *     Farba: black (čierna)
     * </li><li>
     *     Veľkosť: 12 pt (17 pixelov vysoké)
     * </li></ul>
     * </p>
     * <p>
     *     Text bude zobrazený na danej pozícii, pričom daná pozícia
     *     je <b>ľavý horný roh</b> bloku.
     * </p>
     * <p>
     *     Pozíciu, font a farbu môžeš neskôr zmeniť použitím metód {@link BlokTextu#zmenPoziciu(int x, int y)},
     *     {@link BlokTextu#zmenFont} and {@link BlokTextu#zmenFarbu}.
     * </p>
     * @param text text na zobrazenie, jedno- alebo viacriadkový.
     * @param x pozícia X ľavého horného rohu tvaru.
     * 	 Pozícia X je vzdialenosť od ľavého okraja plátna.
     * @param y pozícia Y ľavého horného rohu tvaru.
     * 	 Pozícia X je vzdialenosť od horného okraja plátna.
     */
    @SuppressWarnings("unused")
    public BlokTextu(String text, int x, int y) {
        this.drawable = new TextDrawable(x, y, Color.black, text, new Font(Font.SERIF, Font.PLAIN, 12));
    }

    /**
     * Vytvorí nový Blok Textu na danej pozícii s predvolenými parametrami.
     * <p>
     *     Predvolené parametre:
     * <ul><li>
     *     Font: Serif
     * </li><li>
     *     Farba: black (čierna)
     * </li><li>
     *     Veľkosť: 12 pt (17 pixelov vysoké)
     * </li>
     *      <li>Pozícia X: 0 pixelov od ľavého okraja plátna</li>
     *      <li>Pozícia Y: 20 pixelov od horného okraja plátna</li>
     * </ul>
     * </p>
     * <p>
     *     Text bude zobrazený na danej pozícii, pričom daná pozícia
     *     je <b>ľavý horný roh</b> bloku.
     * </p>
     * <p>
     *     Pozíciu, font a farbu môžeš neskôr zmeniť použitím metód {@link BlokTextu#zmenPoziciu(int x, int y)},
     *     {@link BlokTextu#zmenFont} and {@link BlokTextu#zmenFarbu}.
     * </p>
     * @param text text na zobrazenie, jedno- alebo viacriadkový.
     */
    @SuppressWarnings("unused")
    public BlokTextu(String text) {
        this(text, 0, 20);
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
     * Zmeň font textu podľa zadaných parametrov.
     * <p>
     * Toto taktiež <b>zmení výšku a šírku</b> samotného {@code BloKTextu}u.
     * </p>
     * @param font názov fontu
     *                   <p>
     *                   Názov fontu musí byť {@link String}.
     *                   </p><p>
     *                   (napr. {@code "Arial"}, {@code "Times New Roman"}, {@code "Courier New"})
     *                   </p>
     * @param styl štýl fontu (tučné, kurzíva, podčiarknuté)
     *                   <p>
     *                   Použi inštanciu z enumu {@link StylFontu}.
     *                   </p><p>
     *                   (e.g. {@link StylFontu#BOLD}, {@link StylFontu#ITALIC}, {@link StylFontu#UNDERLINE})
     *                   </p>
     * @param velkost veľkosť fontu v pt (tak ako v Microsoft Office)
     *                   <p>
     *                   <b>Skutočná veľkosť</b> bloku vrátená metódou {@link BlokTextu#getVyska()} <b>bude iná!</b>
     *                   (getVyska() vracia veľkosť v pixeloch)
     *                   </p>
     * @implNote Zlúčiť možeš aj viacero {@link StylFontu}ov (napr. ak chceš tučnú kurzívu), pozri {@link BlokTextu#zmenFont(String, EnumSet, int)}
     */
    @SuppressWarnings("unused")
    public void zmenFont(String font, FontStyle styl, int velkost) {
        this.drawable.changeFont(font, styl == FontStyle.BOLD, styl == FontStyle.ITALIC, styl == FontStyle.UNDERLINE, velkost, this.drawable.getLineSpacing());
    }

    /**
     * Zmeň font textu podľa zadaných parametrov.
     * <p>
     * Toto taktiež <b>zmení výšku a šírku</b> samotného {@code BloKTextu}u.
     * </p>
     * @param font názov fontu
     *                   <p>
     *                   Názov fontu musí byť {@link String}.
     *                   </p><p>
     *                   (napr. {@code "Arial"}, {@code "Times New Roman"}, {@code "Courier New"})
     *                   </p>
     * @param styl štýl fontu (tučné, kurzíva, podčiarknuté)
     *                   <p>
     *                   Použi inštanciu z enumu {@link StylFontu}.
     *                   </p><p>
     *                   (e.g. {@link StylFontu#BOLD}, {@link StylFontu#ITALIC}, {@link StylFontu#UNDERLINE})
     *                   </p>
     * @param velkost veľkosť fontu v pt (tak ako v Microsoft Office)
     *                   <p>
     *                   <b>Skutočná veľkosť</b> bloku vrátená metódou {@link BlokTextu#getVyska()} <b>bude iná!</b>
     *                   (getVyska() vracia veľkosť v pixeloch)
     *                   </p>
     * @param riadkovanie vzdialenosť medzi dvomi riadkami tohto bloku.
     *                    <p>Toto sa týka iba viacriadkového textu.</p>
     * @implNote Zlúčiť možeš aj viacero {@link StylFontu}ov (napr. ak chceš tučnú kurzívu), pozri {@link BlokTextu#zmenFont(String, EnumSet, int)}
     */
    public void zmenFont(String font, FontStyle styl, int velkost, int riadkovanie) {
        this.drawable.changeFont(font, styl == FontStyle.BOLD, styl == FontStyle.ITALIC, styl == FontStyle.UNDERLINE, velkost, riadkovanie);
    }

    /**
     * Zmeň font textu podľa zadaných parametrov.
     * <p>
     * Toto taktiež <b>zmení výšku a šírku</b> samotného {@code BloKTextu}u.
     * </p>
     * @param font názov fontu
     *                   <p>
     *                   Názov fontu musí byť {@link String}.
     *                   </p><p>
     *                   (napr. {@code "Arial"}, {@code "Times New Roman"}, {@code "Courier New"})
     *                   </p>
     * @param styl štýl fontu (tučné, kurzíva, podčiarknuté)
     *                   <p>
     *                   Použi metódu {@link EnumSet#of()} a do zátvoriek (ako parametre) napíš všetky
     *                   požadované štýly, tie oddeľ čiarkami.
     *                   </p><p>
     *                   (napr. {@code EnumSet.of(StylFontu.BOLD, StylFontu.ITALIC)})
     *                   </p><p>
     *                   (e.g. {@link StylFontu#BOLD}, {@link StylFontu#ITALIC}, {@link StylFontu#UNDERLINE})
     *                   </p>
     * @param velkost veľkosť fontu v pt (tak ako v Microsoft Office)
     *                   <p>
     *                   <b>Skutočná veľkosť</b> bloku vrátená metódou {@link BlokTextu#getVyska()} <b>bude iná!</b>
     *                   (getVyska() vracia veľkosť v pixeloch)
     *                   </p>
     */
    @SuppressWarnings("unused")
    public void zmenFont(String font, EnumSet<FontStyle> styl, int velkost) {
        this.drawable.changeFont(font, styl.contains(FontStyle.BOLD), styl.contains(FontStyle.ITALIC), styl.contains(FontStyle.UNDERLINE), velkost, this.drawable.getLineSpacing());
    }

    /**
     * Zmeň font textu podľa zadaných parametrov.
     * <p>
     * Toto taktiež <b>zmení výšku a šírku</b> samotného {@code BloKTextu}u.
     * </p>
     * @param font názov fontu
     *                   <p>
     *                   Názov fontu musí byť {@link String}.
     *                   </p><p>
     *                   (napr. {@code "Arial"}, {@code "Times New Roman"}, {@code "Courier New"})
     *                   </p>
     * @param styl štýl fontu (tučné, kurzíva, podčiarknuté)
     *                   <p>
     *                   Použi metódu {@link EnumSet#of()} a do zátvoriek (ako parametre) napíš všetky
     *                   požadované štýly, tie oddeľ čiarkami.
     *                   </p><p>
     *                   (napr. {@code EnumSet.of(StylFontu.BOLD, StylFontu.ITALIC)})
     *                   </p><p>
     * @param velkost veľkosť fontu v pt (tak ako v Microsoft Office)
     *                   <p>
     *                   <b>Skutočná veľkosť</b> bloku vrátená metódou {@link BlokTextu#getVyska()} <b>bude iná!</b>
     *                   (getVyska() vracia veľkosť v pixeloch)
     *                   </p>
     * @param riadkovanie vzdialenosť medzi dvomi riadkami tohto bloku.
     *                    <p>Toto sa týka iba viacriadkového textu.</p>
     * @implNote Zlúčiť možeš aj viacero {@link StylFontu}ov (napr. ak chceš tučnú kurzívu), pozri {@link BlokTextu#zmenFont(String, EnumSet, int)}
     */
    public void zmenFont(String font, EnumSet<FontStyle> styl, int velkost, int riadkovanie) {
        this.drawable.changeFont(font, styl.contains(FontStyle.BOLD), styl.contains(FontStyle.ITALIC), styl.contains(FontStyle.UNDERLINE), velkost, riadkovanie);
    }

    /**
     * Zmeň farbu všetkého textu v bloku.
     * @param novaFarba nová farba zo sekcie <b>Colors v sbge.ini</b> alebo v <b>surovom formáte #rrggbb</b>, v {@link String}u (napr. {@code "blue"}, {@code "yellow"}, {@code "#ba9000"}).
     *                 <h3>Sekcia Colors v sbge.ini:</h3>
     *                 <p>Predvolené podporované farby sú {@code "red"}, {@code "blue"}, {@code "yellow"}, {@code "green"}, {@code "magenta"}, {@code "white"}, {@code "brown"} a {@code "black"}</p>
     *                 <p>Viac info na <a href="https://github.com/infjava/shapesge/wiki">ShapesGE Wiki na GitHub</a>e</p>
     *                 <h3>Surový formát #rrggbb:</h3>
     *                 <p>
     *                     Toto je tzv. kód farby HEX. Tento kód sa dá vyhľadať pre každú farbu použitím zmiešavača (Color picker,
     *                     napr. takom, ako je na <a href="https://g.co/kgs/RmaEk8D">Googli</a>, <a href="https://www.bing.com/search?q=hex+color+picker">Bingu</a>, ap.)
     *                 </p>
     */
    @SuppressWarnings("unused")
    public void zmenFarbu(String novaFarba) {
        this.drawable.changeColor(novaFarba);
    }

    /**
     * Zmeň text v bloku.
     * @param text nový text
     */
    @SuppressWarnings("unused")
    public void zmenText(String text) {
        this.drawable.changeText(text);
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
     * Ovládanie automatického zalamovania textu.
     * Text, ktorý je príliš dlhý, bude automaticky zalomený do ďalšieho riadku.
     * Limit je nastavený v <p>pixeloch</p>.
     * Manuálne zalamovanie pomocou {@code \n} bude fungovať aj naďalej.
     * @param maxSirka maximálna šírka textu v pixeloch.
     *                 Ak ju text prekročí, bude automaticky zalomený do ďalšieho riadku.
     *                 Zalamovanie vypneš nastavením {@code maxSirka} na 0 (alebo menej)
     * @implNote Ak je nastavené automatické zalamovanie, metóda {@link BlokTextu#getSirka()} vráti
     *           hodnotu, ktorá je najviac {@code maxSirka}.
     *           (Môže vrátiť aj menšiu hodnotu, ak je text príliš krátky alebo zalomený na
     *           veľmi dlhom slove)
     */
    public void zalomText(int maxSirka) {
        if (maxSirka <= 0) {
            this.drawable.disableTextWrapping();
        } else {
            this.drawable.enableTextWrapping(maxSirka);
        }
    }
}
