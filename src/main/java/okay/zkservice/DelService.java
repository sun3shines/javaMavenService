package okay.zkservice;

import org.apache.zookeeper.ZooKeeper;

public class DelService {

    public static  void main(String[] args) throws  Exception{

        ZooKeeper zk = new Connection().getConnection(false);
        zk.delete(Connection.path,-1);
    }
}
