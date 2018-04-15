package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests(){
        System.out.println("This is beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests(){
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(2.2);
        //When
        shapeCollector.addFigure(square);
        //Then
        Assert.assertEquals(square,shapeCollector.getFigure(0));
    }

    @Test
    public void testRemoveFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(2.2);
        shapeCollector.addFigure(square);
        //When
        boolean result = shapeCollector.removeFigure(0);
        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void testRemoveFigureWhenEmpty(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(2.2);
        //When
        boolean result = shapeCollector.removeFigure(0);
        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testGetFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(2.2);
        shapeCollector.addFigure(square);
        //When
        Shape squareFromShapeCollector = shapeCollector.getFigure(0);
        //Then
        Assert.assertEquals(square,squareFromShapeCollector);
    }

    @Test
    public void testShowFigures(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(2.2);
        Shape circle = new Circle(2.2);
        Shape triangle = new Triangle(2.2,2.2);
        shapeCollector.addFigure(square);
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(triangle);
        //When
        String expectedResult = "Square\nCircle\nTriangle\n";
        String result = shapeCollector.showFigures();
        //Then
        Assert.assertEquals(expectedResult,result);
    }
}
