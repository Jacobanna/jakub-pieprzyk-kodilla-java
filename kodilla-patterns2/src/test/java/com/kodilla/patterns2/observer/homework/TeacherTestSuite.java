package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TeacherTestSuite {
    @Test
    public void testUpdate() {
        //Given
        StudentTask studentTask1 = new StudentTask("Task 1");
        StudentTask studentTask2 = new StudentTask("Task 2");
        StudentTask studentTask3 = new StudentTask("Task 3");
        Teacher teacher1 = new Teacher("Teacher 1");
        Teacher teacher2 = new Teacher("Teacher 2");
        studentTask1.registerObserver(teacher1);
        studentTask2.registerObserver(teacher2);
        studentTask3.registerObserver(teacher2);
        //When
        studentTask1.addTask("Task 1, Notification 1");
        studentTask1.addTask("Task 1, Notification 2");
        studentTask2.addTask("Task 2, Notification 1");
        studentTask2.addTask("Task 2, Notification 2");
        studentTask3.addTask("Task 3, Notification 1");
        studentTask3.addTask("Task 3, Notification 2");
        studentTask3.addTask("Task 3, Notification 3");
        //Then
        assertEquals(2, teacher1.getUpdateCount());
        assertEquals(5, teacher2.getUpdateCount());
    }
}
