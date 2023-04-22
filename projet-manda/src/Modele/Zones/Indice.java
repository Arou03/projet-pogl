package Modele.Zones;

public class Indice extends MZone {
    static final int quantity = 8;
    static int restant = 0;
    public Indice(int x, int y) {
        super(x, y);
        restant--;
    }
}
