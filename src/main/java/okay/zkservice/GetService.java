package okay.zkservice;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class GetService {

    public void Handle() throws Exception {

        // 首次连接后，必须重新连接才能收到后面的消息处理；

        Watcher w = new SimpleWatch();
        ZooKeeper zk = new Connection().getConnection(w);
        System.out.println("1");
        ((SimpleWatch) w).setZk(zk);
        System.out.println("2");

        zk.exists(Connection.path, true);
        while (true) {
            Thread.sleep(100);
        }
    }

    public static void main(String[] args) throws Exception {

        new GetService().Handle();
    }
}
