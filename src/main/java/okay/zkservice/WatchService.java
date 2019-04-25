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

        System.out.println("OK " + event.getPath() + " " + event.getType() + " " + event.getState());


        if (event.getPath() == null) {
            // 首次连接时必须要返回才行；
            // 捕获create事件时，必须要在事件之前进行监听才行；而不是之后；
            // 而事件之前的监听，如果节点不存在；则需要用getData来进行；如果存在，则可以用getData监听；
            // 所以，需要在create节点前增加exists进行监听；

            System.out.println("null and return");
            return;
        }

        if (event.getType() == Event.EventType.NodeDeleted) {
            System.out.println("delete and return");
            return;
        }
        try {
            // 在监听事件中增加监听，是为了下一个事件的发生提前准备好监听事件；
            byte[] data = zk.getData(Connection.path, true, null);

            System.out.println("watch ... " + data.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
