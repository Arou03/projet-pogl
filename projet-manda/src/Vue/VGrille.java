package Vue;

import Desert_Interdit.Main;
import Modele.*;
import Modele.Zones.*;
import Tools.Observer;

import javax.swing.*;
import java.awt.*;

public class VGrille extends JPanel implements Observer {
    int cote;
    int decallage;
    private MGrille modele;
    public VGrille(MGrille modele) {
        this.modele = modele;
        this.cote = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/7;
        this.decallage = cote/20;
        this.setPreferredSize(new Dimension(cote * 5 + decallage * 4, cote * 5 + decallage * 4));
        this.setBackground(new Color(77, 38, 0));
        modele.addObserver(this);
    }
    @Override
    public void update() {
        repaint();
        System.out.println("On update bien!");
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < Main.taille; i++) {
            for (int j = 0; j < Main.taille; j++) {
                paintZone(g, modele.getZone(i, j));
            }
        }
        System.out.println("Ca repaint!!");
    }

    private void paintZone(Graphics g, MZone mZone) {
        if(!(mZone instanceof Oeil)) {
            if (mZone.dejaExploree) {
                if (mZone instanceof Crash) {
                    g.setColor(Color.getHSBColor(0, 0, 1));
                } else if (mZone instanceof Indice) {
                    g.setColor(Color.getHSBColor(0, 0, 1));
                } else if (mZone instanceof Oasis) {
                    g.setColor(Color.getHSBColor(0, 0, 1));
                } else if (mZone instanceof Piste) {
                    g.setColor(Color.getHSBColor(0, 0, 1));
                } else if (mZone instanceof Tunnel) {
                    g.setColor(Color.getHSBColor(0, 0, 1));
                } else if (mZone instanceof Desert) {
                    g.setColor(Color.getHSBColor(0, 0, 1));
                }
            } else {
                g.setColor(new Color(255 - Math.min(255, mZone.getSable() * 255/2),
                                     224 - Math.min(224, mZone.getSable() * 224/2),
                                     102 - Math.min(102, mZone.getSable() * 102/2)
                ));
            }
            g.fillRect(mZone.getX() * (cote + decallage), mZone.getY() * (cote + decallage), cote, cote);
        }
    }
}

