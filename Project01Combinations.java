package gr.aueb.cf.testbed.easterMiniProjects;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Project01Combinations {
    public static void main(String[] args) throws FileNotFoundException {
        int numbersLength = 0;
        int maxNumbersLength = 49;
        int minNumbersLength = 6;
        int[] numbers = new int[maxNumbersLength];
        int n = 6;
        int[] combination = new int[n];
        int low = 1;
        int high = 49;
        String inputFilePath = "G:/My Drive/codingfactory/java/coding-factory/src/gr/aueb/cf/testbed/easterMiniProjects/numbers.txt";
        String outFilePath = "G:/My Drive/codingfactory/java/coding-factory/src/gr/aueb/cf/testbed/easterMiniProjects/combinations.txt";

        try  {
            numbersLength = putNumbersToArray(numbers, maxNumbersLength, low, high, inputFilePath) + 1;
        } catch (FileNotFoundException e) {
            System.out.println("Σφάλμα: Το αρχείο εισόδου δε βρέθηκε");
            System.exit(-1);
        } catch (InputMismatchException e) {
            System.out.println("Σφάλμα: Το αρχείο εισόδου πρέπει να περιέχει μόνο ακέραιους");
            System.exit(-2);
        }

        if (numbersLength == -1) {
            System.out.printf("Σφάλμα: Το αρχείο εισόδου πρέπει να περιέχει ακέραιους από το %d εως το %d%n", low, high);
            System.exit(-3);
        }
        if (!numberIsInLimits(numbersLength, minNumbersLength, maxNumbersLength)) {
            System.out.printf("Σφάλμα: Το αρχείο εισόδου πρέπει να περιέχει από %d εως %d ακέραιους%n", minNumbersLength, maxNumbersLength);
            System.exit(-4);
        }


        Arrays.sort(numbers, 0, numbersLength);

        try {
            createCombinations(numbersLength, numbers, n, combination, outFilePath);
        } catch (FileNotFoundException e) {
            System.out.println("Σφάλμα: Το αρχείο εξόδου δε βρέθηκε");
            System.exit(-5);
        }

        System.out.println("Το πρόγραμμα ολοκληρώθηκε με επιτυχία");

    }

    public static int putNumbersToArray(int[] numbers, int maxNumbersLength, int low, int high, String inputFilePath) throws FileNotFoundException, InputMismatchException {
        int number = 0;
        int top = -1;

        try (Scanner in = new Scanner(new File(inputFilePath));) {
            while (in.hasNext() && (number = in.nextInt()) != -1 && ++top < maxNumbersLength) {
                if (!numberIsInLimits(number, low, high)) return -2;
                numbers[top] = number;
            }
        } catch (FileNotFoundException | InputMismatchException e) {
            e.printStackTrace();
            throw e;
        }
        return top;
    }

    public static boolean numberIsInLimits(int number, int low, int high) {
        return (number >= low && number <= high);
    }

    public static void createCombinations(int numbersLength, int[] numbers, int n, int[] combination, String outFilePath) throws FileNotFoundException {
        try (PrintStream ps = new PrintStream(outFilePath);) {
            for (int i = 0; i <= numbersLength - n; i++) {
                for (int j = i + 1; j <= numbersLength - n + 1; j++) {
                    for (int k = j + 1; k <= numbersLength - n + 2; k++) {
                        for (int m = k + 1; m <= numbersLength -n + 3; m++) {
                            for (int p = m + 1; p <= numbersLength -n + 4; p++) {
                                for (int q = p + 1; q < numbersLength; q++) {
                                    combination[0] = numbers[i];
                                    combination[1] = numbers[j];
                                    combination[2] = numbers[k];
                                    combination[3] = numbers[m];
                                    combination[4] = numbers[p];
                                    combination[5] = numbers[q];

                                    if (!isEven(combination) && (!isOdd(combination)) && (!isContiguous(combination)) && (!isSameEnding(combination)) &&
                                            (!isSameTen(combination))) {
                                        ps.printf("%d\t%d\t%d\t%d\t%d\t%d\n", numbers[i], numbers[j], numbers[k],numbers[m], numbers[p], numbers[q]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static boolean isEven(int[] combination) {
        int count = 0;
        for (int i = 0; i < combination.length; i++) {
            if (combination[i] % 2 == 0) count++;
        }
        return (count > 4);
    }

    public static boolean isOdd(int[] combination) {
        int count = 0;
        for (int i = 0; i < combination.length; i++) {
            if (combination[i] % 2 != 0) count++;
        }
        return (count > 4);
    }

    public static boolean isContiguous(int[] combination) {
        int count = 0;
        for (int i = 0; i < combination.length - 2; i++) {
            if (combination[i + 1] - combination[i] == 1 && combination[i + 2] - combination[i + 1] == 1) count++;
            if (count > 1) break;
        }
        return (count > 1);
    }

    public static boolean isSameEnding(int[] combination) {
        int count = 0;
        for (int i = 0; i < combination.length - 1; i++) {
            count = 0;
            for (int j = i + 1; j < combination.length; j++) {
                if (combination[i] % 10 == combination[j] % 10) count++;
            }
            if (count > 3) break;
        }
        return (count > 3);
    }

    public static boolean isSameTen(int[] combination) {
        int count = 0;
        for (int i = 0; i < combination.length - 1; i++) {
            count = 0;
            for (int j = i + 1; j < combination.length; j++) {
                if (combination[i] / 10 == combination[j] / 10) count++;
            }
            if (count > 3) break;
        }
        return (count > 3);
    }
}
