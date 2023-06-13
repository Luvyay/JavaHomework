package lesson2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task2 {
    public static void main(String[] args) {
         /*
        2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации
        запишите в лог-файл.
         */

        System.out.print("Please enter the amount of array: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] someArray = new int[size];
        Random random = new Random();

        for (int i = 0; i < someArray.length; i++) {
            someArray[i] = random.nextInt(10);
        }

        System.out.println(Arrays.toString(someArray));

        sortedBuble(someArray);

        System.out.println(Arrays.toString(someArray));
    }

    static void sortedBuble(int[] someArray) {
        try {
            Logger logger = Logger.getLogger(Task2.class.getName());
            logger.setUseParentHandlers(false);
            FileHandler fh = new FileHandler("log.txt");
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
            logger.addHandler(fh);
            logger.info("Полученный массив: " + Arrays.toString(someArray));

            int sizeArray = someArray.length - 1;
            for (int i = 0; i < sizeArray; i++) {
                for (int j = 0; j < sizeArray - i; j++) {
                    if (someArray[j] > someArray[j+1]){
                        int temp = someArray[j];
                        someArray[j] = someArray[j+1];
                        someArray[j+1] = temp;
                        logger.info(someArray[j+1] + "<=>" + someArray[j] + "\n" +
                                "Подробно: в массиве " + Arrays.toString(someArray) +
                                " следующие элементы поменялись местами: " +
                                someArray[j+1] + " (index: " + String.valueOf(j) + ")" + " <=> " +
                                someArray[j] + " (index: " + String.valueOf(j+1) + ")");
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
