package gr.aueb.cf.testbed.easterMiniProjects;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Project05LowHigh {
    public static void main(String[] args) {
        int key;
        int[] arr = {0, 1, 4, 4, 4, 6, 7, 8, 8, 8, 8, 9};
        int[] result = new int[2];

        System.out.println("Παρακαλώ δώστε αριθμό για αναζήτηση");
        try (Scanner in = new Scanner(System.in);) {
            key = in.nextInt();
            in.nextLine();
            result = getLowAndHighIndexOf(arr, key);
            if (result[0] == -1) {
                System.out.println("Ο αριθμός δε βρέθηκε");
            } else {
                System.out.printf("%d, %d", result[0], result[1]);
            }
        } catch (InputMismatchException e) {
            System.out.println("Λάθος τιμή");
        }
    }

    public static int[] getLowAndHighIndexOf(int[] arr, int key) {
        int[] returnedValues = new int[2];
        int low = -1;
        int high = -1;
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                low = i;
                break;
            }
        }
        for (int i = low + 1; i < arr.length; i++) {
            if (arr[i] != key) {
                break;
            }
            counter++;
        }

        high = low + counter;
        returnedValues[0] = low;
        returnedValues[1] = high;
        return returnedValues;
    }
}
