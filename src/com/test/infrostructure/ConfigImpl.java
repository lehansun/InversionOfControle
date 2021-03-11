/*
 * @author Aliaksei Vazdusevich
 */

package com.test.infrostructure;

import lombok.Getter;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class ConfigImpl implements Config {

    @Getter
    private final Reflections scanner;
    private final Map<Class, Class> ifc2implClass;

    public ConfigImpl(String packageToScan, Map<Class, Class> ifc2implClass) {
        this.scanner = new Reflections(packageToScan);
        this.ifc2implClass = ifc2implClass;
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> itf) {

        return ifc2implClass.computeIfAbsent(itf, aClass -> {

            Set<Class<? extends T>> classes = scanner.getSubTypesOf(itf);
            if (classes.size() != 1) {
                throw new RuntimeException(itf + " has 0 or more than 1 impl. Please update your config.");
            }
            return classes.iterator().next();
        });

    }
}
