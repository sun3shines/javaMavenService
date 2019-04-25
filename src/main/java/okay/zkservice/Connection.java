package okay.zkservice;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;


public class Connection {

    public static ZooKeeper zk;
    public static String path = "/test";

    public ZooKeeper getConnection(boolean watch) throws Exception {
        if (zk !=null){
            return zk;
        }

        zk = new ZooKeeper("10.60.0.57:2181", 3000, null);
        Watcher w;
        if (watch) {
            w = new WatchService();
            ((WatchService) w).setZk(zk);
        } else {
            w = null;
        }
        zk.register(w);
        return zk;

    }
}
