package com.patterns.myPatternsProj.observer;

public interface Subscriber
{

    void update(String msg);

    void subscribe(Publisher pub);

    String getMessage();
}
