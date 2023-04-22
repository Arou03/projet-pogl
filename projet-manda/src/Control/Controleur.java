package Control;

import Modele.MGrille;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur implements ActionListener {
    MGrille modele;

    public Controleur(MGrille modele) {
        super();
        this.modele = modele;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        modele.finDeTour();
        System.out.println("le bouton est appuyé!!");
    }
}
