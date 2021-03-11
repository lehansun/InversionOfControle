/*
 * @author Aliaksei Vazdusevich
 */

package com.test.model;

import com.test.infrostructure.annotation.InjectProperty;
import com.test.infrostructure.annotation.Singletone;

@Singletone
public class RecommenderImpl implements Recommender {

    @InjectProperty("bad.recommendation")
    private String recommendation;


    @Override
    public void recommend() {
        System.out.println("Чтобы быть здоровыми, пейте '" + recommendation + "'");
    }
}
