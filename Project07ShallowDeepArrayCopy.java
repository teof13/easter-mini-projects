package gr.aueb.cf.testbed.easterMiniProjects;

public class Project07ShallowDeepArrayCopy {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 2 ,3},
                        {4, 5, 6}};
        int[][] arr2;
        int[][] arr3;

        arr2 = shallowCopy(arr1);
        arr3 = deepCopy(arr1);

        System.out.println("Shallow Copy:");
        System.out.printf("arr1[0][0] = %d, arr2[0][0] = %d%n", arr1[0][0], arr2[0][0]);
        arr2[0][0] = 20;
        System.out.println("Μετά από αλλαγή στο arr2[0][0]:");
        System.out.printf("arr1[0][0] = %d, arr2[0][0] = %d%n", arr1[0][0], arr2[0][0]);

        System.out.println();
        System.out.println("Deep Copy:");
        System.out.printf("arr1[1][1] = %d, arr3[1][1] = %d%n", arr1[1][1], arr3[1][1]);
        arr3[1][1] = 20;
        System.out.println("Μετά από αλλαγή στο arr3[1][1]:");
        System.out.printf("arr1[1][1] = %d, arr3[1][1] = %d%n", arr1[1][1], arr3[1][1]);
    }

    public static int[][] shallowCopy(int[][] arr) {
        int[][] returnedArray;
        returnedArray = arr;
        return returnedArray;
    }

    public static int[][] deepCopy(int[][] arr) {
        int[][] returnedArray = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0;  j < arr[0].length; j++) {
                returnedArray[i][j] = arr[i][j];
            }
        }

        return returnedArray;
    }
}
