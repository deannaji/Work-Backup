package com.patterns.myPatternsProj;

import com.patterns.myPatternsProj.observer.GeneralEventPublisher;
import com.patterns.myPatternsProj.observer.GeneralEventSubscriber;
import com.patterns.myPatternsProj.observer.Publisher;
import com.patterns.myPatternsProj.observer.Subscriber;

/**
 * Hello world!
 *
 */
public class ObserverPatternApp 
{
    public static void main( String[] args )
    {
        Publisher pub1 = new GeneralEventPublisher();
        Subscriber sub1 = new GeneralEventSubscriber();
        Subscriber sub2 = new GeneralEventSubscriber();
        Subscriber sub3 = new GeneralEventSubscriber();
        Subscriber sub4 = new GeneralEventSubscriber();
        Subscriber sub5 = new GeneralEventSubscriber();
        
        sub1.subscribe(pub1);
        sub2.subscribe(pub1);
        sub3.subscribe(pub1);
        sub4.subscribe(pub1);
        
        pub1.setEventMessage("This is the first event being published!");
        pub1.publish();
        
        System.out.println(sub1.getMessage());
        System.out.println(sub2.getMessage());
        System.out.println(sub3.getMessage());
        System.out.println(sub4.getMessage());
        System.out.println(sub5.getMessage());
    }
}
