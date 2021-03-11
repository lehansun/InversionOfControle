package com.test.infrostructure;

import org.reflections.Reflections;

public interface Config {

    <T> Class<? extends T> getImplClass(Class<T> itf);

    Reflections getScanner();
}
