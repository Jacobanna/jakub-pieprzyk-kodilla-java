package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;

public class Millenial extends User {
    public Millenial(String name) {
        super(name);
        this.setSocialPublisher(new TwitterPublisher());
    }
}
