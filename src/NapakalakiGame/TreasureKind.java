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
public enum TreasureKind {
    ARMOR, ONEHAND, BOTHHANDS, HELMET, SHOE;
    
    // TODO Comprobar excepciones
    @Override
    public String toString(){
        switch(this){
            case ARMOR: return "armor";
            case ONEHAND: return "one hand";
            case BOTHHANDS: return "both hands";
            case SHOE: return "shoes";
            case HELMET: return "helmet";
            default: return "This is bad";
        }
    }
}
