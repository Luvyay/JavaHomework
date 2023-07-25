package block2.lesson5.services;

import block2.lesson5.models.User;

import java.util.ArrayList;
import java.util.List;

public class GroupService {
    private final StudentService studentService;
    private final TeacherService teacherService;

    public GroupService(StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    public List<User> getAllUsersFromGroup(String groupTitle) {
        List<User> teacherFromGroup = new ArrayList<>(teacherService.getAllByTitle(groupTitle));
        List<User> studentsFromGroup = new ArrayList<>(studentService.getAllByTitle(groupTitle));
        List<User> users = new ArrayList<>();
        users.addAll(teacherFromGroup);
        users.addAll(studentsFromGroup);

        return users;
    }
}
