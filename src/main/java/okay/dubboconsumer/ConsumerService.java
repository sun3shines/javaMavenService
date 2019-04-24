package okay.dubboconsumer;

import okay.dubboprovider.DemoService;
import okay.dubboprovider.HelloService;


public class ConsumerService {

    public static DemoService demoService;
    public static HelloService helloService;


    static {
        demoService = new BaseService<DemoService>().getService(DemoService.class);
        helloService = new BaseService<HelloService>().getService(HelloService.class);
    }

//    public static ApplicationConfig getApplication() {
//        ApplicationConfig application = new ApplicationConfig();
//        application.setName("yyy");
//        return application;
//    }
//
//    public static RegistryConfig getRegistry() {
//        RegistryConfig registry = new RegistryConfig();
//        registry.setAddress("redis://10.60.0.57:6379");
//        registry.setClient("curator");
//        return registry;
//    }
//
//    public static DemoService getDemoService() {
//
//
//        ReferenceConfig<DemoService> reference = new ReferenceConfig<DemoService>();
//        reference.setApplication(getApplication());
//        reference.setRegistry(getRegistry());
//        reference.setInterface(DemoService.class);
//        reference.setVersion("1.0.0");
//
//        DemoService demoService = reference.get();
//        return demoService;
//    }

//    public static HelloService getHelloService() {
//
//
//        ReferenceConfig<HelloService> reference = new ReferenceConfig<HelloService>();
//        reference.setApplication(getApplication());
//        reference.setRegistry(getRegistry());
//        reference.setInterface(HelloService.class);
//        reference.setVersion("1.0.0");
//
//        HelloService helloService = reference.get();
//        return helloService;
//    }

    public static void main(String[] args) {


        for (int i = 0; i < 100; i++) {
            String a = demoService.sayHello("David");
            System.out.println(a);
            String b = helloService.say("David");
            System.out.println(b);
        }

    }
}
