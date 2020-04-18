package interfaces;

import javafx.scene.shape.Shape;

public interface SpatialEntity {
    Shape getShape();
    void setX(double x);
    void setY(double y);
    double getX();
    double getY();
}
