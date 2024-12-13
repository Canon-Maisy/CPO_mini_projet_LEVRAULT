/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini.projet;

import java.util.Scanner;

/**
 *
 * @author Maxime
 */
public class Partie {

    private GrilleDeJeu vache;
    //private int NbVie;
    //private String EtatPartie;

    public Partie(GrilleDeJeu grille) {
        this.vache = grille;
    }

    Scanner scanner = new Scanner(System.in);

    public int[] Difficulte() {
        //demande au joueur la difficultée voulue
        //retourne la taille de la grille et le nombre de bombes
        System.out.println("Choisissez votre difficultée: facile => 1, moyen => 2 et difficile => 3.");
        int input = scanner.nextInt(); //input utilisateur

        //vérification input
        while (input != 1 && input != 2 && input != 3) {
            System.out.println("choix invalide, recommencez.");
            input = scanner.nextInt();
        }
        switch (input) {
            case 1:
                return new int[]{6, 7};
            case 2:
                return new int[]{9, 17};
            default:
                return new int[]{16, 45};
        }
    }

    public GrilleDeJeu initialiserPartie(int nbLignes, int nbColonnes, int nbBombes) {
        this.vache = new GrilleDeJeu(nbLignes, nbColonnes);
        this.vache.SetNbBombes(nbBombes);
        this.vache.placerBombesAléa();
        this.vache.calculerBombesAdj();
        return this.vache;
    }
    
    
    public int[] inputCoos(){
        System.out.println("ligne :");
        int ligne = scanner.nextInt();
        System.out.println("colonne :");
        int colonne = scanner.nextInt();
        return new int[] {ligne, colonne};
    }
    
    public void tourDeJeu(){
        int[] coos = inputCoos();
    }

    @Override
    public String toString() {
        return vache.toString();
    }

}
