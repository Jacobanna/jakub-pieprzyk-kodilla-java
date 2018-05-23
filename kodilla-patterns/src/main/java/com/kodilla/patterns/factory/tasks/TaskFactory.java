package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public static final String DRIVING_TASK = "DRIVING_TASK";
    public static final String PAINTING_TASK = "PAINTING_TASK";
    public static final String SHOPPING_TASK = "SHOPPING_TASK";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case DRIVING_TASK:
                return new DrivingTask("Driving Task", "Barcelona","Bike");
            case PAINTING_TASK:
                return new PaintingTask("House", "Blue","Walls");
            case SHOPPING_TASK:
                return new ShoppingTask("Grocery","Onion",66);
            default:
                return null;
        }
    }
}
