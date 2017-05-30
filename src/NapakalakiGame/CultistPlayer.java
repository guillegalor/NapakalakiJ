/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.Random;

/**
 *
 * @author guille
 */

public class CultistPlayer extends Player  {
    
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c){
        super(p);
        myCultistCard = c;
    }
    
    static public int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
    
    @Override
    public int getCombatLevel(){
        return (int) (super.getCombatLevel()*1.7 + myCultistCard.getGainedLevels()); 
    }
    
    @Override
    protected int getOponentLevel(Monster m){
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    
    @Override
    protected Treasure giveMeATreasure(){
        Random rand = new Random();
        return getVisibleTreasures().remove(rand.nextInt(getVisibleTreasures().size()));
    }
    
    @Override
    protected boolean canYouGiveMeATreasure(){
        return !getVisibleTreasures().isEmpty();
    }
    
    
}
