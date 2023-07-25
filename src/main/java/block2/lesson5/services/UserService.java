package block2.lesson5.services;

import block2.lesson5.models.User;

import java.util.List;

public interface UserService <T extends User> {
    void create(String fullName, Integer age, String phoneNumber, String groupTitle);
    List<T> getAll();
    List<T> getAllSortByFullName();
    List<T> getAllSortById();

    int remove(String fullName);

    List<T> getAllByTitle(String groupTitle);
}
