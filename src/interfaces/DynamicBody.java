package interfaces;

/**
 * The DynamicBody Interface
 *
 * @author Chloe Glave
 * @author Janelle Kwok
 * @author Keegan Maundrell
 * @author Kayden Schmidt
 *
 * @version 2020
 */
public interface DynamicBody extends PhysicalBody {
    /**
     * Gets the Vx of the DynamicBody object.
     *
     * @return Vx of DynamicBody Object.
     */
    double getVx();
    /**
     * Gets the Vy of the DynamicBody object.
     *
     * @return Vy of DynamicBody Object.
     */
    double getVy();
    /**
     * Adds the Vx of the DynamicBody object.
     *
     * @param num The num to be added to Vx.
     */
    void addVx(double num);
    /**
     * Adds the Vy of the DynamicBody object.
     *
     * @param num The num to be added to Vy.
     */
    void addVy(double num);
    /**
     * Moves the DynamicBody object.
     */
    void move();
}
