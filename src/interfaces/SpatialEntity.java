package interfaces;

import javafx.scene.shape.Shape;

public interface SpatialEntity {
    Shape getShape();
    void setX();
    void setY();
    double getX();
    double getY();
}
