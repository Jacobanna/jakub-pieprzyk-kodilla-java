package com.kodilla.testing.forum;

import java.util.ArrayList;
import java.util.LinkedList;

public class ForumUser {
    private String name;
    private String realName;
    private ArrayList<ForumPost> posts = new ArrayList<>();
    private LinkedList<ForumComment> comments = new LinkedList<>();

    public ForumUser(String name, String realName) {
        this.name = name;
        this.realName = realName;
    }

    public void addPost(String author, String postBody){
        ForumPost thePost = new ForumPost(postBody,author);
        posts.add(thePost);
    }

    public void addComment(ForumPost thePost, String commentBody, String author){
        ForumComment theComment = new ForumComment(thePost,commentBody,author);
        comments.add(theComment);
    }

    public int getPostsQuantity(){
        return posts.size();
    }

    public int getCommentsQuantity(){
        return comments.size();
    }

    public ForumPost getPost(int postNumber){
        ForumPost thePost = null;
        if(postNumber >= 0 && postNumber < posts.size()){
            thePost = posts.get(postNumber);
        }
        return thePost;
    }

    public ForumComment getComment(int commentNumber){
        ForumComment theComment = null;
        if(commentNumber >= 0 && commentNumber < comments.size()){
            theComment = comments.get(commentNumber);
        }
        return theComment;
    }

    public boolean removePost(ForumPost thePost){
        if(posts.contains(thePost)){
            posts.remove(thePost);
            return true;
        }
        return false;
    }

    public boolean removeComment(ForumComment theComment){
        if(comments.contains(theComment)){
            comments.remove(theComment);
            return true;
        }
        return false;
    }

    public String getName(){
        return name;
    }

    public String getRealName() {
        return realName;
    }
}
