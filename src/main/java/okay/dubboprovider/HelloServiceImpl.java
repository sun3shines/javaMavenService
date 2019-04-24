package okay.dubboprovider;

public class HelloServiceImpl  implements  HelloService{
    @Override
    public String say(String name) {
        return "My name is " + name;
    }
}
