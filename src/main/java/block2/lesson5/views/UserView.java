package block2.lesson5.views;


public interface UserView {
    void sendOnConsole(SortType sortType);
    void sendOnConsole();
    void create(String fullName, Integer age, String phoneNumber, String groupTitle);

    void removeUser(String fullName);
}
