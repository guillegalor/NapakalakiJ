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
public class Monster {
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence badConsequence;
    private int levelChangeAgainstCultistPlayer;
    
    public Monster(String n, int l, BadConsequence b, Prize p){
        name = n;
        combatLevel = l;
        badConsequence = b;
        prize = p;
        levelChangeAgainstCultistPlayer = 0;
    }
    
    public Monster(String n, int l, BadConsequence b, Prize p, int lC){
        name = n;
        combatLevel = l;
        badConsequence = b;
        prize = p;
        levelChangeAgainstCultistPlayer = lC;
    }
    
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return combatLevel;
    }
    
    public int getCombatLevelAgainstCultistPlayer(){
        return (getCombatLevel() + levelChangeAgainstCultistPlayer);
    }
    
    public BadConsequence getBadConsequence(){
        return badConsequence;
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
        
    @Override
    public String toString(){
        return "\nName: " + name + "\nLevel: " + Integer.toString(combatLevel) + "\nPrize: " + prize.toString().replaceAll("(?m)^", "\t") + "\nBadConsequence: " + badConsequence.toString().replaceAll("(?m)^", "\t");
    }
}

