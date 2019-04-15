package okay.mybatisservice.mapper;

import java.util.List;
public interface UserMapper {

    public User selectUser(int id);

    public List<User> selectAllUser() throws Exception;
}
