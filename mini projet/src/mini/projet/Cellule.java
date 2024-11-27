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
    
    /*
        constructeur vraiment utile ?
        bool initialisé par defaut à false
        bombesAutour à voir apres.
    public Cellule(int bombesAutour){
        this.presenceBombe = false;
        this.devoilee = false;
        this.bombesAutour = bombesAutour;
    }*/
    
    //getters
    public boolean getPresenceBombre(){
        return presenceBombe;
    }
    public int getBombesAutour(){
        return bombesAutour;
    }
    
    //changer le statut de la bombe
    public void placerBombe(){
        presenceBombe = true;
    }
    
    public void revelerCellule(){
        devoilee = true;
    }
    
    //setter
    public void SetBombesAutour(int bombesAutour){
        this.bombesAutour = bombesAutour;
    }
}
