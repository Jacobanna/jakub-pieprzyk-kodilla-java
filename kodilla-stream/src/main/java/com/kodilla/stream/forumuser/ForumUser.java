package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int userId;
    private final String username;
    private final Sex sex;
    private final LocalDate birthDate;
    private final int publishedPosts;

    public ForumUser(final int userId, final String username, final Sex sex, final LocalDate birthDate, final int publishedPosts) {
        this.userId = userId;
        this.username = username;
        this.sex = sex;
        this.birthDate = birthDate;
        this.publishedPosts = publishedPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", publishedPosts=" + publishedPosts +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public Sex getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPublishedPosts() {
        return publishedPosts;
    }
}
