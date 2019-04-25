package okay.zkservice;

import org.apache.zookeeper.ZooKeeper;

public class GetService {

    public void Handle() throws Exception {

        ZooKeeper zk = new Connection().getConnection();

        byte[] data = zk.getData(Connection.path, true, null);
        System.out.println(String.format("Get %s", data.toString()));
        while (true) {
        }
    }

    public static void main(String[] args) throws Exception {

        new GetService().Handle();
    }
}
