package askhseis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class project03{

    // testing n03 create test branch push merge solving conflicts
    public static void main(String[] args) {
        String filename = "C:/project03/project03.txt";
        int[][] frequencyTable = new int[128][2];


        for (int i = 0; i < 128; i++) {
            frequencyTable[i][0] = -1;
            frequencyTable[i][1] = 0;
        }


        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int c;
            while ((c = br.read()) != -1) {
                if (Character.isWhitespace(c)) {
                    continue;
                }

                boolean found = false;

                for (int i = 0; i < 128; i++) {
                    if (frequencyTable[i][0] == c) {
                        frequencyTable[i][1]++;
                        found = true;
                        break;
                    } else if (frequencyTable[i][0] == -1) {
                        frequencyTable[i][0] = c;
                        frequencyTable[i][1] = 1;
                        found = true;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("Στατιστικά κατά χαρακτήρα:");

        sortByCharacter(frequencyTable);


        for (int i = 0; i < 128; i++) {
            if (frequencyTable[i][0] != -1) {
                System.out.println((char) frequencyTable[i][0] + ": " + frequencyTable[i][1]);
            }
        }

        System.out.println("\nΣτατιστικά κατά συχνότητα:");

        sortByFrequency(frequencyTable);


        for (int i = 0; i < 128; i++) {
            if (frequencyTable[i][0] != -1) {
                System.out.println((char) frequencyTable[i][0] + ": " + frequencyTable[i][1]);
            }
        }
    }

    // testing n03 create test branch push merge solving conflicts
    public static void sortByCharacter(int[][] frequencyTable) {
        for (int i = 0; i < frequencyTable.length - 1; i++) {
            for (int j = i + 1; j < frequencyTable.length; j++) {
                if (frequencyTable[i][0] > frequencyTable[j][0] && frequencyTable[j][0] != -1) {

                    int[] temp = frequencyTable[i];
                    frequencyTable[i] = frequencyTable[j];
                    frequencyTable[j] = temp;
                }
            }
        }
    }


    public static void sortByFrequency(int[][] frequencyTable) {
        for (int i = 0; i < frequencyTable.length - 1; i++) {
            for (int j = i + 1; j < frequencyTable.length; j++) {

                if (frequencyTable[i][1] < frequencyTable[j][1] ||
                        (frequencyTable[i][1] == frequencyTable[j][1] && frequencyTable[i][0] > frequencyTable[j][0])) {

                    int[] temp = frequencyTable[i];
                    frequencyTable[i] = frequencyTable[j];
                    frequencyTable[j] = temp;
                }
            }
        }
    }
}