package okay.dubboprovider;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;


public class BaseService <T>{
    public  ProtocolConfig getPorotocol() {
        ProtocolConfig protocal = new ProtocolConfig();
        protocal.setName("dubbo");
        protocal.setPort(8796);
        protocal.setThreads(10);
        return protocal;
    }

    public  RegistryConfig getRegistry() {

        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("redis://10.60.0.57:6379");
        registry.setClient("curator");
        return registry;
    }

    public  ApplicationConfig getApplication() {
        ApplicationConfig app = new ApplicationConfig();
        app.setName("AppProvider");
        return app;
    }

    public  ServiceConfig getService(Class<T> t,Class <? extends T>s) throws  Exception{
        ServiceConfig<T> service = new ServiceConfig<>();
        service.setApplication(getApplication());
        service.setRegistry(getRegistry());
        service.setProtocol(getPorotocol());
        service.setVersion("1.0.0");
        service.setInterface(t);
        service.setRef(s.newInstance());
        return service;
    }

}
