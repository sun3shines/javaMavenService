package okay.Util;

import java.sql.Timestamp;
import java.util.Date;

public class Util {

    public static  String getNowTime(){
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp.toString();
    }

}
