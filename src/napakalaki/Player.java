/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author johanna
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
    private static int MAXLEVEL = 10;
    
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
    
    public String getName(){
        return name;
    }
    
    private void bringToLife(){
        death = false;
    }
    
    private int getCombatLevel(){
        int bonus = 0;
        for(Treasure i:visibleTreasures)
            bonus += i.getBonus();
        
        return level + bonus;
    }
    
    private void incrementLevels(int i){
        if(level + i > 10)
            level = 10;
        else
            level += i;
    }
    
    private void decrementLevels(int i){
        if(level - i < 1)
            level = 1;
        else
            level -= i;
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
        
        for(int i=0; i<nLevels; i++){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }
    
    private void applyBadConsequence(Monster m){
        BadConsequence badConsequence = m.getBadConsequence();
        int nLevels = badConsequence.getLevels();
        
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
        death = true;
    }
    
    public boolean isDeath(){
        return death;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
       return visibleTreasures;
    }
    
    public CombatResult combat(Monster m){
       int myLevel = getCombatLevel();
       int monsterLevel = m.getCombatLevel();
       
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
           combatResult = CombatResult.LOSE;
           applyBadConsequence(m);
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
        return (pendingBadConsequence.isEmpty() || pendingBadConsequence == null) && hiddenTreasures.size() <= 4;
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
    
    private Treasure giveMeATreasure(){
        return hiddenTreasures.remove((int) Math.floor(Math.random()*hiddenTreasures.size()));
    }
    
    public boolean canISteal(){
        return canISteal;
    }
    
    private boolean canYouGiveMeATreasure(){
        //Revisar cuando implementemos los sectarios
        return !hiddenTreasures.isEmpty();
    }
    
    private void haveStolen(){
        canISteal = false;
    }
    
    public void discardAllTreasures(){
        ArrayList<Treasure> copiaVisible = (ArrayList<Treasure>) visibleTreasures.clone();
        ArrayList<Treasure> copiaHidden = (ArrayList<Treasure>) hiddenTreasures.clone();
        
        Iterator<Treasure> itr = copiaVisible.iterator();
        
        while(itr.hasNext())
            discardVisibleTreasure(itr.next());
        
        itr = copiaHidden.iterator();
        
        while(itr.hasNext())
            discardHiddenTreasure(itr.next());       
        
    }
    
}
