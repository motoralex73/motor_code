package ru.alishev.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

fun main() {
        var context =  ClassPathXmlApplicationContext("applicationContext.xml");
        var computer : Computer = context.getBean("computer") as Computer
        println(computer)
        context.close()
}
