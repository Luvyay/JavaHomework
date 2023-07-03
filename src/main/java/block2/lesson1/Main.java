package block2.lesson1;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        CatsWithHair cats = new CatsWithHair(3, "M", 5, "Murlika", "Vasya", "black");
        DogsWithHair dogs = new DogsWithHair(2, "F", 6, "Rich", "Vasya", "gray");
        Mouse mouse = new Mouse(3, "M", 3, "Loki", "Kolya");

        ArrayList<Animals> animals = new ArrayList<>();

        animals.add(cats);
        animals.add(dogs);
        animals.add(mouse);

        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i));
            System.out.println("Метод eat:");
            animals.get(i).eat(new Random().nextInt(30));
            System.out.println("Метод voice:");
            animals.get(i).voice();
            System.out.println("Метод move:");
            animals.get(i).move();
            System.out.println("Метод sleep:");
            animals.get(i).sleep();
            System.out.println("Метод move:");
            animals.get(i).move();
            System.out.println("Метод wakeUp:");
            animals.get(i).wakeUp();
            System.out.println("-----------------------------------------------");
        }
    }

}
