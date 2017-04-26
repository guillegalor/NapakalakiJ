/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author johanna
 */
public class Dice {
    
    private static Dice instance = null;
    
    private Dice() { }
    
    public static Dice getInstance() {
        if(instance == null)
            instance = new Dice();
        
        return instance;
    }
    
    public int nextNumber(){
        int valorDado = (int) Math.floor(Math.random()*6);
        return valorDado;
    }
}
