package okay;

import okay.reflectservice.ReflectService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws  Exception
    {

        // System.out.println( "Hello World!" );
//        mybatisService s = new mybatisService();
//        s.handle();

        // SyncPrimitive.handle(args);
//        zkService z = new zkService();
//        z.Handle();

        ReflectService s = new ReflectService();
        s.Handle();

    }
}
