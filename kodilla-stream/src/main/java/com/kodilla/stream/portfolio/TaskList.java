package com.kodilla.stream.portfolio;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public final class TaskList {
    private final List<Task> taskList = new LinkedList<>();
    private final String name;

    public TaskList(final String name) {
        this.name = name;
    }

    public void addTask(Task task){
        taskList.add(task);
    }

    public boolean removeTask(Task task){
        return taskList.remove(task);
    }

    public List<Task> getTaskList() {
        return new LinkedList<>(taskList);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "taskList=" + taskList +
                ", name='" + name + '\'' +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskList taskList = (TaskList) o;
        return Objects.equals(getName(), taskList.getName());
    }
}
