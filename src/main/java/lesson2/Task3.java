package lesson2;

import java.io.File;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        /*
        3) Дана json-строка (можно сохранить в файл и читать из файла)
        [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
        {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
        {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
        Написать метод(ы), который распарсит json и, используя StringBuilder, создаст
        строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
        Пример вывода:
        Студент Иванов получил 5 по предмету Математика.
        Студент Петрова получил 4 по предмету Информатика.
        Студент Краснов получил 5 по предмету Физика.
         */

        String textRequests = readFileJson("grades.txt");

        textRequests = textRequests.replace("[", "").replace("]", "").replace("},", "};");
        String[] requeststArr = textRequests.split(";");

        for(String item: requeststArr){
            System.out.println(displayJSONForRead(item));
        }
    }

    static StringBuilder displayJSONForRead(String someJSON){
        String workString = someJSON;
        workString = workString.replace("{", "").replace("}", "").replace("\"",
                "").replace("\n", "");
        String[] workStringArr = workString.split(",");
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for(String element: workStringArr){
            switch (count){
                case 1:
                    sb.append("Студент " + element.split(":")[1]);
                    break;
                case 2:
                    sb.append(" получил " + element.split(":")[1]);
                    break;
                case 3:
                    sb.append(" по предмету " + element.split(":")[1] + ".");
                    break;
            }
            count++;
        }

        return sb;
    }

    static String readFileJson(String name){
        String result = "";

        try {
            File fileForRead = new File(name);
            Scanner scanner = new Scanner(fileForRead);

            while(scanner.hasNextLine()){
                result += scanner.nextLine() + "\n";
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
