package okay.zkservice;

import okay.Util.Util;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class SetService {

    public void Handle() throws  Exception{

        String data = Util.getNowTime();

        ZooKeeper zk = new Connection().getConnection();
        if(null == zk.exists(Connection.path, null)){
            zk.create(Connection.path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }else {
            zk.setData(Connection.path,data.getBytes(),-1);
        }

    }
    public static  void main(String[] args) throws  Exception{
        SetService s = new SetService();
        s.Handle();
    }
}
