package org.example;

import org.example.factories.BeanFactory;


public class Main {
    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory();
        C c1 = beanFactory.getBean(C.class);
        B b1 = beanFactory.getBean(B.class);
        C c2 = beanFactory.getBean(C.class);
        B b2 = beanFactory.getBean(B.class);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println();
    }
}