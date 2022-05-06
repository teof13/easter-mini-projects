package gr.aueb.cf.testbed.easterMiniProjects;

import java.util.InputMismatchException;
import java.util.Scanner;



public class Project02Phonebook {
    static Scanner in = new Scanner(System.in);
    static int rows = 500;
    static int columns = 3;
    static String[][] contacts = new String[rows][columns];
    static int top = -1;

    public static void main(String[] args) {

        int choice = 0;

        do {
            showMenu();

            try {
                choice = getChoice();
                manageChoice(choice);
            } catch (InputMismatchException e) {
                System.out.println("Παρακαλώ δώστε έναν ακέραιο");
            }
        } while (choice != 5);
    }

    public static void showMenu() {
        System.out.println("1. Αναζήτηση τηλεφώνου");
        System.out.println("2. Εισαγωγή επαφής");
        System.out.println("3. Ενημέρωση επαφής");
        System.out.println("4. Διαγραφή επαφής");
        System.out.println("5. Έξοδος από το πρόγραμμα");
    }

    public static int getChoice() {


        try {
            int choice = in.nextInt();
            in.nextLine();
            return choice;
        } catch (InputMismatchException e) {
            in.nextLine();
            throw e;
        }
    }

    public static void manageChoice(int choice) {

        switch (choice) {
            case 1:
                searchContacts();
                break;
            case 2:
                insertContact();
                break;
            case 3:
                updateContact();
                break;
            case 4:
                deleteContact();
                break;
            case 5:
                in.close();
                System.out.println("Επιλέξατε έξοδο");
                break;
            default:
                System.out.println("Επιλέξτε απο 1 έως 5");
                break;
        }
        System.out.println();
    }

    public static void searchContacts() {
        int position = -1;
        String inputPhone;

        if (isEmpty()) {
            System.out.println("Δεν υπάρχουν επαφές στον πίνακα");
            return;
        }

        System.out.println("Παρακαλώ εισάγετε το τηλέφωνο για αναζήτηση");
        inputPhone = in.next();
        in.nextLine();
        position = getContactPosition(inputPhone);
        if (position != -1) {
            System.out.println("Η επαφή είναι: " + contacts[position][0] + " " + contacts[position][1]);
        } else {
            System.out.println("Η επαφή δε βρέθηκε");
        }
    }

    public static void insertContact() {

        if (isFull()) {
            System.out.println("Ο πίνακας είναι γεμάτος");
            return;
        }

        String inputLastName;
        String inputFirstName ;
        String inputPhone;

        System.out.println("Παρακαλώ εισάγετε το επώνυμο");
        inputLastName = in.next();
        in.nextLine();

        System.out.println("Παρακαλώ εισάγετε το όνομα");
        inputFirstName = in.next();
        in.nextLine();

        System.out.println("Παρακαλώ εισάγετε το τηλέφωνο");
        inputPhone = in.next();
        in.nextLine();

        if (getContactPosition(inputPhone) == -1) {
            top++;
            contacts[top][0] = inputLastName;
            contacts[top][1] = inputFirstName;
            contacts[top][2] = inputPhone;
            System.out.println("Επιτυχής εισαγωγή");
        } else {
            System.out.println("Η επαφή υπάρχει ήδη");
        }

    }

    public static void updateContact() {
        int positionToUpdate;
        String inputPhone;

        if (isEmpty()) {
            System.out.println("Δεν υπάρχουν επαφές στον πίνακα");
            return;
        }

        System.out.println("Παρακαλώ εισάγετε το τηλέφωνο της επαφής για ανανέωση");
        inputPhone = in.next();
        in.nextLine();

        positionToUpdate = getContactPosition(inputPhone);

        if (positionToUpdate == -1) {
            System.out.println("Η επαφή δε βρέθηκε");
            return;
        }

        System.out.println("Εισάγετε το νέο επώνυμο");
        contacts[positionToUpdate][0] = in.next();

        System.out.println("Εισάγετε το νέο όνομα");
        contacts[positionToUpdate][1] = in.next();

        System.out.println("Επιτυχής ενημέρωση");
    }

    public static void deleteContact() {
        int positionToDelete;
        String inputPhone;

        if (isEmpty()) {
            System.out.println("Δεν υπάρχουν επαφές στον πίνακα");
            return;
        }

        System.out.println("Παρακαλώ εισάγετε το τηλέφωνο της επαφής για διαγραφή");
        inputPhone = in.next();
        in.nextLine();

        positionToDelete = getContactPosition(inputPhone);

        if (positionToDelete == -1) {
            System.out.println(" Η επαφή δε βρέθηκε");
            return;
        }

        for (int i = positionToDelete; i <= contacts.length - 2; i++) {
            contacts[i] = contacts[i+1];
        }

        top = top - 1;

        System.out.println("Επιτυχής διαγραφή");
    }

    public static int getContactPosition(String phone){
        int position = -1;


        for (int i = 0; i < top + 1; i++) {
            if ((contacts[i][2] != null) && contacts[i][2].equals(phone)) {
                position = i;
                break;
            }
        }
        return position;
    }


    public static boolean isFull() {
        return (top == contacts.length - 1);
    }

    public static boolean isEmpty() {
        return (top == -1);
    }
}
