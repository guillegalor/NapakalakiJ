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
public class Napakalaki {
    
    private static Napakalaki instance = null;
    private Player currentPlayer;
    private ArrayList<Player> players;
    private CardDealer dealer;
    private Monster currentMonster;
    
    Napakalaki(){
        currentPlayer = null;
        players = new ArrayList();
        dealer = CardDealer.getInstance();
        currentMonster = null;
        
    }
    
    private void initPlayers(ArrayList<String> names){
        Iterator<String> itr = names.iterator();
        while(itr.hasNext()){
            Player player = new Player(itr.next());
            players.add(player);
        }
    }
    
    private Player nextPlayer(){
        int indice;
        if(currentPlayer == null)
            indice = (int) Math.floor(Math.random()*players.size());
        else{
            if(currentPlayer == players.get(players.size()))
                indice = 0;
            else{
                indice = players.indexOf(currentPlayer);
                indice += 1;
            }     
        }
    
       return players.get(indice);
    }
    
    private boolean nextTurnAllowed(){
        return (currentPlayer == null) || currentPlayer.validState();
    }
    
    private void setEnemies(){
        //TODO
    }
    
    public static Napakalaki getInstance(){
        if(instance == null)
            instance = new Napakalaki();
        
        return instance;
    }
    
    public CombatResult developCombat(){
        CombatResult combatResult = currentPlayer.combat(currentMonster);
        dealer.giveMonsterBack(currentMonster);
        return combatResult;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        Iterator<Treasure> itr = treasures.iterator();
        Treasure treasure;
        while(itr.hasNext()){
            treasure = itr.next();
            currentPlayer.discardVisibleTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        Iterator<Treasure> itr = treasures.iterator();
        Treasure treasure;
        while(itr.hasNext()){
            treasure = itr.next();
            currentPlayer.discardHiddenTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        Iterator<Treasure> itr = treasures.iterator();
        while(itr.hasNext())
            currentPlayer.makeTreasureVisible(itr.next());
    }
    
    public void initGame(ArrayList<String> players){
        initPlayers(players);
        setEnemies();
        dealer.initCards();
        nextTurn();
    }
    
    public Player getCurrentPLayer(){
        return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    public boolean nextTurn(){
        boolean stateOK = nextTurnAllowed();
        
        if(stateOK){
            currentMonster = dealer.nextMonster();
            currentPlayer = nextPlayer();
            boolean dead = currentPlayer.isDeath();
            
            if(dead)
                currentPlayer.initTreasures();
        }
        
        return stateOK;
    }
    
    public boolean endOfGame(CombatResult result){
        return result == CombatResult.WINGAME;
    }
    
}
