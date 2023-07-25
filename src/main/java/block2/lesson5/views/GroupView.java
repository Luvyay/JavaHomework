package block2.lesson5.views;

import block2.lesson5.controllers.GroupController;

public class GroupView {
    private final GroupController controller;

    public GroupView(GroupController groupController) {
        this.controller = groupController;
    }

    public void printAllFromGroup(String groupTitle) {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("СТУДЕНТЫ И ПРЕПОДАВАТЕЛИ ГРУППЫ " + groupTitle);
        controller.getAllUsersFromGroup(groupTitle).forEach(System.out::println);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
