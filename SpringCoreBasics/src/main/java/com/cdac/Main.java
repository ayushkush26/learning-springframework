package com.cdac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx =
            new ClassPathXmlApplicationContext("applicationContext.xml");

        Student s = (Student) ctx.getBean("student");
        s.display();
    }
}
