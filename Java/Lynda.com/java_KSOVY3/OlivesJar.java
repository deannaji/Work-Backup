import java.lang.reflect.Constructor;
public class OlivesJar{
  public void openJar(){
    //local inner class:
    /*class JarLid{
      public void open(){System.out.println("Twist, twist, ...Pop!");}
    }
    new JarLid().open();*/
    
    
    //annonymous inner class:
    new Object(){
       public void open(){
          System.out.println("Twist, twist, ...Pop!");
       }
    }.open();
  }
}


