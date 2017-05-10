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
public class SpecificBadConsequence extends BadConsequence {
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    public SpecificBadConsequence(String t, int l, ArrayList<TreasureKind> v, ArrayList<TreasureKind> h){
        super(t,l);
        specificHiddenTreasures = h;
        specificVisibleTreasures = v;
    }
    
    @Override
    public boolean isEmpty(){
        return specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty();
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    
    public void substractVisibleTreasure(Treasure t){
        if(!specificVisibleTreasures.isEmpty()){
                if(specificVisibleTreasures.contains(t.getType()))
                    specificVisibleTreasures.remove(t.getType());
        }
    }
    
    public void substractHiddenTreasure(Treasure t){
        if(!specificHiddenTreasures.isEmpty()){
                if(specificHiddenTreasures.contains(t.getType()))
                    specificHiddenTreasures.remove(t.getType());
        }
    }
    
    public  SpecificBadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h){
        ArrayList<TreasureKind> visibleTypes = new ArrayList();
        ArrayList<TreasureKind> hiddenTypes = new ArrayList();
            
        for (Treasure t: v){
            visibleTypes.add(t.getType());
        }
            
        for (Treasure t: h){
            hiddenTypes.add(t.getType());
        }
            
        ArrayList<TreasureKind> sVisibleTreasures = new ArrayList();
        ArrayList<TreasureKind> sHiddenTreasures = new ArrayList();
        ArrayList<TreasureKind> cpySpecificVisibleTreasures = (ArrayList<TreasureKind>) specificVisibleTreasures.clone();
        ArrayList<TreasureKind> cpySpecificHiddenTreasures = (ArrayList<TreasureKind>) specificHiddenTreasures.clone();
        
        for (TreasureKind tk: visibleTypes){
            if(cpySpecificVisibleTreasures.contains(tk)){
                sVisibleTreasures.add(tk);
                cpySpecificVisibleTreasures.remove(tk);
            }
        }
            
        for (TreasureKind tk: hiddenTypes){
            if(cpySpecificHiddenTreasures.contains(tk)){
                sHiddenTreasures.add(tk);
                cpySpecificHiddenTreasures.remove(tk);
            }
        }
        
        return new SpecificBadConsequence(getText(), getLevels(), sVisibleTreasures, sHiddenTreasures);
    }
    
    @Override
    public String toString(){
        return "\nLose:" + "\nLevels = " + Integer.toString(getLevels()) + "\nVisible treasures = " + specificVisibleTreasures.toString() + "\nHidden treasures = " + specificHiddenTreasures.toString() + "\n" + getText();        
    }
    
}
