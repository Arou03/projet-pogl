package Modele;

import Modele.Zones.MZone;
import Modele.Zones.Oeil;
import Modele.Zones.Desert;
import Tools.Observable;

public class MGrille extends Observable {
    MZone[][] grille;
    int crashX, crashY;
    int oeilX, oeilY;
    int[][] directions;
    int totalSable;

    int nbJoueur;
    Joueur[] joueurs;

    public MGrille() {
        grille = new MZone[5][5];

        for (int i = 0; i < Desert_Interdit.Main.taille; i++) {
            for (int j = 0; j < Desert_Interdit.Main.taille; j++) {
                if (i == 2 && j == 2) {
                    grille[i][j] = new Oeil(i, j);
                    oeilX = i;
                    oeilY = j;
                } else
                    grille[i][j] = new Desert(i, j);
                if (i == 0 && j == 2 ||
                        i == 1 && j == 1 ||
                        i == 1 && j == 3 ||
                        i == 2 && j == 0 ||
                        i == 2 && j == 4 ||
                        i == 3 && j == 1 ||
                        i == 3 && j == 3 ||
                        i == 4 && j == 2)
                    addSable(grille[i][j], 1);
            }
        }

        nbJoueur = 4;
        joueurs = new Joueur[nbJoueur];
        for (int i = 0; i < nbJoueur; i++) {
            joueurs[i] = new Joueur(crashX, crashY, i);
        }

        System.out.println(this);

        directions = new int[4][2];
        directions[0] = new int[]{-1, 0};
        directions[1] = new int[]{1, 0};
        directions[2] = new int[]{0, -1};
        directions[3] = new int[]{0, 1};
    }

    void addSable(MZone mZone, int quantite) {
        mZone.addSable(quantite);
        totalSable += quantite;
    }

    public void finDeTour() {
        ventSouffle();
        notifyObservers();
    }

    void ventSouffle() {
        int f = Desert_Interdit.Main.random.nextInt(1, 4);
        int[] d = directions[Desert_Interdit.Main.random.nextInt(0, 4)];
        MZone tmp;
        int x, y;
        if (d[1] != 0) {
            for (int i = 1; i <= f; i++) {
                y = oeilY + d[1];
                if (y >= 0 && y < 5) {
                    addSable(grille[oeilX][y], 1);

                    tmp = grille[oeilX][y];
                    grille[oeilX][y] = grille[oeilX][oeilY];
                    grille[oeilX][oeilY] = tmp;

                    tmp.setCoord(oeilX, oeilY);
                    grille[oeilX][y].setCoord(oeilX, y);
                    oeilY = y;
                }
            }
        } else {
            for (int i = 1; i <= f; i++) {
                x = oeilX + d[0];
                if (x >= 0 && x < 5) {
                    addSable(grille[x][oeilY], 1);

                    tmp = grille[x][oeilY];
                    grille[x][oeilY] = grille[oeilX][oeilY];
                    grille[oeilX][oeilY] = tmp;

                    tmp.setCoord(oeilX, oeilY);
                    grille[x][oeilY].setCoord(x, oeilY);
                    oeilX = x;
                }
            }
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                res += grille[j][i].toString();
            }
            res += "\n";
        }
        return res;
    }

    public MZone getZone(int x, int y) {
        return grille[x][y];
    }
}
