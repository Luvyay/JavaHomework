package lesson3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        /*
        Пусть дан произвольный список целых чисел.

        1) Найти максимальное значение
        2) Найти минимальное значение
        3) Найти среднее (арифметическое) значение
        4) Нужно удалить из него чётные числа
         */

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the size of list: ");
        int size = scanner.nextInt();
        System.out.print("Please enter the min value: ");
        int minValue = scanner.nextInt();
        System.out.print("Please enter the max value: ");
        int maxValue = scanner.nextInt();

        ArrayList<Integer> arrayList = createRandomList(size, minValue, maxValue);

        System.out.println(arrayList);

        System.out.println(findMaxValueInList(arrayList));
        System.out.println(findMinValueInList(arrayList));
        System.out.println(calculateVverage(arrayList));

        removeEvenValue(arrayList);

        System.out.println(arrayList);
    }

    static ArrayList<Integer> createRandomList(int size, int minValue, int maxValue){
        Random random = new Random();
        size = Math.abs(size);
        ArrayList<Integer> arrList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            arrList.add(random.nextInt(maxValue - minValue + 1) + minValue);
        }

        return arrList;
    }

    static int findMaxValueInList(ArrayList<Integer> arrayList){
        int maxValue = arrayList.get(0);

        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i) > maxValue){
                maxValue = arrayList.get(i);
            }
        }

        return maxValue;
    }

    static int findMinValueInList(ArrayList<Integer> arrayList){
        int minValue = arrayList.get(0);

        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i) < minValue){
                minValue = arrayList.get(i);
            }
        }

        return minValue;
    }

    static void removeEvenValue(ArrayList<Integer> arrayList){
        int index = 0;

        while(index < arrayList.size()){
            if (arrayList.get(index) % 2 == 0){
                arrayList.remove(index);
            } else {
                index++;
            }
        }
    }

    static double calculateVverage(ArrayList<Integer> arrayList){
        int sum = 0;

        for (int i = 0; i < arrayList.size(); i++) {
            sum += arrayList.get(i);
        }

        return sum / arrayList.size();
    }
}
