package lesson1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        /*
        Task 2
        2. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из
        диагоналей, если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу:
        индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
         */

        System.out.println("This program create a 2d array with diagonals equal to 1.\n" +
                "Please enter the amount of rows (amount of rows and" +
                " amount of columns are equal):");
        Scanner scanner = new Scanner(System.in);
        int amountRowsColumns = scanner.nextInt();
        int minValue = 5;
        int maxValue = 7;
        int[][] arr = new int[amountRowsColumns][amountRowsColumns];

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j || arr[i].length - i - 1 == j){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = random.nextInt(maxValue - minValue + 1) + minValue;
                }
            }
        }

        for (int[] item: arr){
            System.out.println(Arrays.toString(item));
        }
    }
}
