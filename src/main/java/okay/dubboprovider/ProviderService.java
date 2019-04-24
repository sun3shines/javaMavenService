package okay.dubboprovider;

public class ProviderService {

    public static void main(String[] args) throws Exception {

        new BaseService<DemoService>().getService(DemoService.class, DemoServiceImpl.class).export();
        new BaseService<HelloService>().getService(HelloService.class, HelloServiceImpl.class).export();

        while (true) {
        }
    }


}
