package Modele.Zones;

public class Piste extends MZone {
    static final int quantity = 1;
    static int restant = 0;
    public Piste(int x, int y) {
        super(x, y);
        restant--;
    }
}
