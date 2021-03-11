/*
 * @author Aliaksei Vazdusevich
 */

package com.di.model;

import com.di.infrostructure.annotation.InjectProperty;
import com.di.infrostructure.annotation.Singletone;

@Singletone
public class RecommenderImpl implements Recommender {

    @InjectProperty("bad.recommendation")
    private String recommendation;

    public RecommenderImpl() {
        System.out.println("Recommender was created");
    }

    @Override
    public void recommend() {
        System.out.println("Чтобы быть здоровыми, пейте '" + recommendation + "'");
    }
}
