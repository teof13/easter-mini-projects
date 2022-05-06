package gr.aueb.cf.testbed.easterMiniProjects;

public class Project06MaxSubArray {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int start = 0;
        int end = 0;
        int localMax = 0;
        int globalMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            localMax = localMax + arr[i];
            if (arr[i] > localMax) {
                localMax = arr[i];
                start = i;
            }
            if (localMax > globalMax) {
                globalMax = localMax;
                end = i;
            }
        }

        System.out.print("maximum subarray: {");
        for (int i = start; i < end; i++) {
            System.out.printf("%d, ", arr[i]);
        }
        System.out.printf("%d}%n", arr[end]);
        System.out.printf("sum = %d%n", globalMax);

    }
}
