package fri.shapesge;

import fri.shapesge.engine.Game;

/**
 * Manager is the master class behind managing objects in your game.
 * <p>
 *     Its job is to:
 *     <ul>
 *         <li>handle keyboard input</li>
 *         <li>handle mouse movement and input</li>
 *         <li>handle timers</li>
 *     </ul>
 * </p>
 * <p>
 *     You can configure the Manager's behavior in your {@code sbge.ini} file.
 *     You can find the setup instructions on the <a href="https://github.com/infjava/shapesge/wiki">ShapesGE Wiki on GitHub</a>.
 * </p>
 * <p>You can create and use multiple Managers throughout your game.</p>
 * <p>
 *     <u>IMPORTANT NOTE:</u> It is possible to make a single object managed multiple times, either by the same Manager, or multiple different Managers.
 *     This may lead to unexpected behavior, for example:
 *     <ul>
 *         <li>Your character takes two or more steps on one keypress.</li>
 *         <li>Objects move through the game's window faster than they should.</li>
 *         <li>More objects than expected are created on keypress.</li>
 *         <li>Basically, all other quirks in input and timing.</li>
 *     </ul>
 * </p>
 *
 * @author Ján Janech
 * @version 1.0  (9.11.2022)
 */
@SuppressWarnings("unused")
public class Manager {
    /**
     * Create a new Manager.
     * This Manager doesn't manage any objects yet.
     * <p>
     *     Use {@link Manager#manageObject} to enable object management.
     * </p>
     */
    public Manager() {

    }

    /**
     * Register an object to be managed by the manager.
     * @param object the object to be managed.
     *               <p>Once the object is managed, {@code Manager} will send it messages defined in {@code sbge.ini}. </p>
     * @implNote It is possible to make a single object managed multiple times.
     *           See the "Important Note" in {@link Manager} class description for more information.
     */
    public void manageObject(Object object) {
        Game.getGame().registerEventTarget(object);
    }

    /**
     * Stop the Manager from managing an object.
     * @param object the object to be removed from management.
     */
    public void stopManagingObject(Object object) {
        Game.getGame().deregisterEventTarget(object);
    }
}
