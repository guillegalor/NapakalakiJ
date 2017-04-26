/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import static java.sql.JDBCType.NULL;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author johanna
 */
public class PruebaNapakalaki {
    
    static ArrayList<Monster> monstruos = new ArrayList();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BadConsequence bc; 
        Prize prize; 
        
        //mounstruos[0]
        bc = new BadConsequence("Pierdes tu armadura visible y otra oculta",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(2,1);
        monstruos.add(new Monster("3 Byakhees de bonanza",8,bc,prize));
        
        //monstruos[1]
        bc = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Tenochtitlan" , 2, bc, prize));
         
        //monstruos[2]
        bc = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0, new ArrayList(Arrays.asList(TreasureKind.SHOE)), new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("El sopor de Dunwich", 2, bc, prize));
        
        //monstruos[3]
        bc = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Decarta 1 mano visible y 1 mano oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4, 1);
        monstruos.add(new Monster("Demonios de Magaluf", 2, bc, prize));
        
        //monstruos[4]
        bc = new BadConsequence("Pierdes todos tus tesoros visibles", 0,Integer.MAX_VALUE,0);
        prize = new Prize(3, 1);
        monstruos.add(new Monster("El gorron en el umbral", 13, bc, prize));
        
        //monstruos[5]
        bc = new BadConsequence("Pierdes la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(2, 1);
        monstruos.add(new Monster("H.P Munchcraft", 6, bc, prize));
        
        
        //monstruos[6]
        bc = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Necrofago", 13, bc, prize));
        
        
        //monstruos[7] 
        bc = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(3, 2);
        monstruos.add(new Monster("El rey de rosado", 11, bc, prize));
        
        
        //monstruos[8] 
        bc = new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Flecher", 2, bc, prize));
        
        
        //monstruos[9] 
        bc = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto", true);
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Los hondos", 8, bc, prize));
        
        
        //monstruos[10] 
        bc = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Semillas Cthulhu", 4, bc, prize));
        
        
        //monstruos[11]
        bc = new BadConsequence("Te intentas escaquear. Pierdes una mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Dameargo", 1, bc, prize));
        
        
        //monstruos[12]
        bc = new BadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Pollipolipo volante", 3, bc, prize));
        
        
        //monstruos[13]
        bc = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto", true);
        prize = new Prize(3, 1);
        monstruos.add(new Monster("Yskhtihyssg-Goth", 14, bc, prize));
        
        
        //monstruos[14]
        bc = new BadConsequence("La familia te atrapa. Estas muerto", true);
        prize = new Prize(3, 1);
        monstruos.add(new Monster("Familia feliz", 1, bc, prize));
        
        
        //monstruos[15]
        bc = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Roboggoth", 8, bc, prize));
        
        
        //monstruos[16]
        bc = new BadConsequence("Te asusta en la noche. Pierdes un casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("El espia sordo", 5, bc, prize));
        
        
        //monstruos[17]
        bc = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Tongue", 19, bc, prize));
        
        
        //monstruos[18]
        bc = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Bicefalo", 21, bc, prize));
        
        //monstruos[19] -2 contra sectarios
        bc = new BadConsequence("Pierdes una mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(3, 1);
        monstruos.add(new Monster("El mal indecible impronunciable", 10, bc, prize));
        
        //monstruos[20] +2 contra sectarios
        bc = new BadConsequence("Pierdes tus tesoros visibles. Jajaja.", 0, Integer.MAX_VALUE, 0);
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Testigos oculares", 6, bc, prize));
        
        //monstruos[21] +4 contra sectarios
        bc = new BadConsequence("Hoy no es tu dia de suerte. Mueres", true);
        prize = new Prize(5, 2);
        monstruos.add(new Monster("El gran cthulhu", 20, bc, prize));
        
        //monstruos[22] -2 contra sectarios
        bc = new BadConsequence("Tu gobierno te recorta 2 niveles", 2, 0, 0);
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Serpiente Politico", 8, bc, prize));
        
        //monstruos[23] +5 contra sectarios
        bc = new BadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.ONEHAND,TreasureKind.BOTHHANDS, TreasureKind.BOTHHANDS, TreasureKind.BOTHHANDS, TreasureKind.BOTHHANDS)));
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Felpuggoth", 2, bc, prize));
        
        //monstruos[24] -4 contra sectarios
        bc = new BadConsequence("Pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(4, 2);
        monstruos.add(new Monster("Shoggoth", 16, bc, prize));
        
        //monstruos[25] +3 contra sectarios
        bc = new BadConsequence("Pintalabios negro. Pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Lolitagooth", 2, bc, prize));
        
        System.out.print(monstruos.toString());
        
    }
    
}
