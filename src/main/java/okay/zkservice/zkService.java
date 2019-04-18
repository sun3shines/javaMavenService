package okay.zkservice;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class zkService {

    static ZooKeeper zk = null;
    String path = "/javaserviceb1";

    public zkService() throws Exception {
        zk = new ZooKeeper("10.60.0.57:2181", 3000, null);
    }


    public void write() throws Exception {

        // 临时节点，其他的连接无法访问；

        if (null == zk.exists(path, null)) {
            String r = zk.create(path, "abc".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(r);
        } else {
            System.out.println("Node Exists");
        }


    }

    public void delete() throws Exception {
        zk.delete(path, -1);
    }

    public void read() throws Exception {


        String s = new String(zk.getData(path, null, null));
        System.out.println(s);
    }

    public void Handle() throws Exception {
        write();
        read();
        delete();
    }
}
