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

    /*public Partie(GrilleDeJeu grille) {
        this.vache = grille;
    }*/

    Scanner scanner = new Scanner(System.in);

    public int[] Difficulte() {
        //demande au joueur la difficultée voulue
        //retourne la taille de la grille et le nombre de bombes
        System.out.println("Choisissez votre difficultée: facile => 1, moyen => 2 et difficile => 3.");
        int input = scanner.nextInt(); //input utilisateur

        //vérification input
        while (input != 1 && input != 2 && input != 3 ) {
            System.out.println("choix invalide, recommencez.");
            input = scanner.nextInt();
        }
        switch (input) {
            case 1:
                return new int[]{6,7};
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

    public int[] inputCoos() {
        
        System.out.println("ligne :");
        int ligne = scanner.nextInt() - 1;
        System.out.println("colonne :");
        int colonne = scanner.nextInt() - 1;
        return new int[]{ligne, colonne};
        /*
        System.out.println("entrez les coordonnées (ligne, colonne) : ");
        String input = scanner.nextLine(); //saisie
        String[] parts = input.split("//s*,//s*"); // lecture ligne prise en charge virgule
        int ligne = Integer.parseInt(parts[0]) - 1;
        int colonne = Integer.parseInt(parts[1]) - 1;
        return new int[] {ligne, colonne};*/
    }

    public boolean tourDeJeu() {
        // demande des coordonnées de case au joueur
        int[] coos = inputCoos();
        //revele la case
        //si bombe revelee => return false
        vache.revelerCellule(coos[0],coos[1]);
        if (vache.getPresenceBombe(coos[0], coos[1])){
            return false;
        }
        return true;
    }
    
    public boolean Victoire(){
        return vache.toutesCellulesRevelees();
    }
    
    public void demarrerPartie(){
        int[] difficulte = Difficulte();
        initialiserPartie(difficulte[0], difficulte[0], difficulte[1]);
        System.out.println(vache);
        
        boolean test = true;
        while (test){
            test = tourDeJeu();
            System.out.println(vache);
            if (test == true){
                test = !Victoire();
            }
            System.out.println("test : " + test);
        }
        System.out.println("fin de partie :)");
    }

    @Override
    public String toString() {
        return vache.toString();
    }

}
