package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.kodilla.stream.forumuser.Sex.F;
import static com.kodilla.stream.forumuser.Sex.M;

public class Forum {
    private final List<ForumUser> forumUserList = new ArrayList<>();

    public Forum(){
        forumUserList.add(new ForumUser(1,"johnny", M, LocalDate.of(1990,10,20),20));
        forumUserList.add(new ForumUser(2,"michael", M, LocalDate.of(2007,3,15),10));
        forumUserList.add(new ForumUser(3,"travis", M, LocalDate.of(1993,5,23),0));
        forumUserList.add(new ForumUser(4,"vincent", M, LocalDate.of(1984,11,2),1));
        forumUserList.add(new ForumUser(5,"alan", M, LocalDate.of(2003,9,18),7));
        forumUserList.add(new ForumUser(6,"jessica", F, LocalDate.of(2000,5,12),0));
        forumUserList.add(new ForumUser(7,"skyler", F, LocalDate.of(1993,7,24),11));
        forumUserList.add(new ForumUser(8,"anna", F, LocalDate.of(1978,3,3),28));
        forumUserList.add(new ForumUser(9,"annie", F, LocalDate.of(2005,10,4),33));
    }

    public List<ForumUser> getForumUsersList(){
        return forumUserList;
    }
}
