package org.example;

import org.example.context.ApplicationContext;
import org.example.factories.BeanFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext();
        BeanFactory beanFactory = new BeanFactory(applicationContext);
        applicationContext.setBeanFactory(beanFactory);
        List<Object> beans = applicationContext.getBeans(List.of(C.class, B.class));
        A a = new A();
        C c = (C) beans.get(0);
        B b = (B) beans.get(1);
        System.out.println(b);
        System.out.println(a);
        System.out.println(c);
    }
}