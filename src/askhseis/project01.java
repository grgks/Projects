package askhseis;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class project01 {
    public static void main(String[] args) {


        //testing for creating branch
    try (Scanner in = new Scanner(new File("C:/LOTTO/lotto.txt"));
         PrintStream ps = new PrintStream("C:/LOTTO/lotto.out.txt", StandardCharsets.UTF_8)) {

        final int LOTTO_SIZE = 6;
        int[] inputNumbers = new int[49];
        int pivot = 0;
        int[] result = new int[LOTTO_SIZE];
        int num;
        int window;

        while ((num = in.nextInt()) != -1 && pivot <= 49) {
            inputNumbers[pivot++] = num;
        }

        int[] numbers = Arrays.copyOfRange(inputNumbers, 0, pivot);
        Arrays.sort(numbers);

        window = pivot - LOTTO_SIZE;
        for (int i = 0; i <= window; i++) {
            for (int j = i + 1; j <= window + 1; j++) {
                for (int k = j + 1; k <= window + 2; k++) {
                    for (int l = k + 1; l <= window + 3; l++) {
                        for (int m = l + 1; m <= window + 4; m++) {
                            for (int n = m + 1; n <= window + 5; n++) {
                                result[0] = numbers[i];
                                result[1] = numbers[j];
                                result[2] = numbers[k];
                                result[3] = numbers[l];
                                result[4] = numbers[m];
                                result[5] = numbers[n];

                                if (!isEven(result, 4) && !isOdd(result, 4) && !sameTen(result, 3)
                                        && !sameEnding(result, 3) && !consecutive(result)) {
                                    ps.printf("%d %d %d %d %d %d\n",
                                            result[0], result[1], result[2], result[3], result[4], result[5]);
                                    System.out.printf("%d %d %d %d %d %d\n",
                                            result[0], result[1], result[2], result[3], result[4], result[5]);
                                }
                            }
                        }
                    }
                }
            }
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
}
    public static boolean isEven(int[] arr, int threshold) {
        long evenCount = 0;

        evenCount = Arrays.stream(arr)
                .filter(num -> num % 2 == 0)
                .count();
        return evenCount >= threshold;
}
    public static boolean isOdd(int[] arr, int threshold) {
        long odds = 0;

       for (int num : arr) {
            if (num % 2 != 0) odds++;
       }

       return odds >= threshold;


}
    public static boolean sameEnding(int[] arr, int threshold) {
        int[] endings = new int[10];

        for (int num : arr) {
            endings[num % 10]++;
        }

        return Arrays.stream(endings).anyMatch(e -> e >= threshold);
    }
    public static boolean sameTen(int[] arr, int threshold) {
        int[] ten = new int[5];

        for (int num : arr) {
            ten[num/10]++;
        }

        return Arrays.stream(ten).anyMatch(t -> t >= threshold);
    }
    public static boolean consecutive(int[] arr) {
    if (arr == null)return false;
        int consecutiveCount = 0;

        for (int i = 0; i < arr.length -2; i++) {
            if ((arr[i] == arr[i + 1] - 1) && (arr[i] == arr[i+2] - 2)){
                consecutiveCount++;
                break;
            }
        }

        return consecutiveCount >= 1;
    }
}








