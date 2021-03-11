/*
 * @author Aliaksei Vazdusevich
 */

package com.di.infrostructure.configurator;

import com.di.infrostructure.ApplicationContext;

public interface ObjectConfigurator {
    void configure(Object t, ApplicationContext context);

}
