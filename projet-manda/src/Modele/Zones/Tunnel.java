package Modele.Zones;

public class Tunnel extends MZone {
    static final int quantity = 3;
    static int restant = 0;
    public Tunnel(int x, int y) {
        super(x, y);
        restant--;
    }
}
