package block2.lesson3;

public class Main {
    public static void main(String[] args) {
        Container container1 = new Container();

        container1.addBox(new Box(10));
        container1.addBox(new Box(11));

        Container container2 = new Container();

        container2.addBox(new Box(5));
        container2.addBox(new Box(4));
        container2.addBox(new Box(3));

        System.out.println("Сравнивание контейнеров по весу:");

        if (container1.compareTo(container2) > 0) {
            System.out.println("Контейнер 1 весит больше контейнера 2.");
        } else if (container1.compareTo(container2) < 0) {
            System.out.println("Контейнер 1 весит меньше контейнера 2.");
        } else {
            System.out.println("Контейнеры равны по весу.");
        }

        System.out.println("\nСравнивание контейнеров по числу ящиков:");
        ContainerCountComparator containerCountComparator = new ContainerCountComparator();
        if (containerCountComparator.compare(container1, container2) > 0) {
            System.out.println("Количество ящиков у 1 контейнера больше чем у 2.");
        } else if (containerCountComparator.compare(container1, container2) < 0) {
            System.out.println("Количество ящиков у 1 контейнера меньше чем у 2.");
        } else {
            System.out.println("Количество ящиков одинаковое.");
        }

        System.out.println("\nПеребор ящиков в контейнере:");
        for (Box box: container1) {
            System.out.print(box + " ");
        }

        System.out.println();

        for (Box box: container2) {
            System.out.print(box + " ");
        }
    }
}
