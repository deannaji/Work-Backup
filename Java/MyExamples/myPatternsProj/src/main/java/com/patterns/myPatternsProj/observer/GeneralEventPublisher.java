package com.patterns.myPatternsProj.observer;

import java.util.ArrayList;
import java.util.List;

public class GeneralEventPublisher implements Publisher
{
    private List<GeneralEventSubscriber> subscribers;
    private String eventMessage="";
    
    public GeneralEventPublisher(){
        this.subscribers = new ArrayList<>();
    }
    
    
    @Override
    public void addSubscriber(GeneralEventSubscriber s){
        this.subscribers.add(s);
    }
    
    
    @Override
    public void removeSubscriber(Subscriber s){
        this.subscribers.remove(s);
    }
    
    
    @Override
    public void publish(){
        for(Subscriber subscriber : this.subscribers){
            subscriber.update(eventMessage);
        }
    }
    
    @Override
    public void setEventMessage(String message){
        this.eventMessage = message;
    }
}
