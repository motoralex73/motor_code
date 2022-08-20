package com.example.motor_bank;

import com.example.motor_bank.model.TranferBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyTableRepository extends JpaRepository<TranferBalance,Long> {

}
