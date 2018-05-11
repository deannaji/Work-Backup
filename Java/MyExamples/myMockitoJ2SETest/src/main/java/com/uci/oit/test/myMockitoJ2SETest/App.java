package com.uci.oit.test.myMockitoJ2SETest;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {	
       Messenger messenger = new Messenger(new TemplateEngine(), new MailServer("localhost"));
       messenger.sendMessage(new Client("testClient", "domain1@.com"), new Template("Hi, there! This is a test message."));
    }
}
