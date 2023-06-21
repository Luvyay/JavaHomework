package lesson4;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        /*
        Реализовать консольное приложение, которое:
        1. Принимает от пользователя и “запоминает” строки.
        2. Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
        3. Если введено revert, удаляет предыдущую введенную строку из памяти.
        4. Если введено exit, то программа завершается

        > - ввод в консоль (stdin), < - вывод на консоль (stdout)
        > java
        > python
        > c#
        > print
        < [c#, python, java]
        > revert
        > print
        < [python, java]
        > revert
        > revert
        > print
        < []
        > revert -> throw new NoSuchElementException
         */

        boolean flagContinue = true;
        Scanner scanner = new Scanner(System.in);
        Deque<String> storage = new LinkedList<>();

        while(flagContinue){
            String command = scanner.nextLine();

            switch (command){
                case "exit":
                    flagContinue = false;
                    break;
                case "print":
                    System.out.println(storage);
                    break;
                case "revert":
                    if (storage.size() != 0) {
                        storage.removeFirst();
                    } else {
                        System.out.println("throw new NoSuchElementException");
                    }
                    break;
                default:
                    storage.addFirst(command);
                    break;
            }
        }
    }
}
