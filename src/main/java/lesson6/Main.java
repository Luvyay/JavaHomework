package lesson6;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Laptop> listLaptops = new ArrayList<>();

        System.out.print("Введите количество для генерации: ");

        int valueLaptops = new Scanner(System.in).nextInt();

        for (int i = 0; i < valueLaptops; i++) {
            listLaptops.add(new Laptop());
        }

        printListLaptops(listLaptops);

        System.out.println("Характеристики для фильтрации:");
        ArrayList<String> filterString = getStringSettingForFilter();
        ArrayList<Integer> filterInteger = getIntSettingForFilter();

        ArrayList<Laptop> listFilterLaptop = filterLaptops(listLaptops, filterString, filterInteger);

        if (listFilterLaptop.size() == 0){
            System.out.println("По данным параметрам ничего не найдено.");
        } else {
            printListLaptops(listFilterLaptop);
        }
    }

    public static void printListLaptops(ArrayList<Laptop> listLaptops){
        for (int i = 0; i < listLaptops.size(); i++) {
            System.out.println(listLaptops.get(i));
        }
    }

    public static ArrayList<String> getStringSettingForFilter(){
        String[] nameOfCharacteristics = new String[]{"Бренд", "Процессор", "Цвет"};
        ArrayList<String> filterSettingString = new ArrayList<>();

        for (int i = 0; i < nameOfCharacteristics.length; i++) {
            System.out.print(nameOfCharacteristics[i] + ": ");
            String characteristicsValue = new Scanner(System.in).nextLine();

            filterSettingString.add(characteristicsValue);
        }

        return filterSettingString;
    }

    public static ArrayList<Integer> getIntSettingForFilter(){
        String[] nameOfCharacteristics = new String[]{"Цена", "Опаративная память"};
        ArrayList<Integer> filterSettingInteger = new ArrayList<>();

        for (int i = 0; i < nameOfCharacteristics.length; i++) {
            System.out.print(nameOfCharacteristics[i] + ": ");
            String characteristicsValue = new Scanner(System.in).nextLine();

            if (characteristicsValue == "") {
                filterSettingInteger.add(null);
            } else {
                filterSettingInteger.add(Integer.parseInt(characteristicsValue));
            }
        }

        return filterSettingInteger;
    }

    public static ArrayList<Laptop> filterLaptops(ArrayList<Laptop> listLaptops, ArrayList<String> filterString,
                                                  ArrayList<Integer> filterInteger){
        ArrayList<Laptop> resultFilter = new ArrayList<>(listLaptops);

        int i = resultFilter.size() - 1;
        while(i >= 0) {
            int indexBrand = 0;
            int indexCPU = 1;
            int indexColor = 2;
            boolean flagForRemove = false;

            String[] getValue = new String[]{resultFilter.get(i).getBrand(), resultFilter.get(i).getCpu(),
                    resultFilter.get(i).getColor()};

            if (filterString.get(indexBrand) != "" && !filterString.get(indexBrand).equals(getValue[indexBrand])){
                flagForRemove = true;
            }
            if (filterString.get(indexCPU) != "" && !filterString.get(indexCPU).equals(getValue[indexCPU])){
                flagForRemove = true;
            }
            if (filterString.get(indexColor) != "" && !filterString.get(indexColor).equals(getValue[indexColor])){
                flagForRemove = true;
            }

            if (flagForRemove){
                resultFilter.remove(i);
            }

            i--;
        }

        i = resultFilter.size() - 1;
        while(i >= 0) {
            int indexPrice = 0;
            int indexRAM = 1;
            boolean flagForRemove = false;

            int[] getValue = new int[]{resultFilter.get(i).getPrice(), resultFilter.get(i).getRam()};

            if (filterInteger.get(indexPrice) != null && !(filterInteger.get(indexPrice) == getValue[indexPrice])){
                flagForRemove = true;
            }
            if (filterInteger.get(indexRAM) != null && !(filterInteger.get(indexRAM).equals(getValue[indexRAM]))){
                flagForRemove = true;
            }

            if (flagForRemove){
                resultFilter.remove(i);
            }

            i--;
        }

        return resultFilter;
    }
}
