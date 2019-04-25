package okay.zkservice;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;


public class Connection {

    public static ZooKeeper zk;
    public static String path = "/test";

    public ZooKeeper getConnection(Watcher w) throws Exception {
        if (zk !=null){
            return zk;
        }

        return new ZooKeeper("10.60.0.57:2181", 3000, w);
    }
}
