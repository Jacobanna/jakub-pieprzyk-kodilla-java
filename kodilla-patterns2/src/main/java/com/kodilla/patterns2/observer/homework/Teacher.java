package com.kodilla.patterns2.observer.homework;

public class Teacher implements Observer{
    private final String username;
    private int updateCount;

    public Teacher(String name) {
        this.username = name;
    }

    @Override
    public void update(StudentTask studentTask) {
        System.out.println(username + " you've got new notification in: " + studentTask.getName() + "\n" + studentTask.getMessages().get(studentTask.getMessages().size()-1));
        updateCount++;
    }

    public String getName() {
        return username;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
