/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mini.projet;

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

        //test classe cellule
        /*Cellule wouaf = new Cellule();
        System.out.println("1: " + wouaf);

        //révelement cellule
        wouaf.revelerCellule();
        System.out.println("2: " + wouaf);

        //bombes autour
        wouaf.SetBombesAutour(6);
        System.out.println("4: " + wouaf);

        //placement bombe
        wouaf.placerBombe();
        System.out.println("3: " + wouaf);*/
        //test classe GrilleDeJeu
        GrilleDeJeu miaou = new GrilleDeJeu(5, 5);
        miaou.SetNbBombes(6);
        miaou.placerBombesAléa();
        miaou.calculerBombesAdj();

        //Boucle principale de jeu
        boolean Victoire = false;
        /*while (Victoire){
            int ligneChoisie = scanner.nextInt();
            int colonneChoisie = scanner.nextInt();
            
            boolean celluleSure = miaou.revelerCellule(ligneChoisie, colonneChoisie);
            
            if (!celluleSure){
                System.out.println("Boom");
                break;
            }
            Victoire = miaou.toutesCellulesRevelees();
            if (Victoire){
                System.out.println("gagné");
            }
        }*/

        while (!Victoire) {
            System.out.println("ligne");
            int ligneChoisie = scanner.nextInt();
            System.out.println("colonne");
            int colonneChoisie = scanner.nextInt();
            
            //verifier si ligne/colonne entrée dans les bornes
            //vérifier si cellule dévoilée
            //si non, devoiler cellule
            //si bombe, break
            System.out.println(miaou.getCase(ligneChoisie, colonneChoisie));
            if (!miaou.getCase(ligneChoisie, colonneChoisie).getDevoilee()){
                break;
            }
            
        }//Fin du while

        //miaou.revelerCellule(1, 1);
        System.out.println(miaou);
    }
}
