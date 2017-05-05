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
public class Prize {
    private int treasures;
    private int levels;
    
    public Prize(int mytreasures, int mylevel){
        treasures = mytreasures;
        levels = mylevel;        
    }
    
    public int getTreasures(){
        return treasures;
    }
    
    public int getLevels(){
        return levels;
    }
    
    public String toString(){
        return "\nTreasures = " + Integer.toString(treasures) + "\nLevels = " + Integer.toString(levels);
    }
}
