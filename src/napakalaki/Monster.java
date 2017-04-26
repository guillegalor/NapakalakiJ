/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author johanna
 */
public class Monster {
    private String name;
    private int combatLevel;
    
    private Prize prize;
    private BadConsequence badconsequence;
    
    public Monster(String n, int l, BadConsequence b, Prize p){
        name = n;
        combatLevel = l;
        badconsequence = b;
        prize = p;
    }
    
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return combatLevel;
    }
    
    public BadConsequence getBadConsequence(){
        return badconsequence;
    }
    
    public int getLevelsGained(){
        return prize.getLevels();
    }
    
    public int getTreasuresGained(){
        return prize.getTreasures();
    }
    
    public Prize getPrize(){
        return prize;
    }
        
    public String toString(){
        return "Nombre : " + name + "Level Combat: " + Integer.toString(combatLevel) + "Prize: " + prize.toString() + "BadConsequence: " + badconsequence.toString();
    }
}

