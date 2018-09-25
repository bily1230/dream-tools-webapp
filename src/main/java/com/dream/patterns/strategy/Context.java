package com.dream.patterns.strategy;

/**
 * Created by ning on 2018/4/1.
 */
public class Context {

    private Strategy strategy;

    public Context( Strategy strategy){
        this.strategy = strategy;
    }
    public String contextStrategy(){
          return  strategy.show();
    }

}
