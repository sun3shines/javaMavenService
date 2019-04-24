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

    public static void main(String[] args) {


        for (int i = 0; i < 100; i++) {
            String a = demoService.sayHello("David");
            System.out.println(a);
            String b = helloService.say("David");
            System.out.println(b);
        }

    }
}
