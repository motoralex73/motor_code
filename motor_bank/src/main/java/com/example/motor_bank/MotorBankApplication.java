package com.example.motor_bank;

import com.example.motor_bank.model.TranferBalance;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MotorBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(MotorBankApplication.class, args);
    }
//    @Bean
//    CommandLineRunner commandLineRunner(MyTableRepository myTableRepository) {
//        return args -> {
//            TranferBalance tranferBalance = new TranferBalance(1L, 2L, 3L, 123L);
//            myTableRepository.save(tranferBalance);
//        };
//    }

}
