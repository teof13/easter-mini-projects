package gr.aueb.cf.testbed.easterMiniProjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Project03Chars {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int len = 0;
        int n = 0;
        int bufSize = 8192;
        char[] buf = new char[bufSize];
        int[][] chars = new int[256][2];
        int[][] copiedCharSort;
        int[][] copiedFreqSort;
        int pivot = -1;
        int c = 0;
        int position = -1;


        for (int[] row: chars) {
            Arrays.fill(row, 0);
        }

        try {
            BufferedReader bf = new BufferedReader(new FileReader("G:/My Drive/codingfactory/java/coding-factory/src/gr/aueb/cf/testbed/easterMiniProjects/text.txt"));

            while ((n = bf.read(buf, 0, bufSize)) != -1) {
                sb.append(buf, 0, n);
                len += n;
            }
        } catch (IOException e) {
            System.out.println("Το αρχείο δε βρέθηκε");
            System.exit(1);
        }

        if (sb.length() == 0) {
            System.out.println("Το αρχείο είναι κενό");
            System.exit(2);
        }



        for (int i = 0; i < sb.length(); i++) {
            c = sb.charAt(i);
            position = getPosition(chars, pivot, c);
            if (position != -1) {
                chars[position][1]++;
            } else {
                chars[++pivot][0] = c;
                chars[pivot][1]++;
            }
        }


        copiedCharSort = new int[pivot + 1][2];
        copiedFreqSort = new int[pivot + 1][2];
        for (int i = 0; i <= pivot; i++) {
            copiedCharSort[i] = Arrays.copyOf(chars[i], 2);
            copiedFreqSort[i] = Arrays.copyOf(chars[i], 2);
        }
        Arrays.sort(copiedCharSort, (a1, a2) -> a1[0] - a2[0]);
        Arrays.sort(copiedFreqSort, (a1, a2) -> a2[1] - a1[1]);


        System.out.println("Ταξινόμηση ανα χαρακτήρα");
        for (int i = 0; i <= pivot; i++) {
            System.out.printf("%c %.2f%%%n", (char) copiedCharSort[i][0], (double) copiedCharSort[i][1] / sb.length() * 100);
        }

        System.out.println();
        System.out.println("Ταξινόμηση ανα συχνότητα");
        for (int i = 0; i <= pivot; i++) {
            System.out.printf("%c %.2f%%%n", (char) copiedFreqSort[i][0], (double) copiedFreqSort[i][1] / sb.length() * 100);
        }
    }

    public static int getPosition(int[][] chars, int pivot, int c) {
        for (int i = 0; i < pivot + 1; i++) {
            if (chars[i][0] == c) return i;
        }
        return -1;
    }
}
