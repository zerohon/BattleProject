/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

/**
 * project to display battle
 *
 * @author Edward Ryan
 */
public class Battle {

    int id;
    private int date;
    private String name;
    private int losses;
    private String participant;
    private String victor;

    public Battle(int id, int date, String name, int losses, String participant, String victor) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.losses = losses;
        this.participant = participant;
        this.victor = victor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public String getVictor() {
        return victor;
    }

    public void setVictor(String victor) {
        this.victor = victor;
    }

    @Override
    public String toString() {
        return "Battle{" + "id=" + id + ", date=" + date + ", name=" + name + ", losses=" + losses + ", participant=" + participant + ", victor=" + victor + '}';
      //  return String.format("%-10d %-10s %-10s %-10d %-20s %.2f", id, date, name, losses, participant, victor);
    }

    
    
    


}



