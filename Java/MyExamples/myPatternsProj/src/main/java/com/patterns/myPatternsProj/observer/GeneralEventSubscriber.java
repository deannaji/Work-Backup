package com.patterns.myPatternsProj.observer;


public class GeneralEventSubscriber implements Subscriber
{
    private String message="empty";
    
    
    @Override
    public void update(String msg){
        this.message= msg;
    }
    
    
    @Override
    public void subscribe(Publisher pub){
        pub.addSubscriber(this);
    }
    
    @Override
    public String getMessage(){
        return this.message;
    }

}
