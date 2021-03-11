package com.test.infrostructure;

import com.test.infrostructure.configurator.ObjectConfigurator;
import com.test.model.AngryPoliceman;
import com.test.model.Policeman;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectFactory {
    private static ObjectFactory INSTANCE = new ObjectFactory();
    private List<ObjectConfigurator> configurators = new ArrayList<>();
    private Config config;

    @SneakyThrows
    private ObjectFactory() {
        Map<Class, Class> config = new HashMap<>();

        config.put(Policeman.class, AngryPoliceman.class);
        this.config = new ConfigImpl("com.test", config);
        for (Class<? extends ObjectConfigurator> aClass : this.config.getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    public static ObjectFactory getINSTANCE() {
        return INSTANCE;
    }


    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> implClass = type;

        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }

        T t = implClass.getDeclaredConstructor().newInstance();
        configurators.forEach(configurator -> configurator.configure(t));
        // ToDo

        return t;
    }
}
