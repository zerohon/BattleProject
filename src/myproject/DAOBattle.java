/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import static java.lang.Double.MAX_VALUE;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Data Access Object to a collection of battle data.
 *
 * @author 55ryanea05
 */
public class DAOBattle {

    private final String fileName = "DAOBattle.txt";
    private List<Battle> myList;

    public DAOBattle() {
        myList = new ArrayList<>();
        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
            ;
        } catch (IOException ex) {
            Logger.getLogger(DAOBattle.class.getName()).log(Level.SEVERE, null, ex);
        }
        readList();
    }

    public void create(Battle battle) {
        myList.add(battle);
        writeList();
    }

    public Battle retrieve(int id) {
        for (Battle b : myList) {
            if (b.getId() == id) {
                return b;
            }

        }
        return null;
    }

    public void update(Battle battle) {
        for (Battle b : myList) {
            if (b.getId() == battle.getId()) {
                b.setName(battle.getName());
                // do this for all fields
                break;
            }
        }
    }

    public void delete(int id) {
        for (Battle b : myList) {
            if (b.getId() == id) {
                myList.remove(b);
            }
        }
        writeList();
    }
// Battle mybattle = null;
    //for(Battle b : myList) {
    //    if(b.getId() == id) {
    //        mybattle =b;
    // do this for all fields
    //    writeList();
    //    break;

    private void readList() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int date = Integer.parseInt(data[2]);
                int losses = Integer.parseInt(data[3]);
                String participant = data[4];
                String victor = data[5];
                Battle mybattle = new Battle(id, date, name, losses, participant, victor);
                myList.add(mybattle);
            }
        } catch (IOException ex) {
            Logger.getLogger(DAOBattle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Battle battle : myList) {
                writer.write(String.format("%d,%s,%d,%d,%s,%s",
                        battle.getId(),
                        battle.getName(),
                        battle.getDate(),
                        battle.getLosses(),
                        battle.getParticipant(),
                        battle.getVictor()));

            }
        } catch (IOException ex) {
            Logger.getLogger(DAOBattle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String orderById() {
        myList.sort(Comparator.comparing(Battle::getId));
        return this.toString();
    }

    public String orderByDate() {
        myList.sort(Comparator.comparing(Battle::getDate));
        return this.toString();
    }

    public String orderByName() {
        myList.sort(Comparator.comparing(Battle::getName));
        return this.toString();
    }

    public String orderByLosses() {
        myList.sort(Comparator.comparing(Battle::getLosses));
        return this.toString();
    }

    public String orderByParticipant() {
        myList.sort(Comparator.comparing(Battle::getParticipant));
        return this.toString();
    }

    public String orderByVictor() {
        myList.sort(Comparator.comparing(Battle::getVictor).reversed());
        return this.toString();
    }

public void Statistics() {
        double[] stats = new double[15];
        int counter = 0;
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                double price = Double.parseDouble(data[5]);
                stats[counter] = price;
                counter++;
            }
        } catch (IOException ex) {
            Logger.getLogger(DAOBattle.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(counter);
        double sum = 0;
        double maximum = 0;
        double minimum = MAX_VALUE;
        for (int i = 0; i < counter; i++) {
            if (stats[i] >= maximum) {
                maximum = stats[i];
            }
            if (stats[i] <= minimum) {
                minimum = stats[i];
            }
            sum = stats[i] + sum;
        }
        double average = sum/(counter);
        System.out.println("The maximum value is: " + maximum);
        System.out.println("The minimum value is " + minimum);
        System.out.println("The sum of the values is " + sum);
        System.out.println("The average of the values is " + average);
        
        double total=0;
        double SD;
        for (int i=0; i<counter; i++){
            total=total+Math.pow((stats[i]-average),2);
        }
        SD = Math.sqrt(total/counter);
        System.out.println("The standard deviation is: "  + SD);
    }

    @Override
    public String toString() {
        //return "DAOBattle{" + "myList=" + myList + '}';
        StringBuilder sb = new StringBuilder();
        for (Battle battle : myList) {              //for each loop
            sb.append(battle).append("\n");
        }
        return sb.toString();
    }


}
