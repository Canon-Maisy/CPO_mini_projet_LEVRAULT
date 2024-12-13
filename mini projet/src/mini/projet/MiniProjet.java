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

        Partie game = new Partie(miaou);
        int[] diff = game.Difficulte();
        game.initialiserPartie(diff[0], diff[0], diff[1]);
        System.out.println(game);

        boolean test = true;
        while (test) {
            game.tourDeJeu();
            System.out.println(game);
            test = !game.Victoire();
            System.out.println("test : " + test);
        }

        System.out.println("fin de partie");
    }
}
