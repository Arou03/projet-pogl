package Modele.Zones;

public class Oasis extends MZone {
    static final int quantity = 3;
    static int restant = 0;
    public Oasis(int x, int y) {
        super(x, y);
        restant--;
    }
}
