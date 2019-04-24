package okay.dubboprovider;

public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        System.out.println("...");
        return "Hello " + name;
    }
}
