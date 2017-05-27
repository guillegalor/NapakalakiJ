/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author guille
 */
public class NumericBadConsequence extends BadConsequence{
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    
    public NumericBadConsequence(String t, int l, int nVisibleTreasures, int nHiddenTreasures){
        super(t,l);
        this.nVisibleTreasures = nVisibleTreasures;
        this.nHiddenTreasures = nHiddenTreasures;
    }
   
    @Override
    public boolean isEmpty(){
       return nVisibleTreasures == 0 && nHiddenTreasures == 0; 
    }
    
    public int getNVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    public int getNHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        if (nVisibleTreasures >= 1) {
            nVisibleTreasures -= 1;
        }
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
        if (nHiddenTreasures >= 1) {
            nHiddenTreasures -= 1;
        }
    }
    
    @Override
    public NumericBadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h){
        int nVisible = nVisibleTreasures;
        int nHidden = nHiddenTreasures;
        if(nVisible > v.size())
            nVisible = v.size();
            
        if(nHidden > h.size())
            nHidden = h.size();
        
        return new NumericBadConsequence(getText(), getLevels(), nVisible, nHidden);
    }
    
    @Override
    public String toString(){
        return "\nLose:" + "\nLevels = " + Integer.toString(getLevels()) + "\nVisible treasures = " + Integer.toString(nVisibleTreasures) + "\nHidden treasures = " + Integer.toString(nHiddenTreasures) + "\n" + getText();
    }
}
