package okay.Util;

import java.sql.Timestamp;
import java.util.Date;

public class Util {

    public static  String getNowTime(){
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp.toString();
    }

    public static void Sleep(float seconds) {

        int a = Float.valueOf(seconds * 1000).intValue();
        try {
            Thread.sleep(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
