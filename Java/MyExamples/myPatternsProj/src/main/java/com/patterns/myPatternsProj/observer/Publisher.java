package com.patterns.myPatternsProj.observer;

public interface Publisher
{

    void addSubscriber(GeneralEventSubscriber s);

    void removeSubscriber(Subscriber s);

    void publish();
    
    void setEventMessage(String message);

}
