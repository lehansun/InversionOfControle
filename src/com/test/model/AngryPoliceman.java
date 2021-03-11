/*
 * @author Aliaksei Vazdusevich
 */

package com.test.model;

public class AngryPoliceman implements Policeman {
    @Override
    public void makePeopleLeaveTheRoom() {
        System.out.println("Тра-та-та-та-та-та-та! Все вон! Убью!!! ");
        System.out.println();
    }
}
