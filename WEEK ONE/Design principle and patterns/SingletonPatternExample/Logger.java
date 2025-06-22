public class Logger
{
    private static Logger object;
    private Logger(){}
    public static Logger getobject()
    {
        if(object == null)
            object = new Logger();
            
        return object;
    }

    public void display(String str)
    {
        System.out.println(str);
    }
   
}