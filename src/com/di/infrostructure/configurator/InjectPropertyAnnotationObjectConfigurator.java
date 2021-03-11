/*
 * @author Aliaksei Vazdusevich
 */

package com.di.infrostructure.configurator;

import com.di.infrostructure.ApplicationContext;
import com.di.infrostructure.PropertyHandler;
import com.di.infrostructure.annotation.InjectProperty;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class InjectPropertyAnnotationObjectConfigurator implements ObjectConfigurator {

    @Override
    @SneakyThrows
    public void configure(Object t, ApplicationContext context) {
        Class<?> implClass = t.getClass();

        for (Field field : implClass.getDeclaredFields()) {
            InjectProperty annotation = field.getAnnotation(InjectProperty.class);
            if (annotation != null) {
                String value = annotation.value().isEmpty() ? PropertyHandler.getProperty(field.getName()).get() : PropertyHandler.getProperty(annotation.value()).get();
                field.setAccessible(true);
                field.set(t, value);
            }
        }
    }
}
