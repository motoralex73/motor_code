package com.example.motor_bank;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BalanceRepository {
    private final Map<Long, Long> storage = new HashMap<>(Map.of(5L, 10L));



    public Long getBalanceForId(Long accountId) {
        return storage.get(accountId);
    }

    public void save(Long id, Long amount) {
            storage.put(id, amount);

    }
}
