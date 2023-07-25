package block2.lesson5.repositories;

import block2.lesson5.models.User;

import java.util.List;

public interface UserRepository <T extends User> {
    void create(T user);
    List<T> getAll();
    
    int remove(String fullName);

    List<T> getAllByGroupTitle(String groupTitle);
}
