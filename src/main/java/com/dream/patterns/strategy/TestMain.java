package com.dream.patterns.strategy;/**
 * Created by ning on 2018/4/1.
 */

import javafx.application.Application;
import javafx.stage.Stage;

public class TestMain{

    public static void main(String[] args) {

        Strategy strategyA = new StrategyA();
        Strategy strategyB = new StrategyB();
        Context contextA = new Context(strategyA);
        Context contextB = new Context(strategyB);

       String a = contextA.contextStrategy();
        String b = contextB.contextStrategy();

        System.out.println("StrategyA:"+a);
        System.out.println("StrategyB:"+b);
    }
}
