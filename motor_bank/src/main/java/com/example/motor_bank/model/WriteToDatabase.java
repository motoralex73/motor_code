package com.example.motor_bank.model;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class WriteToDatabase {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addRecord(MyTable myTable) {
        entityManager.persist(myTable);
        entityManager.flush();
    }
}
