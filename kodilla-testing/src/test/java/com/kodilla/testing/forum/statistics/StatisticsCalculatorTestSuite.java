package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsCalculatorTestSuite {
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
    public void testCalculateAdvStatistics() {
        //FIRST SET OF DATA
        //Given
        StatisticsCalculator statisticsCalculator1 = new StatisticsCalculator();
        Statistics statisticsMock1 = mock(Statistics.class);
        List<String> dummyUserName1 = new ArrayList<>();
        int dummyPostsCount1 = 0;
        int dummyCommentsCount1 = 0;
        when(statisticsMock1.userNames()).thenReturn(dummyUserName1);
        when(statisticsMock1.postsCount()).thenReturn(dummyPostsCount1);
        when(statisticsMock1.commentsCount()).thenReturn(dummyCommentsCount1);
        //When
        statisticsCalculator1.calculateAdvStatistics(statisticsMock1);
        //Then
        Assert.assertEquals(0,statisticsCalculator1.getUsersCount());
        Assert.assertEquals(0,statisticsCalculator1.getPostsCount());
        Assert.assertEquals(0,statisticsCalculator1.getCommentsCount());
        Assert.assertEquals(0,statisticsCalculator1.getAveragePostsPerUser(),0.1);
        Assert.assertEquals(0,statisticsCalculator1.getAverageCommentsPerUser(),0.1);
        Assert.assertEquals(0,statisticsCalculator1.getAverageCommentsPerPost(),0.1);

        //SECOND SET OF DATA
        //Given
        StatisticsCalculator statisticsCalculator2 = new StatisticsCalculator();
        Statistics statisticsMock2 = mock(Statistics.class);
        List<String> dummyUserName2= new ArrayList<>();
        for(int i=0; i<100; i++){
            dummyUserName2.add("String #" + i);
        }
        int dummyPostsCount2 = 1000;
        int dummyCommentsCount2 = 500;
        when(statisticsMock2.userNames()).thenReturn(dummyUserName2);
        when(statisticsMock2.postsCount()).thenReturn(dummyPostsCount2);
        when(statisticsMock2.commentsCount()).thenReturn(dummyCommentsCount2);
        //When
        statisticsCalculator2.calculateAdvStatistics(statisticsMock2);
        //Then
        Assert.assertEquals(100,statisticsCalculator2.getUsersCount());
        Assert.assertEquals(1000,statisticsCalculator2.getPostsCount());
        Assert.assertEquals(500,statisticsCalculator2.getCommentsCount());
        Assert.assertEquals(10,statisticsCalculator2.getAveragePostsPerUser(),0.1);
        Assert.assertEquals(5,statisticsCalculator2.getAverageCommentsPerUser(),0.1);
        Assert.assertEquals(0.5,statisticsCalculator2.getAverageCommentsPerPost(),0.1);

        //THIRD SET OF DATA
        //Given
        StatisticsCalculator statisticsCalculator3 = new StatisticsCalculator();
        Statistics statisticsMock3 = mock(Statistics.class);
        List<String> dummyUserName3 = new ArrayList<>();
        for(int i=0; i<100; i++){
            dummyUserName3.add("String #" + i);
        }
        int dummyPostsCount3 = 1000;
        int dummyCommentsCount3 = 2000;
        when(statisticsMock3.userNames()).thenReturn(dummyUserName3);
        when(statisticsMock3.postsCount()).thenReturn(dummyPostsCount3);
        when(statisticsMock3.commentsCount()).thenReturn(dummyCommentsCount3);
        //When
        statisticsCalculator3.calculateAdvStatistics(statisticsMock3);
        //Then
        Assert.assertEquals(100,statisticsCalculator3.getUsersCount());
        Assert.assertEquals(1000,statisticsCalculator3.getPostsCount());
        Assert.assertEquals(2000,statisticsCalculator3.getCommentsCount());
        Assert.assertEquals(10,statisticsCalculator3.getAveragePostsPerUser(),0.1);
        Assert.assertEquals(20,statisticsCalculator3.getAverageCommentsPerUser(),0.1);
        Assert.assertEquals(2,statisticsCalculator3.getAverageCommentsPerPost(),0.1);

        //FOURTH SET OF DATA
        //Given
        StatisticsCalculator statisticsCalculator4 = new StatisticsCalculator();
        Statistics statisticsMock4 = mock(Statistics.class);
        List<String> dummyUserName4 = new ArrayList<>();
        for(int i=0; i<100; i++){
            dummyUserName4.add("String #" + i);
        }
        int dummyPostsCount4 = 1000;
        int dummyCommentsCount4 = 0;
        when(statisticsMock4.userNames()).thenReturn(dummyUserName4);
        when(statisticsMock4.postsCount()).thenReturn(dummyPostsCount4);
        when(statisticsMock4.commentsCount()).thenReturn(dummyCommentsCount4);
        //When
        statisticsCalculator4.calculateAdvStatistics(statisticsMock4);
        //Then
        Assert.assertEquals(100,statisticsCalculator4.getUsersCount());
        Assert.assertEquals(1000,statisticsCalculator4.getPostsCount());
        Assert.assertEquals(0,statisticsCalculator4.getCommentsCount());
        Assert.assertEquals(10,statisticsCalculator4.getAveragePostsPerUser(),0.1);
        Assert.assertEquals(0,statisticsCalculator4.getAverageCommentsPerUser(),0.1);
        Assert.assertEquals(0,statisticsCalculator4.getAverageCommentsPerPost(),0.1);

        //FIFTH SET OF DATA
        //Given
        StatisticsCalculator statisticsCalculator5 = new StatisticsCalculator();
        Statistics statisticsMock5 = mock(Statistics.class);
        List<String> dummyUserName5 = new ArrayList<>();
        dummyUserName5.add("String 1");
        int dummyPostsCount5 = 0;
        int dummyCommentsCount5 = 0;
        when(statisticsMock5.userNames()).thenReturn(dummyUserName5);
        when(statisticsMock5.postsCount()).thenReturn(dummyPostsCount5);
        when(statisticsMock5.commentsCount()).thenReturn(dummyCommentsCount5);
        //When
        statisticsCalculator5.calculateAdvStatistics(statisticsMock5);
        //Then
        Assert.assertEquals(1,statisticsCalculator5.getUsersCount());
        Assert.assertEquals(0,statisticsCalculator5.getPostsCount());
        Assert.assertEquals(0,statisticsCalculator5.getCommentsCount());
        Assert.assertEquals(0,statisticsCalculator5.getAveragePostsPerUser(),0.1);
        Assert.assertEquals(0,statisticsCalculator5.getAverageCommentsPerUser(),0.1);
        Assert.assertEquals(0,statisticsCalculator5.getAverageCommentsPerPost(),0.1);
    }
}
