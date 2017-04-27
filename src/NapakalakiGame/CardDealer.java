/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;


/**
 *
 * @author johanna
 */
public class CardDealer {
    
    private static CardDealer instance = null;
    
    private CardDealer() {
        usedTreasures = new ArrayList();
        unusedTreasures = new ArrayList();
        usedMonsters = new ArrayList();
        unusedMonsters = new ArrayList();
    }
    
    public static CardDealer getInstance() {
        if(instance == null)
            instance = new CardDealer();
        
        return instance;
    }
    
    private ArrayList<Treasure> usedTreasures;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Monster> unusedMonsters;
    
    private void initTreasureCardDeck(){
        //Treasure[0]
        unusedTreasures.add(new Treasure("¡Si mi amo!",4,TreasureKind.HELMET));
        
        //Treasure[1]
        unusedTreasures.add(new Treasure("Botas de investigacion",3,TreasureKind.SHOE));
        
        //Treasure[2]
        unusedTreasures.add(new Treasure("Capucha de Cthulhu",3,TreasureKind.HELMET));
        
        //Treasure[3]
        unusedTreasures.add(new Treasure("A prueba de babas",2,TreasureKind.ARMOR));
        
        //Treasure[4]
        unusedTreasures.add(new Treasure("Botas de lluvia ácida",1,TreasureKind.BOTHHANDS));
        
        //Treasure[5]
        unusedTreasures.add(new Treasure("Casco minero",2,TreasureKind.HELMET));
        
        //Treasure[6]
        unusedTreasures.add(new Treasure("Ametralladora ACME",4,TreasureKind.BOTHHANDS));
        
        //Treasure[7]
        unusedTreasures.add(new Treasure("Camiseta de la ETSIIT",1,TreasureKind.ARMOR));
        
        //Treasure[8]
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario",3,TreasureKind.ONEHAND));
        
        //Treasure[9]
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano",2,TreasureKind.ONEHAND));
        
        //Treasure[10]
        unusedTreasures.add(new Treasure("Fez alópodo",3,TreasureKind.HELMET));
        
        //Treasure[11]
        unusedTreasures.add(new Treasure("Hacha prehistórica",2,TreasureKind.ONEHAND));
        
        //Treasure[12]
        unusedTreasures.add(new Treasure("El apartado del Pr. Tesla",4,TreasureKind.ARMOR));
        
        //Treasure[13]
        unusedTreasures.add(new Treasure("Gaita",4,TreasureKind.BOTHHANDS));
        
        //Treasure[14]
        unusedTreasures.add(new Treasure("Insecticida",2,TreasureKind.ONEHAND));
        
        //Treasure[15]
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones",4,TreasureKind.BOTHHANDS));
        
        //Treasure[16]
        unusedTreasures.add(new Treasure("Garabato mistico",2,TreasureKind.ONEHAND));
        
        //Treasure[17]
        unusedTreasures.add(new Treasure("La rebeca metalica", 2,TreasureKind.ARMOR));
        
        //Treasure[18]
        unusedTreasures.add(new Treasure("Lanzallamas",4,TreasureKind.BOTHHANDS));
        
        //Treasure[19]
        unusedTreasures.add(new Treasure("Necro-comicon",1,TreasureKind.ONEHAND));
        
        //Treasure[20]
        unusedTreasures.add(new Treasure("Necronomicon",5,TreasureKind.BOTHHANDS));
        
        //Treasure[21]
        unusedTreasures.add(new Treasure("Linterna a 2 manos",3,TreasureKind.BOTHHANDS));
        
        //Treasure[22]
        unusedTreasures.add(new Treasure("Necro-gnomicon",2,TreasureKind.ONEHAND));
        
        //Treasure[23]
        unusedTreasures.add(new Treasure("Necrotelecom",2,TreasureKind.HELMET));
        
        //Treasure[24]
        unusedTreasures.add(new Treasure("Mazo de los antiguos",3,TreasureKind.ONEHAND));
        
        //Treasure[25]
        unusedTreasures.add(new Treasure("Necro-playboycon",3,TreasureKind.ONEHAND));
        
        //Treasure[26]
        unusedTreasures.add(new Treasure("Porra preternatural",2,TreasureKind.ONEHAND));
        
        //Treasure[27]
        unusedTreasures.add(new Treasure("Shogulador",1,TreasureKind.BOTHHANDS));
        
        //Treasure[28]
        unusedTreasures.add(new Treasure("Varita de atizamiento",3,TreasureKind.ONEHAND));
        
        //Treasure[29]
        unusedTreasures.add(new Treasure("Tentaculo de pega",2,TreasureKind.HELMET));
        
        //Treasures[30]
        unusedTreasures.add(new Treasure("Zapato deja-amigos",1,TreasureKind.SHOE));
        
    }
    
