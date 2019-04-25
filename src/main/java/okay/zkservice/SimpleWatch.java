package okay.zkservice;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class SimpleWatch implements Watcher {

    public ZooKeeper zk;

    public void setZk(ZooKeeper zk) {
        this.zk = zk;
    }

    @Override
    public void process(WatchedEvent event) {

        // 如果要收到消息，必须监听才行；
        System.out.println("Simple Watch " + event.getPath() + " " + event.getType() + " " + event.getState());
        if(event.getPath() ==null){
            return;
        }
        try{
            zk.exists(event.getPath(),true);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
