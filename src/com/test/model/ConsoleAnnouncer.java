package com.test.model;

import com.test.infrostructure.ObjectFactory;

public class ConsoleAnnouncer implements Announcer {
    private Recommender recommender = ObjectFactory.getINSTANCE().createObject(Recommender.class);

    @Override
    public void announce(String message) {
        System.out.println();
        System.out.println(message);
        recommender.recommend();
        System.out.println();
    }
}
