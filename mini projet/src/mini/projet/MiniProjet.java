/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mini.projet;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Maxime
 */
public class MiniProjet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //test classe GrilleDeJeu
        GrilleDeJeu miaou = new GrilleDeJeu(5, 5);

        //Boucle principale de jeu
        boolean Victoire = false;
        /*while (!Victoire) {
            System.out.println("ligne");
            int ligneChoisie = scanner.nextInt();
            System.out.println("colonne");
            int colonneChoisie = scanner.nextInt();
            
            //verifier si ligne/colonne entrée dans les bornes
            //vérifier si cellule dévoilée
            //si non, devoiler cellule
            //si bombe, break
            /*System.out.println(miaou.getCase(ligneChoisie, colonneChoisie));
            if (!miaou.getCase(ligneChoisie, colonneChoisie).getDevoilee()){
                break;
            }
            
        }//Fin du while
        */
        //miaou.revelerCellule(1, 1);
        //System.out.println(miaou);
        Partie zasdfgh = new Partie(miaou);
        int[] diff = zasdfgh.Difficulte();
        int[] coos = zasdfgh.inputCoos();
        System.out.println(Arrays.toString(coos));
        zasdfgh.initialiserPartie(diff[0], diff[0], diff[1]);
        // System.out.println(zasdfgh);
    }
}
