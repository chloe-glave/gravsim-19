package interfaces;

import javafx.scene.shape.Shape;

/**
 * The SpatialEntity Interface
 *
 * @author Chloe Glave
 * @author Janelle Kwok
 * @author Keegan Maundrell
 * @author Kayden Schmidt
 *
 * @version 2020
 */
public interface SpatialEntity {
    /**
     * Gets the Shape of the SpatialEntity.
     *
     * @return The Shape of the SpatialEntity.
     */
    Shape getShape();

    /**
     * Sets the X to whatever value in passed as a parameter.
     *
     * @param x The x value to be changed into.
     */
    void setX(double x);

    /**
     * Sets the Y to whatever value in passed as a parameter.
     *
     * @param y The y value to be changed into.
     */
    void setY(double y);

    /**
     * Gets the X of the SpatialEntity.
     *
     * @return The X of the SpatialEntity.
     */
    double getX();

    /**
     * Gets the Y of the SpatialEntity.
     *
     * @return The Y of the SpatialEntity.
     */
    double getY();
}
