/*
 * @author Aliaksei Vazdusevich
 */

package com.di.infrostructure;

import java.util.Map;

public class Application {
    public static ApplicationContext run(String packageToScan, Map<Class, Class> ifcToImplClass) {
        ConfigImpl config = new ConfigImpl(packageToScan, ifcToImplClass);
        ApplicationContext context = new ApplicationContext(config);
        ObjectFactory factory = new ObjectFactory(context);
//        todo Инициировать все синглтоны, которые не ленивые
        context.setFactory(factory);
        return context;
    }
}
