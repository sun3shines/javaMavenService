package okay.dubboprovider;

public class HelloServiceImpl  implements  HelloService{
    @Override
    public String say(String name) {
        System.out.println("===");
        return "My name is " + name;
    }
}
