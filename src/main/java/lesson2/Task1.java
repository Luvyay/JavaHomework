package lesson2;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        /*
        1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса,
        используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
        Если значение null, то параметр не должен попадать в запрос.
        Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
         */

        String inputString = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String textRequest = "select * from students where ";

        StringBuilder sb = new StringBuilder(textRequest);

        String[] arrString = convertJsonToArray(inputString);

        int count = 0;
        for(int i = 0; i < arrString.length; i++) {
            if (arrString[i] != null) {
                count++;
                if (count == 1) sb.append(arrString[i]);
                else sb.append(" and " + arrString[i]);
            }
        }

        System.out.println(sb);
    }

    static String[] convertJsonToArray(String someJson){
        String newString = someJson;
        newString = newString.replace("{","").replace("}","").replace("\"","");

        String[] arrString = new String[newString.split(", ").length];
        int index = 0;
        for(String item: newString.split(", ")){
            if (!item.split(":")[1].contains("null")){
                arrString[index] = item.split(":")[0] + "='" + item.split(":")[1] + "'";
            }
            index++;
        }

        return arrString;
    }
}
