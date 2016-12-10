/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

/**
 *
 * @author Edward Ryan
 */
public class BattleApp {

    public static void main(String[] args) {

        Battle b1 = new Battle(1, 1066, "Standford Bridge", 11000, "Norweigans and Saxons", "Saxons");
        Battle b2 = new Battle(3, 1415, "Agincourt", 9000, "English and French", "English");
        
        System.out.println(b1);

    }

}
