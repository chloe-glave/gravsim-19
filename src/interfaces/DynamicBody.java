package interfaces;

public interface DynamicBody extends PhysicalBody {
    double getVx();
    double getVy();
    void addVx();
    void addVy();
    void move();
}
