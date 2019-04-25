package okay.zkservice;

import okay.Util.Util;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class SetService {

    public void Handle() throws  Exception{

        String data = Util.getNowTime();

        ZooKeeper zk = new Connection().getConnection();
        if(null == zk.exists(Connection.path, null)){
            String r = zk.create(Connection.path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(String.format("Create %s", r));
        }

        for (int i = 0; i < 10; i++) {
            data = Util.getNowTime();
            Stat st = zk.setData(Connection.path, data.getBytes(), -1);
            zk.exists(Connection.path, true);
            System.out.println(String.format("Set %s %s", st.getVersion(), st.getCzxid()));

        }


    }
    public static  void main(String[] args) throws  Exception{
        SetService s = new SetService();
        s.Handle();
    }
}
