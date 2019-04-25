package okay.zkservice;

import org.apache.zookeeper.ZooKeeper;

public class GetService {

    public void Handle() throws Exception {

        ZooKeeper zk = new Connection().getConnection(null);


        byte[] data = zk.getData(Connection.path, true, null);
        System.out.println(data);
        System.out.println(String.format("Get %s", new String(data)));
        while (true) {
            Thread.sleep(100);
        }
    }

    public static void main(String[] args) throws Exception {

        new GetService().Handle();
    }
}
