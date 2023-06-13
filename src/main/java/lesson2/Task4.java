package lesson2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task4 {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(Task4.class.getName());
        logger.setUseParentHandlers(false);
        FileHandler fh = new FileHandler("calc_log.txt");
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        logger.addHandler(fh);

        System.out.print("Please enter the first value: ");
        Scanner scanner = new Scanner(System.in);
        int firstValue = scanner.nextInt();
        logger.info("Получили первое значение:  " + firstValue);

        System.out.print("Please enter the operation (+, -, /, *): ");
        char operationValue = scanner.next().charAt(0);
        logger.info("Получили оператор значение:  " + operationValue);

        System.out.print("Please enter the second value: ");
        int secondValue = scanner.nextInt();
        logger.info("Получили второе значение:  " + secondValue);

        switch (operationValue){
            case '+':
                System.out.println(firstValue + " + " + secondValue + " = " +
                        plus(firstValue, secondValue));
                logger.info("Произвели операцию сложения и вывели результат. Результат:  " +
                        plus(firstValue, secondValue));
                break;
            case '-':
                System.out.println(firstValue + " - " + secondValue + " = " +
                        minus(firstValue, secondValue));
                logger.info("Произвели операцию вычитания и вывели результат. Результат:  " +
                        minus(firstValue, secondValue));
                break;
            case '/':
                if (secondValue != 0){
                    System.out.println(firstValue + " / " + secondValue + " = " +
                            divide(firstValue, secondValue));
                    logger.info("Произвели операцию деления и вывели результат. Результат:  " +
                            divide(firstValue, secondValue));
                } else {
                    System.out.println("You can't divide by 0!");
                    logger.info("Вывели ошибку о том, что второе значение является 0 и на 0 делить нельзя.");
                }
                break;
            case '*':
                System.out.println(firstValue + " * " + secondValue + " = " +
                        mult(firstValue, secondValue));
                logger.info("Произвели операцию умножения и вывели результат. Результат:  " +
                        mult(firstValue, secondValue));
                break;
            default:
                System.out.println("Wrong operation!");
                logger.info("Отобразили ошибку о не правильном операторе.");
        }
    }

    static int plus(int firstValue, int secondValue) {
        return firstValue + secondValue;
    }

    static int minus(int firstValue, int secondValue) {
        return firstValue - secondValue;
    }

    static int mult(int firstValue, int secondValue) {
        return firstValue * secondValue;
    }

    static int divide(int firstValue, int secondValue) {
        if (secondValue != 0) return firstValue / secondValue;
        else return 0;
    }
}
