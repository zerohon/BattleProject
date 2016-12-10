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
public class BattleApp3 {
    public static void main(String[] args) {
        DAOBattle data = new DAOBattle();
        System.out.println(data);
        // Do these commands once. Then exit. Then comment out and run again to see if data was saved
        data.create(new Battle(3,1415,"Agincourt",9000,"English and French","French"));
        System.out.println(data);
    }
}
