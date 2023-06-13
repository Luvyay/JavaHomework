package lesson2;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Task3v2 {
    public static void main(String[] args) throws ParseException {
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

        Object obj = new JSONParser().parse(textRequests);
        JSONArray ja = (JSONArray) obj;
        Iterator students = ja.iterator();

        while (students.hasNext()){
            JSONObject student = (JSONObject) students.next();

            String lastName = (String) student.get("фамилия");
            String grade = (String) student.get("оценка");
            String lesson = (String) student.get("предмет");

            System.out.println("Студент " + lastName + " получил " + grade +
                    " по предмету " + lesson + ".");
        }
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
