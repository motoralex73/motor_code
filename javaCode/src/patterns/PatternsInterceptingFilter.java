package patterns;

import java.util.ArrayList;
import java.util.List;

//Паттерн Интерсепт Фильтр, веб-паттерн, запрос проходит через несколько фильтров
public class PatternsInterceptingFilter {

    interface Filter {
        void execute(String data);
    }

    static class AuthFilter implements Filter {

        @Override
        public void execute(String data) {
            System.out.println("auth filter data = " + data);
        }
    }

    static class IpFilter implements Filter {

        @Override
        public void execute(String data) {
            System.out.println("ip filter data = " + data);
        }
    }

    static class FilterChain {
        List<Filter> filters = new ArrayList<>();
        Target target = new Target();

        void addFilter(Filter filter) {
            filters.add(filter);
        }

        public void filter(String request) {
            for (Filter filter : filters) {
                filter.execute(request);
            }
            target.doJob(request);
        }
    }

    static class Target {
        void doJob(String data) {
            System.out.println("data came in: " + data);
        }
    }

    static class FilterManager {
        FilterChain filterChain = new FilterChain();

        public void setFilter(Filter filter) {
            filterChain.addFilter(filter);
        }
        void filterRequest(String request) {
            filterChain.filter(request);
        }
    }

    public static void main(String[] args) {

        FilterManager filterManager = new FilterManager();
        filterManager.setFilter(new AuthFilter());
        filterManager.setFilter(new IpFilter());
        filterManager.filterRequest("home");
    }

}
