package okay.mysqlservice;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MysqlService {

    public static SqlSessionFactory sqlSessionFactory;
    static {
        try{
        String resource = "config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

         } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static SqlSession getSession(){

        return  sqlSessionFactory.openSession();

    }

}
