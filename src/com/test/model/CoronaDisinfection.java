package com.test.model;

import com.test.infrostructure.ObjectFactory;

public class CoronaDisinfection {

    private Announcer announcer = ObjectFactory.getINSTANCE().createObject(Announcer.class);
    private Policeman policeman = ObjectFactory.getINSTANCE().createObject(Policeman.class);

    public void start(Room room) {
        announcer.announce("Начинаем дезинфекцию. Всем покинуть помещение!");
        policeman.makePeopleLeaveTheRoom();
        disinfect(room);
        announcer.announce("Можно возвращаться в комнату.");
    }

    private void disinfect(Room room) {
        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("////\tОсуществляем дезинфекцию! Дождитесь очистки комнаты " + room + ".");
        for (int i = 1; i < 4; i++) {
            try {
                Thread.sleep(200);
                System.out.println("////\t\t" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("////\tДезинфекция завершена!");
        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
    }
}
