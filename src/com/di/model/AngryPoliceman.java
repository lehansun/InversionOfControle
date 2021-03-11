/*
 * @author Aliaksei Vazdusevich
 */

package com.di.model;

import com.di.infrostructure.annotation.InjectByType;

import javax.annotation.PostConstruct;

public class AngryPoliceman implements Policeman {

    @InjectByType
    private Recommender recommender;

    @Override
    public void makePeopleLeaveTheRoom() {
        System.out.println("Тра-та-та-та-та-та-та! Все вон! Убью!!! ");
        System.out.println();
    }

    @PostConstruct
    public void init() {
        System.out.println(recommender.getClass());
    }
}
