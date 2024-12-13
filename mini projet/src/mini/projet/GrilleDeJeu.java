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
        for (int k = 0; k < nbLignes; k++) {
            for (int i = 0; i < nbColonnes; i++) {
                this.matriceCellules[k][i] = new Cellule();
            }
        }
        this.random = new Random();
    }

    //getter
    public int getNbLignes() {
        return nbLignes;
    }

    public Cellule getCase(int ligne, int colonne) {
        return matriceCellules[ligne][colonne];
    }

    public int getNbColonnes() {
        return nbColonnes;
    }

    public int getNbBombes() {
        return nbBombes;
    }

    public boolean getPresenceBombe(int i, int j) {
        return matriceCellules[i][j].getPresenceBombe();
    }

    //setter
    public void SetNbBombes(int nombre) {
        this.nbBombes = nombre;
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

    //calcul nombre bombe adj pour chaque case
    public void calculerBombesAdj() {
        //parcours de la grille de jeu
        for (int ligne = 0; ligne < this.nbLignes; ligne++) {
            for (int colonne = 0; colonne < this.nbColonnes; colonne++) {
                //tester si pas de bombe sur la case
                if (matriceCellules[ligne][colonne].getPresenceBombe() == false) {
                    int bombesAutour = BombesAutour(ligne, colonne);
                    //MAJ nbBombesAdj à la case donnée
                    matriceCellules[ligne][colonne].SetBombesAutour(bombesAutour);
                }
            }
        }
    }

    //fonction secondaire
    //calcul nbr bombe adj à telle case
    public int BombesAutour(int ligne, int colonne) {
        int sommeBombes = 0;
        for (int i = -1; i <= 1; i++) { //parcours lignes autour
            for (int j = -1; j <= 1; j++) { //parcours colonnes autour
                if (i == 0 && j == 0) {
                    continue; //ignorer la case centrale
                }
                int voisinLigne = ligne + i;
                int voisinColonne = colonne + j;

                if (voisinLigne >= 0 && voisinLigne < nbLignes && voisinColonne >= 0 && voisinColonne < nbColonnes) {
                    if (matriceCellules[voisinLigne][voisinColonne].getPresenceBombe()) { // test présence bombe sur cases adjointes
                        sommeBombes += 1;
                    }
                }
            }
        }
        return sommeBombes;
    }

    //revele la case donnée
    //retourne un booléen si le joueur a perdu ou non
    public boolean revelerCellule(int ligne, int colonne) {
        //verifier si cellule devoilee
        if (!matriceCellules[ligne][colonne].getdevoilee()) {
            //révélater la case
            matriceCellules[ligne][colonne].revelerCellule();

            //verification presence bombe
            if (matriceCellules[ligne][colonne].getPresenceBombe()) {
                return false;
            }
            //verification si il y a des bombes adjacentes
            if (matriceCellules[ligne][colonne].getBombesAutour() == 0) {
                //parcours des cases adjacentes
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        } //ignorer la case centrale

                        int voisinLigne = ligne + i;
                        int voisinColonne = colonne + j;
                        //verification si case dans les bornes
                        if (voisinLigne >= 0 && voisinLigne < nbLignes && voisinColonne >= 0 && voisinColonne < nbColonnes) {
                            revelerCellule(voisinLigne, voisinColonne); // appel récursif
                        }

                    }
                }
            }
        }
        return true;
    }

    //vérifie si toutes cellules sans bombes sont revelées
    public boolean toutesCellulesRevelees() {
        //parcours des cases de la grille
        for (int ligne = 0; ligne < nbLignes; ligne++) {
            for (int colonne = 0; colonne < nbColonnes; colonne++) {
                //test si case sans bombe et pas dévoilée
                if (!matriceCellules[ligne][colonne].getPresenceBombe() && !matriceCellules[ligne][colonne].getdevoilee()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String Affichage = "";
        //1ere ligne
        for (int k = 0; k < nbLignes; k++) {
            Affichage += " -";
        }
        Affichage += "\n|";
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (!matriceCellules[i][j].getdevoilee()) {
                    //Affichage += "?";
                    Affichage += "■";
                } else if (matriceCellules[i][j].getPresenceBombe()) {
                    Affichage += "B";
                } else if (matriceCellules[i][j].getBombesAutour() > 0) {
                    Affichage += matriceCellules[i][j].getBombesAutour() + "";
                } else {
                    Affichage += " ";
                }
                Affichage += "|";
            }
            Affichage += "\n";
            for (int k = 0; k < nbLignes; k++) {
                Affichage += " -";
            }
            if (i != nbLignes - 1) {
                Affichage += "\n|";
            }
        }
        return Affichage;
    }
}
