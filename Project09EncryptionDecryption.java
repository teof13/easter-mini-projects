package gr.aueb.cf.testbed.easterMiniProjects;

import java.util.ArrayList;

public class Project09EncryptionDecryption {
    public static void main(String[] args) {
        String message = "Coding Factory Java test message#";
        int key = 1437;

        ArrayList<Integer> encryptedMessage = encryptMessage(message, key);

        StringBuilder decryptedMessage = decryptMessage(encryptedMessage, key);

        for (int i = 0; i < encryptedMessage.size(); i++){
            System.out.print(encryptedMessage.get(i) + " ");
        }

        System.out.println();

        System.out.println(decryptedMessage);
    }

    public static ArrayList<Integer> encryptMessage(String message, int key) {
        int encryptedChar = 0;
        ArrayList<Integer> encryptedMessage = new ArrayList<>();

        if (message != null && message.length() != 0) {
            encryptedMessage.add((int) message.charAt(0));
        }
        for (int i = 1; i < message.length(); i++) {
            if (message.charAt(i) == '#') {
                encryptedMessage.add(-1);
                break;
            }
            encryptedChar = (message.charAt(i) + encryptedMessage.get(i-1)) % key;
            encryptedMessage.add(encryptedChar);
        }
        return encryptedMessage;
    }

    public static StringBuilder decryptMessage(ArrayList<Integer> encryptedMessage, int key) {
        int decryptedChar = 0;
        StringBuilder decryptedMessage = new StringBuilder();


        if (encryptedMessage.size() != 0) {
            decryptedChar = encryptedMessage.get(0);
            decryptedMessage.append((char) decryptedChar);
        }
        for (int i = 1; i < encryptedMessage.size(); i++) {
            if (encryptedMessage.get(i) == -1) {
                decryptedMessage.append('#');
                break;
            }
            decryptedChar = (encryptedMessage.get(i) >= encryptedMessage.get(i-1)) ? encryptedMessage.get(i) - encryptedMessage.get(i-1) : encryptedMessage.get(i) - encryptedMessage.get(i-1) + key;
            decryptedMessage.append((char) decryptedChar);
        }
        return decryptedMessage;
    }
}
