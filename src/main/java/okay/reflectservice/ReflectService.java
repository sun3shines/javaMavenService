package okay.reflectservice;

import java.lang.reflect.Field;
import okay.beans.Person;

public class ReflectService {

    public void print(Object t) throws  Exception{
        Field[] fs = t.getClass().getDeclaredFields();
        for (int i=0;i<fs.length;i++){
            Field f = fs[i];
            f.setAccessible(true);
            System.out.println(String.format("%s->%s", f.getName(), f.get(t)));


        }
    }
    public void  Handle() throws  Exception{

        Person p = new Person();
        p.setName("张三");
        p.setAge(10);
        print(p);

    }
}
