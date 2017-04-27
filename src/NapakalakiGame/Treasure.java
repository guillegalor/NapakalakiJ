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
class Treasure {
    private String name;
    private int bonus;
    private TreasureKind type;
    
    public Treasure(String n, int b, TreasureKind t){
        name = n;
        bonus = b;
        type = t;
    }
    
    public String getName(){
        return name;
    }
    
    public int getBonus(){
        return bonus;
    }
    
    public TreasureKind getType(){
        return type;
    }
    
    public String toString(){
        return "\n" + name + "\nBonus:" + Integer.toString(bonus) + "\nTipo:" + type;
    }
}
