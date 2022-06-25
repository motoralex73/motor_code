package com.example.motor_bank;

import com.example.motor_bank.model.MyTable;
import com.example.motor_bank.model.MyTableRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MotorBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(MotorBankApplication.class, args);
    }

    //бин сохранения в базе данных полей таблицы (сущности MyTable)
    @Bean
    CommandLineRunner commandLineRunner(MyTableRepository myTableRepository) {
        return args -> {
            MyTable rec = new MyTable(1L, 2, 3, 4);
            myTableRepository.save(rec);
        };
    }
}
