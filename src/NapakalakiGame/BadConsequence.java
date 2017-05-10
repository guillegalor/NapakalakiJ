/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author johanna y guille
 */
public abstract class BadConsequence {
    static int MAXTREASURES = 10;
    
    private String text;
    private int levels;
    /*
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    */
    
    public BadConsequence(String t, int l){
        text = t;
        levels = l;
    }
    
    public abstract boolean isEmpty();
        //return nVisibleTreasures == 0 && nHiddenTreasures == 0 && specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty();
    
    public int getLevels(){
        return levels;
    }
    
    public String getText(){
        return text;
    }
    
    /*
    public int getNVisiblesTreasures(){
        return nVisibleTreasures;
    }
    
    public int getNHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    */
    
    public abstract void substractVisibleTreasure(Treasure t);
        /*
        if(!isEmpty()){
            if(!specificVisibleTreasures.isEmpty()){
                if(specificVisibleTreasures.contains(t.getType()))
                    specificVisibleTreasures.remove(t.getType());
            }else if(nVisibleTreasures >= 1)
                      nVisibleTreasures -= 1;      
        }
        */
  
    
    public abstract void substractHiddenTreasure(Treasure t);
        /*
        if(!isEmpty()){
            if(!specificHiddenTreasures.isEmpty()){
                if(specificHiddenTreasures.contains(t.getType()))
                    specificHiddenTreasures.remove(t.getType());
            }else if(nHiddenTreasures >= 1)
                       nHiddenTreasures -= 1;
        }
        */    
    
    public abstract BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h);
        /*
        if(!isEmpty()){
            int nVisible = nVisibleTreasures;
            int nHidden = nHiddenTreasures;
            if(nVisible > v.size())
                nVisible = v.size();
            
            if(nHidden > h.size())
                nHidden = h.size();
            
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
            
            if(specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty())
                return new BadConsequence(text,levels,nVisible,nHidden);
            else
                return new BadConsequence(text,levels,sVisibleTreasures,sHiddenTreasures);
            
            
        }else
            return new BadConsequence(text,levels, 0, 0);
        
        
        */
            
        /*
        TO STRING
    
        if(death){
           return "\n¡Death!\n" + text;
        }else if(levels == 0){
            if((specificHiddenTreasures.isEmpty()) && (specificVisibleTreasures.isEmpty()))
                return "\nLose: \nVisible treasures = " + Integer.toString(nVisibleTreasures) + "\nHidden treasures = " + Integer.toString(nHiddenTreasures) + "\n" + text;
            else
                return "\nLose: \nVisible treasures = " + specificVisibleTreasures.toString() + "\nHidden treasures = " + specificHiddenTreasures.toString() + "\n" + text;
        }else if((nVisibleTreasures == 0) && (nHiddenTreasures == 0))
                return "\nLose " + Integer.toString(levels) + " levels\n" + text;
        else{
            if((specificHiddenTreasures.isEmpty()) && (specificVisibleTreasures.isEmpty()))
                return "\nLose: \nVisible treasures = " + Integer.toString(nVisibleTreasures) + "\nHidden treasures = " + Integer.toString(nHiddenTreasures) +  "\nLevels = " + Integer.toString(levels) + "\n" + text;
            else
                return "\nLose: \nVisible treasures = " + specificVisibleTreasures.toString() + "\nHidden treasures = " + specificHiddenTreasures.toString() + "\nLevels = " + Integer.toString(levels) + "\n" + text;
        }
        */
}