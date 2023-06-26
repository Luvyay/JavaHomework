package lesson5;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Map<String, ArrayList<String>> phonebook = new HashMap<>();

        boolean runProgram = true;

        while (runProgram) {
            String command = new Scanner(System.in).nextLine();
            String[] commandArray = teamSeparation(command);
            int com = 0; // index of command
            int lastName = 1; // index of last name
            int number = 2; // index of number

            switch (commandArray[com]) {
                case "ADD":
                    if (checkNumber(commandArray[number])) {
                        if (phonebook.containsKey(commandArray[lastName])) {
                            phonebook.get(commandArray[lastName]).add(commandArray[number]);
                        } else {
                            ArrayList<String> temp = new ArrayList<>();
                            temp.add(commandArray[number]);
                            phonebook.put(commandArray[lastName], temp);
                        }
                    } else {
                        System.out.println("Не верный формат телефона.");
                    }
                    break;
                case "GET":
                    if (phonebook.containsKey(commandArray[lastName])) {
                        System.out.println(phonebook.get(commandArray[lastName]));
                    } else {
                        System.out.println("Не найдена запись с фамилией \"" + commandArray[lastName] + "\"");
                    }
                    break;
                case "LIST":
                    printMap(phonebook);
                    break;
                case "REMOVE":
                    if (phonebook.containsKey(commandArray[lastName])) {
                        phonebook.remove(commandArray[lastName]);
                    } else {
                        System.out.println("Не найдена запись с фамилией \"" + commandArray[lastName] + "\"");
                    }
                    break;
                case "EXIT":
                    runProgram = false;
                    break;
                default:
                    System.out.println("Не верно указана команда.");
                    break;
            }
        }
    }

    private static String[] teamSeparation(String command){
        if (command.split(" ").length == 1 || command.split(" ").length == 2){
            String[] result = command.split(" ");

            return result;
        }

        int com = 0; // index of command
        int lastName = 1; // index of last name
        int number = 2; // index of number

        String[] result = new String[3];
        String[] commandSplit = command.split(" ");

        result[com] = commandSplit[com];
        result[lastName] = commandSplit[lastName];

        int size = command.length();
        int startIndex = commandSplit[com].length() + commandSplit[lastName].length() + 2;

        result[number] = command.substring(startIndex, size);

        return result;
    }

    private static boolean checkNumber(String number){
        Set<Character> settingElement = new HashSet<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8',
                '9', '+', '-', '(', ')'));
        char[] charArrayOfNumber = number.replace(" ", "").toCharArray();

        for(char element: charArrayOfNumber){
            if (!settingElement.contains(element)){
                return false;
            }
        }

        return true;
    }

    private static void printMap(Map<String, ArrayList<String>> phonebook){
        int count = 0;
        for(String key: phonebook.keySet()){
            if(count == 0){
                System.out.printf("%s = %s", key, phonebook.get(key));
            } else {
                System.out.printf(", %s = %s", key, phonebook.get(key));
            }

            count++;
        }
        System.out.println();
    }
}
