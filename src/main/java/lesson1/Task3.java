package lesson1;

import java.time.LocalTime;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        /*
        3. В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
        "Доброе утро, <Имя>!", если время от 05:00 до 11:59
        "Добрый день, <Имя>!", если время от 12:00 до 17:59;
        "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
        "Доброй ночи, <Имя>!", если время от 23:00 до 4:59
         */

        LocalTime timeMorningLower = LocalTime.of(5,0);
        LocalTime timeMorningUpper = LocalTime.of(11,59);
        LocalTime timeDayLower = LocalTime.of(12,0);
        LocalTime timeDayUpper = LocalTime.of(17,59);
        LocalTime timeEveningLower = LocalTime.of(18,0);
        LocalTime timeEveningUpper = LocalTime.of(22,59);
        LocalTime timeNightLower = LocalTime.of(23,0);
        LocalTime timeNightUpper = LocalTime.of(4,59);
        LocalTime nowTime = LocalTime.now();
        Scanner scaner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = scaner.next();

        if ((nowTime.compareTo(timeMorningLower) == 1 && nowTime.compareTo(timeMorningUpper) == -1) ||
        (nowTime.compareTo(timeMorningLower) == 0 || nowTime.compareTo(timeMorningUpper) == 0)){
            System.out.println("Доброе утро, " + name + "!");
        }
        if ((nowTime.compareTo(timeDayLower) == 1 && nowTime.compareTo(timeDayUpper) == -1) ||
        (nowTime.compareTo(timeDayLower) == 0 || nowTime.compareTo(timeDayUpper) == 0)){
            System.out.println("Добрый день, " + name + "!");
        }
        if ((nowTime.compareTo(timeEveningLower) == 1 && nowTime.compareTo(timeEveningUpper) == -1) ||
        (nowTime.compareTo(timeEveningLower) == 0 || nowTime.compareTo(timeEveningUpper) == 0)){
            System.out.println("Добрый вечер, " + name + "!");
        }
        if ((nowTime.compareTo(timeNightLower) == 1 && nowTime.compareTo(timeNightUpper) == -1) ||
        (nowTime.compareTo(timeNightLower) == 0 || nowTime.compareTo(timeNightUpper) == 0)){
            System.out.println("Доброй ночи, " + name + "!");
        }
    }
}
