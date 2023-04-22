package Modele.Zones;

public abstract class MZone {
    int x;
    int y;

    private int sable;

    public boolean dejaExploree;

    public MZone(int x, int y) {
        this.x = x;
        this.y = y;
        dejaExploree = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isDejaExploree() {
        return dejaExploree;
    }

    public void addSable(int quantite) {
        this.sable += quantite;
    }

    public void removeSable(int quantite) {
        this.sable = Math.max(this.sable - quantite, 0);
    }

    public int getSable() {
        return sable;
    }

    public void setCoord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "X";
    }
}
