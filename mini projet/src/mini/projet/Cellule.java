/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini.projet;

/**
 *
 * @author Maxime
 */
public class Cellule {

    private boolean presenceBombe;
    private boolean devoilee;
    private int bombesAutour;

    //presence Bombe
    //getter
    public boolean getPresenceBombe() {
        return presenceBombe;
    }

    //setter
    public void placerBombe() {
        presenceBombe = true;
    }

    //bombes autour
    //getter
    public int getBombesAutour() {
        return bombesAutour;
    }

    //setter
    public void SetBombesAutour(int nbbombesAutour) {
        this.bombesAutour = nbbombesAutour;
    }

    //reveler cellule
    //setter
    public boolean getdevoilee(){
        return devoilee;
    }
    
    //getter
    public void revelerCellule() {
        devoilee = true;
    }

    //toString
    @Override
    public String toString() {
        if (!devoilee) {
            return "?"; //pas dévoilée
        } else if (presenceBombe) {
            return "B"; //dévoilée + bombe
        } else if (bombesAutour > 0) {
            return bombesAutour + ""; //dévoilée + pas de bombes
        } else {
            return " "; //dévoilée + pas de bombes + 0 bombes adjacentes
        }
    }
}
