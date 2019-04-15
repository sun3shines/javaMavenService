package okay.mybatisservice;

import okay.mybatisservice.mapper.User;
import okay.mysqlservice.MysqlService;
import org.apache.ibatis.session.SqlSession;

public class mybatisService {

    public  void handle() throws Exception{


        SqlSession sqlSession = MysqlService.getSession();

        User  user  = sqlSession.selectOne("selectUser", 1);
        System.out.println(user);

    }
}
