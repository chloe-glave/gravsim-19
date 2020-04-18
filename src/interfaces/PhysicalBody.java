package interfaces;

/**
 * The PhysicalBody Interface
 *
 * @author Chloe Glave
 * @author Janelle Kwok
 * @author Keegan Maundrell
 * @author Kayden Schmidt
 *
 * @version 2020
 */
public interface PhysicalBody extends SpatialEntity {
    /**
     * Gets the mass of the PhysicalBody.
     *
     * @return The mass of the PhysicalBody.
     */
    double getMass();

    /**
     * Gets the destructibility of the PhysicalBody.
     *
     * @return The destructibility of the PhysicalBody.
     */
    boolean getDestructible();
}
