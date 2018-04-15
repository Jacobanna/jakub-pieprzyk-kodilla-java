package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {
    private int usersCount;
    private int postsCount;
    private int commentsCount;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics){
        usersCount = statistics.userNames().size();
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();
        if(usersCount > 0){
            averagePostsPerUser = (double)postsCount/usersCount;
            averageCommentsPerUser = (double)commentsCount/usersCount;
            averageCommentsPerPost = (double)commentsCount/postsCount;
        } else {
            averagePostsPerUser = 0;
            averageCommentsPerUser = 0;
            averageCommentsPerPost = 0;
        }
    }

    public void showStatistics(){
        String statisticsString = "Number of users: " + usersCount + "\nNumber of posts: " + postsCount + "\nNumber of comments: " + commentsCount + "\nAverage posts per user: "
                +averagePostsPerUser + "\nAverage comments per user: " + averageCommentsPerUser + "\nAverage comments per post: " + averageCommentsPerPost;
        System.out.println(statisticsString);
    }

    public int getUsersCount() {
        return usersCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }
}
