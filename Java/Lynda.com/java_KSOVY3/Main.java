import java.lang.reflect.Constructor;
public class Main{
  public static void main(String[] args){
     Olive o1= new Olive();
    //Reflection API:
     Class<?> c1 = o1.getClass();
     System.out.println(c1);
     System.out.println(c1.getName());
     System.out.println(c1.getSimpleName());
    
    Constructor<?>[] cons = c1.getConstructors();
    System.out.println("Number of constructors: "+cons.length);
    OlivesJar jar = new OlivesJar();
    jar.openJar();
  }
}