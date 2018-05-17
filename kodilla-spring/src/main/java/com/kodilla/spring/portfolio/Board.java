package com.kodilla.spring.portfolio;

import org.springframework.stereotype.Component;

@Component
public class Board {
    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public TaskList getToDoList() {
        return toDoList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getDoneList() {
        return doneList;
    }

    public void addToToDoList(String string) {
        toDoList.addTask(string);
    }

    public void addToInProgressList(String string) {
        inProgressList.addTask(string);
    }

    public void addToDoneList(String string) {
        doneList.addTask(string);
    }
}
