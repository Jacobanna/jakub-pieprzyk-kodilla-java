package com.kodilla.patterns.prototype;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class BoardTestSuite {
    @Test
    public void testToString() {
        //Given
        //Creating the TasksList for todos
        TasksList toDoList = new TasksList("To Do Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> toDoList.getTasks().add(new Task("To Do Task number " + n)));

        //Creating the TasksList for inprogress
        TasksList inProgressList = new TasksList("In Progress Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> inProgressList.getTasks().add(new Task("In Progress Task number " + n)));

        //Creating the TasksList for done
        TasksList doneList = new TasksList("Done Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> doneList.getTasks().add(new Task("Done Task number " + n)));

        //Creating the board and assigning the lists
        Board board = new Board("Project number 1");
        board.getLists().add(toDoList);
        board.getLists().add(inProgressList);
        board.getLists().add(doneList);

        //Making a shallow clone of object board
        Board clonedBoard = null;
        try {
            clonedBoard = board.shallowCopy();
            clonedBoard.setName("Project number 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        System.out.println(board);
        System.out.println(clonedBoard);

        //When
        //Then
        Assert.assertEquals(3, board.getLists().size());
        Assert.assertEquals(3, clonedBoard.getLists().size());
    }
}
