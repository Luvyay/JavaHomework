package lesson1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        /*
        Task 1
        1. Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
         */

        System.out.println("This program create a array.\n" +
                "Please enter the size of array:");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        System.out.println("Please enter the min value:");
        int minValue = scanner.nextInt();

        System.out.println("Please enter the max value:");
        int maxValue = scanner.nextInt();

        int[] arr = new int[size];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.stream(arr).min());
        System.out.println(Arrays.stream(arr).max());
    }
}
