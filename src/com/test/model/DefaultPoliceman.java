package com.test.model;

public class DefaultPoliceman implements Policeman {
    @Override
    public void makePeopleLeaveTheRoom() {
        System.out.println("Пиф-пав! Брысь из комнаты!");
        System.out.println();
    }
}
