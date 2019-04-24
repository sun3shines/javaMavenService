package okay.dubboconsumer;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

public class BaseService <T>{

    public  ApplicationConfig getApplication() {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("yyy");
        return application;
    }

    public  RegistryConfig getRegistry() {
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("redis://10.60.0.57:6379");
        registry.setClient("curator");
        return registry;
    }

    public  T getService(Class t) {

        ReferenceConfig<T> reference = new ReferenceConfig<T>();
        reference.setApplication(getApplication());
        reference.setRegistry(getRegistry());
        reference.setInterface(t);
        reference.setVersion("1.0.0");
        T demoService = reference.get();
        return demoService;
    }

}
