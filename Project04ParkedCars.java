package gr.aueb.cf.testbed.easterMiniProjects;

import java.util.Arrays;

public class Project04ParkedCars {
    public static void main(String[] args) {
        int[][] arr = {{1012, 1136}, {1317, 1417}, {1015, 1020}};
        int max = 0;
        int counter = 0;

        int[][] arr2 = new int[arr.length * 2][2];

        for (int i = 0, j = 0; i < arr2.length; i++) {
            if (i % 2 == 0) {
                arr2[i][0] = arr[j][0];
                arr2[i][1] = 1;
            } else {
                arr2[i][0] = arr[j][1];
                arr2[i][1] = 0;
                j++;
            }
        }

        Arrays.sort(arr2, (a1, a2) -> a1[0] - a2[0]);

        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i][1] == 1) {
                counter++;
            } else {
                counter--;
            }
            if (counter > max) max = counter;
        }

        System.out.println(max);

    }
}
