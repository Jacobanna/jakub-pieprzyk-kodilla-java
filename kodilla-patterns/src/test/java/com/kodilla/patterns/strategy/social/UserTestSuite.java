package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.SnapchatPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User millenial = new Millenial("Millenial");
        User yGeneration = new YGeneration("YGeneration");
        User zGeneration = new ZGeneration("ZGeneration");
        //When
        //Then
        Assert.assertEquals("Twitter", millenial.sharePost());
        Assert.assertEquals("Facebook", yGeneration.sharePost());
        Assert.assertEquals("Snapchat", zGeneration.sharePost());
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User millenial = new Millenial("Millenial");
        //When
        millenial.setSocialPublisher(new SnapchatPublisher());
        //Then
        Assert.assertEquals("Snapchat", millenial.sharePost());
    }
}
