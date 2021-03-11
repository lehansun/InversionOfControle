/*
 * @author Aliaksei Vazdusevich
 */

package com.di.infrostructure.configurator;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DeprecatedAnnotationProxyConfigurator implements ProxyConfigurator {
    @Override
    public Object replaceWithProxyIfNeeded(Object t, Class implClass) {

        if (implClass.isAnnotationPresent(Deprecated.class)) {

            if (implClass.getInterfaces().length == 0) {
                return Enhancer.create(implClass, (net.sf.cglib.proxy.InvocationHandler) (proxy, method, args) -> getInvocationHandlerLogic(t, method, args));
            }

            return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), (proxy, method, args) -> getInvocationHandlerLogic(t, method, args));
        }

        return t;
    }

    private Object getInvocationHandlerLogic(Object t, Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {
        System.out.println("************** не стоит больше использовать этот метод, он устарел **************");
        return method.invoke(t, args);
    }
}
