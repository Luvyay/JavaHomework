package block2.lesson5;

import block2.lesson5.controllers.GroupController;
import block2.lesson5.controllers.StudentController;
import block2.lesson5.controllers.TeacherController;
import block2.lesson5.repositories.StudentRepository;
import block2.lesson5.repositories.TeacherRepository;
import block2.lesson5.services.GroupService;
import block2.lesson5.services.StudentService;
import block2.lesson5.services.TeacherService;
import block2.lesson5.views.GroupView;
import block2.lesson5.views.SortType;
import block2.lesson5.views.StudentView;
import block2.lesson5.views.TeacherView;

import java.util.Scanner;

public class UniversityApp {
    private static StudentRepository studentRepository;
    private static StudentService studentService;
    private static StudentController studentController;
    private static TeacherRepository teacherRepository;
    private static TeacherService teacherService;
    private static TeacherController teacherController;

    public void start() {
        StudentView studentView = getStudentView();
        TeacherView teacherView = getTeacherView();
        GroupView groupView = getGroupView();
//        ----------------------------------------------------------------------------------------------------

        // Создание дефолтных студентов и преподавателей
        createDefaultInfo(studentView, teacherView);

//        ----------------------------------------------------------------------------------------------------

        enterCommands(studentView, teacherView, groupView);

    }

    private void enterCommands(StudentView studentView, TeacherView teacherView, GroupView groupView) {
        boolean flagContinue = true;

        while (flagContinue) {
            String command = new Scanner(System.in).nextLine();
            String[] arrayWords = command.split(" ");

            if (command.startsWith("/get-student name")) {
                studentView.sendOnConsole(SortType.NAME);
            } else if (command.startsWith("/get-student id")) {
                studentView.sendOnConsole(SortType.ID);
            } else if (command.startsWith("/get-student")) {
                studentView.sendOnConsole();
            } else if (command.startsWith("/create-student")) {
                studentView.create(arrayWords[1].replace("_", " "), Integer.parseInt(arrayWords[2]),
                        arrayWords[3], arrayWords[4]);
            } else if (command.startsWith("/delete-student")) {
                studentView.removeUser(arrayWords[1].replace("_", " "));
            }

            if (command.startsWith("/get-teacher name")) {
                teacherView.sendOnConsole(SortType.NAME);
            } else if (command.startsWith("/get-teacher id")) {
                teacherView.sendOnConsole(SortType.ID);
            } else if (command.startsWith("/get-teacher")) {
                teacherView.sendOnConsole();
            } else if (command.startsWith("/create-teacher")) {
                teacherView.create(arrayWords[1].replace("_", " "), Integer.parseInt(arrayWords[2]),
                        arrayWords[3], arrayWords[4]);
            } else if (command.startsWith("/delete-teacher")) {
                teacherView.removeUser(arrayWords[1].replace("_", " "));
            }

            if (command.startsWith("/get-group")) {
                groupView.printAllFromGroup(arrayWords[1]);
            }

            if (command.startsWith("/exit") || command.startsWith("exit")) {
                flagContinue = false;
            }
        }
    }

    private void createDefaultInfo(StudentView studentView, TeacherView teacherView) {
        studentView.create("Ivan Morozov", 18, "02", "11Б");
        studentView.create("Petr Vorobev", 19, "03", "10А");
        studentView.create("Sidor Sidorov", 20, "112", "10А");
        studentView.create("Elena Ivanova", 19, "911", "10А");
        studentView.create("Anna Morozova", 17, "01", "11А");

        teacherView.create("Petr Kosarev", 31, "8789", "11Б");
        teacherView.create("Anna Kuznetsova", 44, "68329", "11А");
        teacherView.create("Nikita Smirnov", 29, "5189", "10А");
    }

    private StudentView getStudentView() {
        studentRepository = new StudentRepository();
        studentService = new StudentService(studentRepository);
        studentController = new StudentController(studentService);

        return new StudentView(studentController);
    }

    private TeacherView getTeacherView() {
        teacherRepository = new TeacherRepository();
        teacherService = new TeacherService(teacherRepository);
        teacherController = new TeacherController(teacherService);

        return new TeacherView(teacherController);
    }

    private GroupView getGroupView() {
        GroupService groupService = new GroupService(studentService, teacherService);
        GroupController groupController = new GroupController(groupService);

        return new GroupView(groupController);
    }
}
