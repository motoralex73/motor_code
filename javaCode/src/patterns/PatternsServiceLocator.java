package patterns;

import java.util.ArrayList;
import java.util.List;

//Паттерн Сервис Локатор, используется для управления созданием и доступом к сервисам (объектам).
public class PatternsServiceLocator {

    interface Service {
        String getName();
        void execute();
    }

    static class Service1 implements Service {
        @Override
        public String getName() {
            return null;
        }
        @Override
        public void execute() {
            System.out.println("service 1");
        }
    }

    static class Service2 implements Service {
        @Override
        public String getName() {
            return null;
        }
        @Override
        public void execute() {
            System.out.println("service 2");
        }
    }

    static class InitialContext {
        public Object lookup(String jndiName) {
            if (jndiName.equalsIgnoreCase("SERVICE1"))
                return new Service1();
            else if (jndiName.equalsIgnoreCase("SERVICE2"))
                return new Service2();
            return null;
        }
    }

    static class Cache {
        private List<Service> services = new ArrayList<>();
        public Service getService(String serviceName) {
            for (Service s : services) {
                if (s.getName().equalsIgnoreCase(serviceName)) {
                    System.out.println("Returning cached " + serviceName + " object");
                    return s;
                }
            }
            return null;
        }
        public void addService(Service newService) {
            boolean exists = false;
            for (Service s : services) {
                if (s.getName().equalsIgnoreCase(newService.getName())) {
                    exists = true;
                }
            }
            if (!exists) services.add(newService);
        }
    }

    //сначала инициализирует сервисы, потом работает с Cache
    static class ServiceLocator {
        static Cache cache = new Cache();

        public static Service getService(String jndiName) {
            Service service = cache.getService(jndiName);
            if (service != null) return service;
            InitialContext context = new InitialContext();
            Service service1 = (Service)context.lookup(jndiName);
            cache.addService(service1);
            return service1;
        }
    }

    public static void main(String[] args) {

        Service service = ServiceLocator.getService("Service1");
        service.execute();
        try {
            service = ServiceLocator.getService("Service2");
            service.execute();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

}
