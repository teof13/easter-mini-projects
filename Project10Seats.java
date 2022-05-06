package gr.aueb.cf.testbed.easterMiniProjects;

import java.util.Scanner;

public class Project10Seats {
    static int rows = 30;
    static int columns = 12;
    static boolean[][] seats = new boolean[rows][columns];

    public static void main(String[] args) {

    }

    public static void book(char column, int row) {
        row--;
        int col = column -'A';
        if (row > -1 && row < rows && col > -1 && col < columns) {
            if (!seats[row][col]) {
                seats[row][col] = true;
            } else {
                System.out.println("Η θέση είναι ήδη κατειλημμένη");
            }
        } else {
            System.out.println("Εισάγετε ένα γράμμα από το A εως το L και έναν ακέραιο απο΄το 1 εως το 30");
        }
    }

    public static void cancel(char column, int row) {
        row--;
        int col = column -'A';
        if (row > -1 && row < rows && col > -1 && col < columns) {
            if (seats[row][col]) {
                seats[row][col] = false;
            } else {
                System.out.println("Η θέση είναι ήδη κενή");
            }
        } else {
            System.out.println("Εισάγετε ένα γράμμα από το A εως το L και έναν ακέραιο απο΄το 1 εως το 30");
        }
    }
}
