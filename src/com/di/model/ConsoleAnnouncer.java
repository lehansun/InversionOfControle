package com.di.model;

import com.di.infrostructure.annotation.InjectByType;

public class ConsoleAnnouncer implements Announcer {

    @InjectByType
    private Recommender recommender;

    @Override
    public void announce(String message) {
        System.out.println();
        System.out.println(message);
        recommender.recommend();
        System.out.println();
    }
}
