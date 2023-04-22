package Desert_Interdit;

import Modele.MGrille;
import Vue.VControleur;
import Vue.VGrille;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {
    public static Random random;
    static JFrame fenetre;
    static MGrille modele;
    static VGrille vueGrille;
    static VControleur vueControleur;
    public final static int taille = 5;
    public static void main(String[] args) {
        random = new Random();
        modele = new MGrille();
        initFenetre();
    }

    private static void initFenetre() {
        vueGrille = new VGrille(modele);
        vueControleur = new VControleur(modele);
        fenetre = new JFrame("Desert Interdit");
        fenetre.getContentPane().add(vueGrille);
        fenetre.getContentPane().add(vueControleur);
        fenetre.setLayout(new GridLayout());
        fenetre.pack();
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
