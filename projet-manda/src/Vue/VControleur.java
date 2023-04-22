package Vue;

import Control.Controleur;
import Modele.MGrille;

import javax.swing.*;

public class VControleur extends JPanel {
    MGrille modele;

    public VControleur(MGrille modele) {
        JButton boutonFDT = new JButton("Fin de tour");
        this.add(boutonFDT);
        Controleur ctrl = new Controleur(modele);
        boutonFDT.addActionListener(ctrl);
    }
}
