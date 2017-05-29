/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import GUI.Dice;
import java.awt.Frame;


/**
 *
 * @author johanna, guille
 */
public class Player {
    private String name;
    private int level;
    private boolean death;
    private boolean canISteal;
    private Player enemy;
    private BadConsequence pendingBadConsequence;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    static int MAXLEVEL = 3;
    
    public Player(String n){
        name = n;
        level = 1;
        death = true;
        canISteal = true;
        enemy = null;
        pendingBadConsequence = null;
        hiddenTreasures = new ArrayList();
        visibleTreasures = new ArrayList();
    }
    
    public Player(Player p){
        name = p.name;
        level = p.level;
        death = p.death;
        canISteal = p.canISteal;
        enemy = p.enemy;
        pendingBadConsequence = p.pendingBadConsequence;
        hiddenTreasures = p.hiddenTreasures;
        visibleTreasures = p.visibleTreasures;
    }
    
    public String getName(){
        return name;
    }
    
    public BadConsequence getPendingBadConsequence(){
        return pendingBadConsequence;
    }
    
    private void bringToLife(){
        death = false;
    }
    
    private void incrementLevels(int i){
        level = Integer.min(MAXLEVEL, level+i);
    }
    
    private void decrementLevels(int i){
        level = Integer.max(1, level-i);
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        pendingBadConsequence = b;
    }
    
    private void applyPrize(Monster m){
        int nLevels = m.getLevelsGained();
        incrementLevels(nLevels);
        
        int nTreasures = m.getTreasuresGained();
        CardDealer dealer = CardDealer.getInstance();
        Treasure treasure;
        
        for(int i=0; i<nTreasures; i++){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }
    
    private void applyBadConsequence(Monster m){
        BadConsequence badConsequence = m.getBadConsequence();
        int nLevels = badConsequence.getLevels();
        
        decrementLevels(nLevels);
        BadConsequence pendingBad = badConsequence.adjustToFitTreasureList(visibleTreasures, hiddenTreasures);
        setPendingBadConsequence(pendingBad);
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
        if(visibleTreasures.size() >= 4)
            return false;
        else{
            if(t.getType() == TreasureKind.ONEHAND)
                if((howManyVisibleTreasure(t.getType()) > 1) || (howManyVisibleTreasure(TreasureKind.BOTHHANDS) > 0))
                    return false;
                else
                    return true;
            else{
                if(t.getType() == TreasureKind.BOTHHANDS)
                    if(howManyVisibleTreasure(TreasureKind.ONEHAND) > 0)
                        return false;
                
                if(howManyVisibleTreasure(t.getType()) > 0)
                    return false;
                else
                    return true;
            }
                             
        }
    }
    
    private int howManyVisibleTreasure(TreasureKind tKind){
        int contador = 0;
        for(Treasure i:visibleTreasures){
            if(i.getType() == tKind)
                contador ++;
        }
        
        return contador;
    }
    
    private void dieIfNoTreasures(){
        if (hiddenTreasures.isEmpty() && visibleTreasures.isEmpty()) {
            death = true;
        }
    }
    
    public boolean isDead(){
        return death;
    }
    
    protected Player getEnemy(){
        return enemy;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
       return visibleTreasures;
    }
    
    public CombatResult combat(Monster m){
       int myLevel = getCombatLevel();
       int monsterLevel = getOponentLevel(m);
       
       if(!canISteal()){
           Dice dice = Dice.getInstance();
           int number = dice.nextNumber();
           
           if(number < 3){
           int enemyLevel = enemy.getCombatLevel();
           monsterLevel += enemyLevel;
           }
       }
       
       CombatResult combatResult;
       
       if(myLevel > monsterLevel){
           applyPrize(m);
           if(level >= MAXLEVEL)
               combatResult = CombatResult.WINGAME;
           else
               combatResult = CombatResult.WIN;
       }else{
           applyBadConsequence(m);
           if (shouldConvert()) 
               combatResult = CombatResult.LOSEANDCONVERT;
           else
               combatResult = CombatResult.LOSE;
       }
       
       return combatResult;
    }
    
    public void makeTreasureVisible(Treasure t){
       boolean canI = canMakeTreasureVisible(t);
       if(canI){
           visibleTreasures.add(t);
           hiddenTreasures.remove(t);
       }
    }
    
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        
        if(pendingBadConsequence != null && !pendingBadConsequence.isEmpty())
            pendingBadConsequence.substractVisibleTreasure(t);
        
        dieIfNoTreasures();
    }
    
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        
        if(pendingBadConsequence != null && !pendingBadConsequence.isEmpty())
            pendingBadConsequence.substractHiddenTreasure(t);
        
        dieIfNoTreasures();
    }
    
    public boolean validState(){
        return (pendingBadConsequence == null || pendingBadConsequence.isEmpty()) && hiddenTreasures.size() <= 4;
    }
    
    public void initTreasures(){
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        
        bringToLife();
        
        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        
        int number = dice.nextNumber();
        
        if(number > 1){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        
        if(number == 6){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }
    
    public int getLevels(){
        return level;
    }
    
    public Treasure stealTreasure(){
       boolean canI = canISteal();
       Treasure treasure = null;
       
       if(canI){
           boolean canYou = enemy.canYouGiveMeATreasure();
           if(canYou){
               treasure = enemy.giveMeATreasure();
               hiddenTreasures.add(treasure);
               haveStolen();
           }
       }
       
       return treasure;
    }
    
    public void setEnemy(Player e){
        enemy = e;
    }
    
    protected Treasure giveMeATreasure(){
        Random rand = new Random();
        return hiddenTreasures.remove(rand.nextInt(hiddenTreasures.size()));
    }
    
    public boolean canISteal(){
        return canISteal;
    }
    
    protected boolean canYouGiveMeATreasure(){
        //Revisar cuando implementemos los sectarios
        return !hiddenTreasures.isEmpty();
    }
    
    private void haveStolen(){
        canISteal = false;
    }
    
    public void discardAllTreasures(){
        ArrayList<Treasure> copiaVisible = (ArrayList<Treasure>) visibleTreasures.clone();
        ArrayList<Treasure> copiaHidden = (ArrayList<Treasure>) hiddenTreasures.clone();
        
        for(Treasure t: copiaVisible)
            discardVisibleTreasure(t);
        
        for(Treasure t: copiaHidden)
            discardHiddenTreasure(t);          
    }
    
    @Override
    public String toString(){
        return "\nName: " + name + "\nLevel: " + Integer.toString(level) + "\nDeath: " + (death ? "Si" : "No") + "\nCan I steal?" + (canISteal ? "Yes" : "No") + "\nEnemy: " + ((enemy == null) ? "" : enemy.name) + "\nPending Bad Consequence: " + ((pendingBadConsequence == null) ? "" : pendingBadConsequence.toString()).replaceAll("(?m)^", "\t") + "\nVisible Treasures: " + visibleTreasures.toString().replaceAll("(?m)^", "\t") +"\nHidden Treasures: " + hiddenTreasures.toString().replaceAll("(?m)^", "\t");
    }
    
    public String getEnemyS(){
        return enemy.name;
    }
    
    protected boolean shouldConvert(){
       return Dice.getInstance().nextNumber() == 6;
    }
    
    protected int getOponentLevel(Monster m){
        return m.getCombatLevel();
    }
    
    public int getCombatLevel(){
        int bonus = 0;
        for(Treasure i:visibleTreasures)
            bonus += i.getBonus();
        
        return level + bonus;
    }
    
}
