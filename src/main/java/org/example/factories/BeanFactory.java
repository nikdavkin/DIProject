package org.example.factories;

import org.example.annotations.NotSpringAutowired;
import org.example.context.ApplicationContext;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class BeanFactory {
    private final ApplicationContext applicationContext;

    public BeanFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public <T> T getBean(Class<T> tClass) {
        try {
            T bean = tClass.getDeclaredConstructor().newInstance();
            Field[] fields = tClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(NotSpringAutowired.class)) {
                    field.setAccessible(true);
                    field.set(bean, applicationContext.getBean(field.getType()));
                }
            }
            return bean;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
