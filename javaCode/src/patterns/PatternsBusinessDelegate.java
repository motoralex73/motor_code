package patterns;

//Паттерн Бизнес Делегат, есть клиент и есть бизнес сервисы, обмен данными происходят через промежуточное звено
// сервис кешируются
public class PatternsBusinessDelegate {

    interface BusinessService {
        void doJob();
    }

    static class EJBService implements BusinessService {
        @Override
        public void doJob() {
            System.out.println("do ejb service");
        }
    }
    static class JMBService implements BusinessService {

        @Override
        public void doJob() {
            System.out.println("do jmb service");
        }
    }
    //промежуточый сервис по обмену данными между другими сервисами
    static class LookupService {
        BusinessService getService(String serviceType) {
            if (serviceType.equals("ejb")) {
                return new EJBService();
            }
            else  {
                return new JMBService();
            }
        }
    }

    static class BusinessDelegate {
        LookupService lookupService = new LookupService();
        BusinessService businessService;
        void doTask(String serviceType) {
            businessService = lookupService.getService(serviceType);
            businessService.doJob();
        }
    }

    public static void main(String[] args) {
            BusinessDelegate businessDelegate = new BusinessDelegate();
            businessDelegate.doTask("ejb");
            businessDelegate.doTask("jmb");
    }
}
