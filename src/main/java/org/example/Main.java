package org.example;

import org.example.context.ApplicationContext;
import org.example.factories.BeanFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        A a = new A();
        C c = new C();
        B b = new B();
        System.out.println(b);
        System.out.println(a);
        System.out.println(c);
        ApplicationContext applicationContext = new ApplicationContext();
        BeanFactory beanFactory = new BeanFactory(applicationContext);
        applicationContext.setBeanFactory(beanFactory);
        applicationContext.getBeans(List.of(C.class, B.class));
        System.out.println(b);
        System.out.println(a);
        System.out.println(c);
    }
}