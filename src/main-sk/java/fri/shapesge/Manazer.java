package fri.shapesge;

import fri.shapesge.engine.Game;

/**
 * Manažér je hlavný správca hry.
 * <p>
 *     Jeho náplň práce:
 *     <ul>
 *         <li>riešiť stláčanie klávesov na klávesnici</li>
 *         <li>riešiť pohyb a kliky myši</li></li>
 *         <li>riešiť časovanie (časovače)</li>
 *     </ul>
 * </p>
 * <p>
 *     Správanie Manažéra možno nastaviť pomocou súboru {@codee sbge.ini}.
 *     Návod na nastavenie sa nachádza na <a href="https://github.com/infjava/shapesge/wiki">ShapesGE Wiki na GitHube</a>.
 * </p>
 * <p>V programe možno vytvoriť a používať viacero Manažérov.</p>
 * <p>
 *     <u>DÔLEŽITÉ:</u> Je možné spravovať objekt viackrát, či už rovnakým alebo viacerými Manažérmi naraz.
 *     Toto môže spôsobiť neočakávané správanie objektov, napríklad:
 *     <ul>
 *         <li>Postava sa pohne o viac políčok aj keď sa má pohnúť iba o jedno.</li>
 *         <li>Objekty sa po plátne pohybujú rýchlejšie než by mali.</li>
 *         <li>Na jedno stlačenie klávesov sa vytvorí viac objektov než očakávané.</li>
 *         <li>Viacmenej čokoľvek čo sa týka vstupu z myši/klávesnice alebo časovača.</li>
 *     </ul>
 * </p>
 *
 * @author Ján Janech
 * @version 1.0  (9.11.2022)
 */
@SuppressWarnings("unused")
public class Manazer {
    /**
     * Vytvor nový prázdny Manažér.
     * This Manager doesn't manage any objects yet.
     * <p>
     *     Použi {@link Manazer#spravujObjekt}.
     * </p>
     */
    public Manazer() {

    }

    /**
     * Registruj objekt na spravovanie.
     * @param objekt objekt na spravovanie.
     *               <p>Akonáhle je objekt spravovaný, {@code Manazer} mu bude posielať správy definované v {@code sbge.ini}.</p>
     * @implNote Je možné spravovať objekt viackrát.
     *           Pozri sekciu "Dôležité" v popise triedy {@link Manazer}.
     */
    public void spravujObjekt(Object objekt) {
        Game.getGame().registerEventTarget(objekt);
    }

    /**
     * Prestaň spravovať objekt.
     * @param objekt objekt, ktorý má Manažér prestať spravovať.
     */
    public void prestanSpravovatObjekt(Object objekt) {
        Game.getGame().deregisterEventTarget(objekt);
    }
}
