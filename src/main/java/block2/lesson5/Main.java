package block2.lesson5;

public class Main {
    public static void main(String[] args) {

        /*
        Команды:
        /get-student name
        /get-student id
        /get-student
        /create-student Имя_Фамилия Возраст Номер телефона Группа
        /delete-student Имя_Фамилия

        /get-teacher name
        /get-teacher id
        /get-teacher
        /create-teacher Имя_Фамилия Возраст Номер телефона Группа
        /delete-teacher Имя_Фамилия

        /get-group

        /exit или exit
         */

        /*
        Для примеров:
        /get-student
        /get-student name
        /get-student id
        /get-group 11А
        /create-student Ivan_Morozov 18 96969 11A
        /create-teacher Maria_Pavlova 50 6866 10А
        /get-student
        /get-teacher
        /delete-teacher Maria_Pavlova
        /get-teacher
        /exit
         */

        UniversityApp universityApp = new UniversityApp();
        universityApp.start();
    }
}
