/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

/**
 *
 * @author 55ryanea05
 */
public class BattleApp2 {
    public static void main(String[] args) {
        DAOBattle data = new DAOBattle();
        
        data.create(new Battle(2, 1066, "Hastings", 15000, "Normans and Saxons", "Normans"));
        System.out.println(data);
        
        System.out.println(data.retrieve(2));
        System.out.println(data.retrieve(-1));
        data.delete(1);
        System.out.println(data);
    }
}
