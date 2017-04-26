/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;

/**
 *
 * @author johanna
 */
public class BadConsequence {
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    public boolean isEmpty(){
        return nVisibleTreasures == 0 && nHiddenTreasures == 0 && specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty();
    }
    
    public int getLevels(){
        return levels;
    }
    
    public int getNVisiblesTreasures(){
        return nVisibleTreasures;
    }
    
    public int getnHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    
    public void substractVisibleTreasure(Treasure t){
        if(!isEmpty()){
            if(!specificVisibleTreasures.isEmpty()){
                if(specificVisibleTreasures.contains(t.getType()))
                    specificVisibleTreasures.remove(t);
            }else if(nVisibleTreasures > 1)
                      nVisibleTreasures -= 1;      
        }
    }
    
    public void substractHiddenTreasure(Treasure t){
        if(!isEmpty()){
            if(!specificHiddenTreasures.isEmpty()){
                if(specificHiddenTreasures.contains(t.getType()))
                    specificHiddenTreasures.remove(t);
            }else if(nHiddenTreasures > 1)
                       nHiddenTreasures -= 1;
        }
    }
    
    public BadConsequence(String t, int l, int nVisible, int nHidden){
        text = t;
        levels = l;
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
        death = false;
    }
    
    public BadConsequence(String t, int l, ArrayList<TreasureKind> v, ArrayList<TreasureKind> h){
        text = t;
        levels = l;
        specificHiddenTreasures = h;
        specificVisibleTreasures = v;
        
    }
    
    public BadConsequence(String t, boolean d){
        text = t;
        death = d;
        levels = 0;
        nVisibleTreasures = 0;
        nHiddenTreasures = 0;
    }
    
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h){
        //TODO
        BadConsequence bc = null;
        return bc;
        
    }
    public String getText(){
        return text;
    }
            
    @Override
    public String toString(){
        if(death){
           return "\n¡Death!\n" + text;
        }else if(levels == 0){
            if((specificHiddenTreasures.isEmpty()) && (specificVisibleTreasures.isEmpty()))
                return "\nLose: Vissible treasures = " + Integer.toString(nVisibleTreasures) + "Hidden treasures = " + Integer.toString(nHiddenTreasures) + "\n" + text;
            else
                return "\nLose: Vissible treasures = " + specificVisibleTreasures.toString() + "Hidden treasures = " + specificHiddenTreasures.toString() + "\n" + text;
        }else if((nVisibleTreasures == 0) && (nHiddenTreasures == 0))
                return "\nLose " + Integer.toString(levels) + "levels\n" + text;
        else{
            if((specificHiddenTreasures.isEmpty()) && (specificVisibleTreasures.isEmpty()))
                return "\nLose: Vissible treasures = " + Integer.toString(nVisibleTreasures) + "Hidden treasures = " + Integer.toString(nHiddenTreasures) +  "levels = " + Integer.toString(levels) + "\n" + text;
            else
                return "\nLose: Vissible treasures = " + specificVisibleTreasures.toString() + "Hidden treasures = " + specificHiddenTreasures.toString() + "levels = " + Integer.toString(levels) + "\n" + text;
        }
    }
}   

