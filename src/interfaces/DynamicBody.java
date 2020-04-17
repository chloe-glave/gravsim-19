package interfaces;

public interface DynamicBody extends PhysicalBody {
    double getVx();
    double getVy();
    void addVx(double num);
    void addVy(double num);
    void move();
}
