package com.test;

import com.test.model.CoronaDisinfection;
import com.test.model.Room;

public class Main {

    public static void main(String[] args) {
        CoronaDisinfection disinfection = new CoronaDisinfection();
        disinfection.start(new Room());
    }

}
