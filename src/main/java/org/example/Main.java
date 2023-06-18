package org.example;

import org.example.context.ApplicationContext;
import org.example.factories.BeanFactory;

import java.util.List;

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
        List<Object> beans = applicationContext.getBeans(List.of(C.class, B.class));
        c = (C) beans.get(0);
        b = (B) beans.get(1);
        System.out.println(b);
        System.out.println(a);
        System.out.println(c);
    }
}