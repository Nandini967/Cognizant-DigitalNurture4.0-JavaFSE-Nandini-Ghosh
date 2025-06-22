public class Test 
{
  public static void main(String args[])
    {
        Logger obj1 = Logger.getobject();
        Logger obj2 = Logger.getobject();
        obj1.display("This is object1");
        obj2.display("This is object2");
        if(obj1 == obj2)
            System.out.println("Both the objects are same");
        else
            System.out.println("The objects are different");
    }
}
    
