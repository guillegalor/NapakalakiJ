/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import GUI.*;
import java.util.ArrayList;

/**
 *
 * @author guille
 */
public class MainClass {
    public static void main (String[] args){    
        Napakalaki game = Napakalaki.getInstance();
        NapakalakiView napakalakiView = new NapakalakiView();
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
        ArrayList<String> names;
        
        Dice.createInstance (napakalakiView);
        
        namesCapture.setLocationRelativeTo(null);
        names = namesCapture.getNames();
        
        game.initGame(names);
        napakalakiView.setNapakalaki(game);
        napakalakiView.setVisible(true);
    }
}
