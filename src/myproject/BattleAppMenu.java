package myproject;

import java.util.Scanner;
import Utilities.Prompt;

/**
 * Menu based application for a games database.
 *
 * @author Edward Ryan
 */
public class BattleAppMenu {

    Scanner sc = new Scanner(System.in);
    DAOBattle data = new DAOBattle();

    public BattleAppMenu() {
        menuLoop();
    }

    private void menuLoop() {
        int choice = 1;
        int id;
        int date;
        String name;
        int losses;
        String participant;
        String victor;

        while (choice != 0) {
            System.out.println("\nBattle App");
            System.out.println("0 = Quit");
            System.out.println("1 = Retrieve All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Single Record");
            System.out.println("4 = Update");
            System.out.println("5 = Delete");
            System.out.println("6 = Retrieval All: Order by ID");
            System.out.println("7 = Retrieval All: Order by the date");
            System.out.println("8 = Retrieval All: Order by the name");
            System.out.println("9 = Retrieval All: Order by participants");
            System.out.println("10 = Retrieval All: Order by losses");
            System.out.println("11 = Retrieval All: Order by victor");
                    

            choice = Prompt.getInt("Number of choice: ", 0, 11);

            if (choice == 1) {
                System.out.println(data.toString());
            } else if (choice == 2) {

                id = Prompt.getInt("Enter Battle id: ");

                date = Prompt.getInt("Enter date: ");

                name = Prompt.getLine("Enter name: ");

                participant = Prompt.getLine("Enter the participants: ");

                losses = Prompt.getInt("Enter casulty losses: ");

                victor = Prompt.getLine("Enter the victor: ");

                 Battle battle = new Battle(id, date, name, losses, participant, victor);
            } else if (choice == 3) {

                id = Prompt.getInt("Enter battle id: ");
                System.out.println(data.retrieve(id));
            } else if (choice == 4) {
                ;
            } else if (choice == 5) {

                id = Prompt.getInt("Enter battle id: ");
                data.delete(id);
            } else if (choice == 6) {
                System.out.println(data.orderById());
            } else if (choice == 7) {
                System.out.println(data.orderByDate());
            } else if (choice == 8) {
                System.out.println(data.orderByName());
            } else if (choice == 9) {
                System.out.println(data.orderByLosses());
            } else if (choice == 10) {
                System.out.println(data.orderByParticipant());
            } else if (choice == 11) {
                System.out.println(data.orderByVictor());
            } else if (choice == 12) {
                data.Statistics();
            } else if (choice == 0){
                ;
            }
        }
    }

    public static void main(String[] args) {
        new BattleAppMenu();
    }
}
