/*
 * @author Aliaksei Vazdusevich
 */

package com.test.infrostructure.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Singletone {
}
