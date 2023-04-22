package Modele.Zones;

public class Oeil extends MZone {
    static final int quantity = 1;
    static int restant = 0;
    public Oeil(int x, int y) {
        super(x, y);
        dejaExploree = true;
        restant--;
    }

    @Override
    public String toString() {
        return " ";
    }
}