    private void initMonsterCardDeck(){
        BadConsequence bc; 
        Prize prize; 
        
        //unusedMonsrters[0]
        bc = new BadConsequence("Pierdes tu armadura visible y otra oculta",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza",8,bc,prize));
        
        //unusedMonsters[1]
        bc = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Tenochtitlan" , 2, bc, prize));
         
        //unusedMonsters[2]
        bc = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0, new ArrayList(Arrays.asList(TreasureKind.SHOE)), new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, bc, prize));
        
        //unusedMonsters[3]
        bc = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Decarta 1 mano visible y 1 mano oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4, 1);
        unusedMonsters.add(new Monster("Demonios de Magaluf", 2, bc, prize));
        
        //unusedMonsters[4]
        bc = new BadConsequence("Pierdes todos tus tesoros visibles", 0,Integer.MAX_VALUE,0);
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("El gorron en el umbral", 13, bc, prize));
        
        //unusedMonsters[5]
        bc = new BadConsequence("Pierdes la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("H.P Munchcraft", 6, bc, prize));
        
        
        //unusedMonsters[6]
        bc = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Necrofago", 13, bc, prize));
        
        
        //unusedMonsters[7] 
        bc = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(3, 2);
        unusedMonsters.add(new Monster("El rey de rosado", 11, bc, prize));
        
        
        //unusedMonsters[8] 
        bc = new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Flecher", 2, bc, prize));
        
        
        //unusedMonsters[9] 
        bc = new BadConsequence("Estos unusedMonsters resultan bastante superficiales y te aburren mortalmente. Estas muerto", true);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Los hondos", 8, bc, prize));
        
        
        //unusedMonsters[10] 
        bc = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, bc, prize));
        
        
        //unusedMonsters[11]
        bc = new BadConsequence("Te intentas escaquear. Pierdes una mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Dameargo", 1, bc, prize));
        
        
        //unusedMonsters[12]
        bc = new BadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Pollipolipo volante", 3, bc, prize));
        
        
        //unusedMonsters[13]
        bc = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto", true);
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 14, bc, prize));
        
        
        //unusedMonsters[14]
        bc = new BadConsequence("La familia te atrapa. Estas muerto", true);
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("Familia feliz", 1, bc, prize));
        
        
        //unusedMonsters[15]
        bc = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Roboggoth", 8, bc, prize));
        
        //unusedMonsters[16]
        bc = new BadConsequence("Te asusta en la noche. Pierdes un casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El espia sordo", 5, bc, prize));
        
        //unusedMonsters[17]
        bc = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Tongue", 19, bc, prize));
        
        //unusedMonsters[18]
        bc = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Bicefalo", 21, bc, prize));
        
        //unusedMonsters[19] -2 contra sectarios
        bc = new BadConsequence("Pierdes una mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, bc, prize));
        
        //unusedMonsters[20] +2 contra sectarios
        bc = new BadConsequence("Pierdes tus tesoros visibles. Jajaja.", 0, Integer.MAX_VALUE, 0);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Testigos oculares", 6, bc, prize));
        
        //unusedMonsters[21] +4 contra sectarios
        bc = new BadConsequence("Hoy no es tu dia de suerte. Mueres", true);
        prize = new Prize(5, 2);
        unusedMonsters.add(new Monster("El gran cthulhu", 20, bc, prize));
        
        //unusedMonsters[22] -2 contra sectarios
        bc = new BadConsequence("Tu gobierno te recorta 2 niveles", 2, 0, 0);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Serpiente Politico", 8, bc, prize));
        
        //unusedMonsters[23] +5 contra sectarios
        bc = new BadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.ONEHAND,TreasureKind.BOTHHANDS, TreasureKind.BOTHHANDS, TreasureKind.BOTHHANDS, TreasureKind.BOTHHANDS)));
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, bc, prize));
        
        //unusedMonsters[24] -4 contra sectarios
        bc = new BadConsequence("Pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(4, 2);
        unusedMonsters.add(new Monster("Shoggoth", 16, bc, prize));
        
        //unusedMonsters[25] +3 contra sectarios
        bc = new BadConsequence("Pintalabios negro. Pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Lolitagooth", 2, bc, prize));
    }
    
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }
    
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonsters);
    }
    
    public Treasure nextTreasure(){
        
        if(unusedTreasures.isEmpty()){
           Iterator<Treasure> itr = usedTreasures.iterator();
           while(itr.hasNext()){
               unusedTreasures.add(itr.next());
               usedTreasures.remove(itr.next());
           }
           
           shuffleTreasures();
        }
        
        return unusedTreasures.remove(unusedTreasures.size()-1);
    }
    
    public Monster nextMonster(){
        
        if(unusedMonsters.isEmpty()){
            Iterator<Monster> itr = usedMonsters.iterator();
            while(itr.hasNext()){
                unusedMonsters.add(itr.next());
                usedMonsters.remove(itr.next());
            }
            
            shuffleMonsters();
        }
        return unusedMonsters.remove(unusedMonsters.size()-1);
    }
    
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
    }
    
    public void initCards(){
        initTreasureCardDeck();
        initMonsterCardDeck();
        shuffleTreasures();
        shuffleMonsters();
    }
}
