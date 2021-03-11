/*
 * @author Aliaksei Vazdusevich
 */

package com.di.infrostructure.configurator;

import com.di.infrostructure.ApplicationContext;
import com.di.infrostructure.ObjectFactory;
import com.di.infrostructure.annotation.InjectByType;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object t, ApplicationContext context) {
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                field.setAccessible(true);
                Object object = context.getObject(field.getType());
                field.set(t, object);
            }
        }
    }
}
