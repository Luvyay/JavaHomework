package block2.lesson5.views;

import block2.lesson5.controllers.UserController;
import block2.lesson5.models.Student;

import java.util.List;

public class StudentView implements UserView{

    private final UserController<Student> controller;

    public StudentView(UserController<Student> controller) {
        this.controller = controller;
    }

    @Override
    public void sendOnConsole(SortType sortType) {
        List<Student> students = switch (sortType) {
          case NONE -> controller.getAll();
          case NAME -> controller.getAllSortByFullName();
          case ID -> controller.getAllSortById();
        };

        if (students == null || students.size() == 0) {
            System.out.println("Отсутствуют студенты для вывода.");
            return;
        }

        System.out.println("===========================================");
        System.out.println("Для вывода использована " + sortType);
//        for (Student student: students) {
//            System.out.println(student);
//        }
//        students.forEach((student) -> System.out.println(student));
        students.forEach(System.out::println);
        System.out.println("===========================================");
    }

    @Override
    public void sendOnConsole() {
        sendOnConsole(SortType.NONE);
    }

    @Override
    public void create(String fullName, Integer age, String phoneNumber, String groupTitle) {
        controller.create(fullName, age, phoneNumber, groupTitle);
    }

    @Override
    public void removeUser(String fullName) {
        int removeCount = controller.remove(fullName);

        if (removeCount == 0) {
            System.out.println("Удаление не получилось.");
        } else {
            System.out.println("Удалено студентов: " + removeCount);
        }
    }
}
