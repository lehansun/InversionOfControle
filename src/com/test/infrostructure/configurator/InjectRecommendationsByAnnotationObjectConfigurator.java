/*
 * @author Aliaksei Vazdusevich
 */

package com.test.infrostructure.configurator;

import com.test.infrostructure.PropertyHandler;
import com.test.infrostructure.annotation.InjectProperty;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class InjectRecommendationsByAnnotationObjectConfigurator implements ObjectConfigurator {

    @Override
    @SneakyThrows
    public void configure(Object t) {
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
