package Modele.Zones;

public class Crash extends MZone {
    static final int quantity = 8;
    static int restant = 0;
    public Crash(int x, int y) {
        super(x, y);
        restant--;
    }
}
