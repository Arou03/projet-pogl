package Modele.Zones;

public class Desert extends MZone {
    static final int quantity = 8;
    static int restant = 0;
    public Desert(int x, int y) {
        super(x, y);
        restant--;
    }
}


