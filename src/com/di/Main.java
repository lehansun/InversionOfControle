package com.di;

import com.di.infrostructure.Application;
import com.di.infrostructure.ApplicationContext;
import com.di.infrostructure.ObjectFactory;
import com.di.model.AngryPoliceman;
import com.di.model.CoronaDisinfection;
import com.di.model.Policeman;
import com.di.model.Room;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Class, Class> config = new HashMap<>();
        config.put(Policeman.class, AngryPoliceman.class);
        ApplicationContext context = Application.run("com.di", config);
        CoronaDisinfection disinfection = context.getObject(CoronaDisinfection.class);
        disinfection.start(new Room());
    }

}
