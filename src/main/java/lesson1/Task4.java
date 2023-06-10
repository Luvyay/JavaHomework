package lesson1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        /*
        4.** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
        или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются
        циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1
        (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в
        какую сторону сдвиг можете выбирать сами.
         */

        System.out.print("Please enter the amount of array: ");
        Scanner scanner = new Scanner(System.in);
        int sizeArray = scanner.nextInt();
        int minValue = 1;
        int maxValue = 10;
        Random random = new Random();
        int[] arr = new int[sizeArray];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt((maxValue - minValue) + 1) + minValue;
        }

        System.out.println(Arrays.toString(arr));

        System.out.print("How much to move: ");
        int shift = scanner.nextInt();

        ShiftArray(arr, shift);

        System.out.println(Arrays.toString(arr));
    }

    static void ShiftArray(int[] arr, int valueShift){
        if (valueShift > 0) {
            for (int i = 0; i < valueShift; i++) {
                for (int j = arr.length - 1; j >= 1; j--) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }else if (valueShift < 0){
            for (int i = valueShift; i < 0; i++) {
                for (int j = 0; j < arr.length - 1; j++) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
