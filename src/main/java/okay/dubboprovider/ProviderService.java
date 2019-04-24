package okay.dubboprovider;

public class ProviderService {

//    public static ProtocolConfig getPorotocol() {
//        ProtocolConfig protocal = new ProtocolConfig();
//        protocal.setName("dubbo");
//        protocal.setPort(8796);
//        protocal.setThreads(10);
//        return protocal;
//    }
//
//    public static RegistryConfig getRegistry() {
//
//        RegistryConfig registry = new RegistryConfig();
//        registry.setAddress("redis://10.60.0.57:6379");
//        registry.setClient("curator");
//        return registry;
//    }
//
//    public static ApplicationConfig getApplication() {
//        ApplicationConfig app = new ApplicationConfig();
//        app.setName("AppProvider");
//        return app;
//    }
//
//    public static ServiceConfig getService() {
//        ServiceConfig<DemoService> service = new ServiceConfig<>();
//        service.setApplication(getApplication());
//        service.setRegistry(getRegistry());
//        service.setProtocol(getPorotocol());
//        service.setVersion("1.0.0");
//        return service;
//    }

    public static void main(String[] args) throws Exception {


        // ServiceConfig service = new BaseService<DemoService>().getService(DemoService.class, DemoServiceImpl.class);
//        service.setInterface(DemoService.class);
//        service.setRef(new DemoServiceImpl());
        // service.export();
        new BaseService<DemoService>().getService(DemoService.class, DemoServiceImpl.class).export();
        new BaseService<HelloService>().getService(HelloService.class, HelloServiceImpl.class).export();

        while (true) {
        }
    }


}
