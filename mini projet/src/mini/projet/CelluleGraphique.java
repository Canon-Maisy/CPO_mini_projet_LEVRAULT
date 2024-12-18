/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini.projet;

import java.awt.Graphics;
import javax.swing.JButton;

/**
 *
 * @author Maxime
 */
public class CelluleGraphique extends JButton {
    Cellule cellule;
    int x;
    int y;

    public CelluleGraphique(Cellule Case, int x, int y) {
        this.cellule = Case;
        this.x = x;
        this.y = y;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (!cellule.getdevoilee()){
            this.setText("?");
        } else if (cellule.getPresenceBombe()){
            this.setText("B");
        } else if (cellule.getBombesAutour() > 0){
            this.setText(cellule.getBombesAutour() + "");
        } else {
            this.setText(" ");
        }
        
    }
    
}
