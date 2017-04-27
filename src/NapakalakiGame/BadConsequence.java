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
    
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h) throws CloneNotSupportedException{
        if(!isEmpty()){
            int nVisible = nVisibleTreasures;
            int nHidden = nHiddenTreasures;
            if(nVisible > v.size())
                nVisible = v.size();
            
            if(nHidden > h.size())
                nHidden = h.size();
            
            ArrayList<TreasureKind> visibleTypes = new ArrayList();
            ArrayList<TreasureKind> hiddenTypes = new ArrayList();
            
            Iterator<Treasure> itr = v.iterator();
            while(itr.hasNext())
               visibleTypes.add(itr.next().getType());
            
            itr = h.iterator();
            
            while(itr.hasNext())
                hiddenTypes.add(itr.next().getType());
            
            ArrayList<TreasureKind> sVisibleTreasures = new ArrayList();
            ArrayList<TreasureKind> sHiddenTreasures = new ArrayList();
            ArrayList<TreasureKind> cpySpecificVisibleTreasures = (ArrayList<TreasureKind>) specificVisibleTreasures.clone();
            ArrayList<TreasureKind> cpySpecificHiddenTreasures = (ArrayList<TreasureKind>) specificHiddenTreasures.clone();
            
            Iterator<TreasureKind> it = visibleTypes.iterator();
            
            while(it.hasNext()){
                if(cpySpecificVisibleTreasures.contains(it.next())){
                    sVisibleTreasures.add(it.next());
                    cpySpecificVisibleTreasures.remove(it.next());
                }
            }
            
            it = hiddenTypes.iterator();
            
            while(it.hasNext()){
                if(cpySpecificHiddenTreasures.contains(it.next())){
                    sHiddenTreasures.add(it.next());
                    cpySpecificHiddenTreasures.remove(it.next());
                }
            }
            
            if(specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty())
                return new BadConsequence(text,levels,nVisible,nHidden);
            else
                return new BadConsequence(text,levels,sVisibleTreasures,sHiddenTreasures);
            
            
        }else
            return (BadConsequence) this.clone();
        
        
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

