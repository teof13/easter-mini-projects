package gr.aueb.cf.testbed.easterMiniProjects;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Project08TicTacToe {

    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        int row = -1;
        int column = -1;
        int player = 0;

        for (int i = 0; i < 9; i++) {
            player = (i % 2 == 0) ? 1 : 2;

            showGrid(arr);

            System.out.printf("Επιλέγει ο %dος παίκτης:%n", player);
            while (true) {
                while (true) {
                    try {
                        System.out.println("Επιλογή σειράς (από 1 εως 3):");
                        row = getChoice();
                        if (row > -1 && row < 3) break;
                        System.out.println("Τιμή εκτός ορίων, εισάγετε ακέραιο αριθμό από το 1 έως 3");
                    } catch (InputMismatchException e) {
                        System.out.println("Λάθος τιμή, εισάγετε ακέραιο αριθμό από το 1 έως 3");
                    }
                }

                while (true) {
                    try {
                        System.out.println("Επιλογη στήλης (από 1 εως 3):");
                        column = getChoice();
                        if (column > -1 && column < 3) break;
                        System.out.println("Τιμή εκτός ορίων, εισάγετε ακέραιο αριθμό από το 1 έως 3");
                    } catch (InputMismatchException e) {
                        System.out.println("Λάθος τιμή, εισάγετε ακέραιο αριθμό από το 1 έως 3");
                    }
                }


                if (!positionIsOccupied(arr, row, column)) break;

                System.out.println("Η συγκεκριμένη θέση είναι ήδη κατειλημμένη, επιλέξτε άλλη");
            }

            arr[row][column] = player;

            if (i > 3 && isWinner(arr, player)) {
                System.out.printf("Νικητής ο %dος παίκτης%n", player);
                showGrid(arr);
                in.close();
                System.exit(0);
            }
        }
        System.out.println("Ισοπαλία");
        showGrid(arr);
        in.close();
    }

    public static int getChoice() {
        int choice;

        while (true) {
            try {
                choice = in.nextInt() - 1;
                in.nextLine();
                return choice;
            } catch (InputMismatchException e) {
                in.nextLine();
                e.printStackTrace();
                throw e;
            }
        }

    }

    public static boolean positionIsOccupied (int[][] arr, int row, int column) {
        return (arr[row][column] != 0);
    }

    public static boolean isWinner(int[][] arr, int player) {
        int counterV = 0;
        int counterH = 0;

        if ((arr[0][0] == player && arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2])) return true;
        if ((arr[0][2] == player && arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0])) return true;

        for (int i = 0; i < arr.length; i++) {
            counterH = 0;
            counterV = 0;
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == player) counterH++;
                if (arr[j][i] == player) counterV++;
            }
            if (counterH == 3) return true;
            if (counterV == 3) return true;
        }
        return false;
    }

    public static void showGrid(int[][] arr) {
        System.out.println("    1   2   3  ");
        System.out.println("  |---|---|---|");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", i+1);
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("| %s ", (arr[i][j] == 0) ? ' ' : (arr[i][j] == 1) ? 'X' : 'O');
            }
            System.out.println("|");
            System.out.println("  |---|---|---|");
        }
    }
}
