package okay.zkservice;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class WatchService implements Watcher {

    public ZooKeeper zk;

    public void setZk(ZooKeeper zk) {
        this.zk = zk;
    }

    public void process(WatchedEvent event) {
        if (event.getPath() == null) { //连接时会触发None的事件
            System.out.println("[初始化连接]" + event.getType());

        } else if (event.getType() == Event.EventType.NodeDeleted) {
            System.out.println("[节点删除]" + event.getPath() + ":" + event.getType());
        } else if (event.getType() == Event.EventType.NodeCreated) {
            System.out.println("[节点创建]" + event.getPath() + ":" + event.getType());
        } else if (event.getType() == Event.EventType.NodeDataChanged) {
            System.out.println("[节点更新]" + event.getPath() + ":" + event.getType());
        } else if (event.getType() == Event.EventType.NodeChildrenChanged) {
            System.out.println("[子节点更新(父增删子节点)]" + event.getPath() + ":" + event.getType());
        }

        System.out.println("OK " + event.getPath());
        zk.register(this);


        try {
            System.out.println("watch ...");
            zk.getData(Connection.path, true, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
