/*
 * @author Aliaksei Vazdusevich
 */

package com.di.infrostructure.configurator;

public interface ProxyConfigurator {
    Object replaceWithProxyIfNeeded(Object t, Class implClass);
}
