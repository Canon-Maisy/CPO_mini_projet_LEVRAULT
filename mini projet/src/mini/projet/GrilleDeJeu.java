/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini.projet;

import java.util.Random;

/**
 *
 * @author Maxime
 */
public class GrilleDeJeu {

    private Cellule[][] matriceCellules;
    private int nbLignes;
    private int nbColonnes;
    private int nbBombes;
    private Random random; //generateur nombres aléatoires

    //constructeur
    public GrilleDeJeu(int lignes, int colonnes) {
        this.nbLignes = lignes;
        this.nbColonnes = colonnes;

        this.matriceCellules = new Cellule[nbLignes][nbColonnes];
        this.random = new Random();
    }

    //getter
    public int getNbLignes() {
        return nbLignes;
    }

    public int getNbColonnes() {
        return nbColonnes;
    }

    public int getNbBombes() {
        return nbBombes;
    }

    //placement des bombes aléatoirement
    public void placerBombesAléa() {
        int compteur = nbBombes;
        while (compteur > 0) {
            //coordonnées de la grille aléatoires
            int ligne = random.nextInt(nbLignes);
            int colonne = random.nextInt(nbColonnes);

            //si aucune bombe, placement bombe
            if (matriceCellules[ligne][colonne].getPresenceBombe() == false) {
                matriceCellules[ligne][colonne].placerBombe();
                compteur -= 1;
            }
        }
    }

    public void calculerBombesAdj() {
        //parcours de la grille de jeu
        for (int ligne = 0; ligne < this.nbLignes; ligne++) {
            for (int colonne = 0; colonne < this.nbColonnes; colonne++) {
                //tester si pas de bombe sur la case
                if (matriceCellules[ligne][colonne].getPresenceBombe() == false) {
                    int bombesAutour = BombesAutour(matriceCellules, ligne, colonne);
                    //MAJ nbBombesAdj à la case donnée
                    matriceCellules[ligne][colonne].SetBombesAutour(bombesAutour);
                }
            }
        }
    }

    public int BombesAutour(Cellule[][] tableau, int ligne, int colonne) {
        int sommeBombes = 0;
        for (int i = -1; i <= 1; i++) { //parcours lignes autour
            for (int j = -1; j <= 1; j++) { //parcours colonnes autour
                if (i == 0 || j == 0) {
                    continue; //ignorer la case centrale
                }
                int voisinLigne = ligne + i;
                int voisinColonne = colonne + j;


                if (voisinLigne >= 0 && voisinLigne < tableau.length && voisinColonne >= 0 && voisinColonne < tableau[voisinLigne].length) {
                    if (tableau[ligne][colonne].getPresenceBombe()) { // test présence bombe sur cases adjointes
                        sommeBombes += 1;
                    }
                }
            }
        }
        return sommeBombes;
    }

}
