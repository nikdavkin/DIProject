package org.example.factories;

import org.example.annotations.NotSpringAutowired;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class BeanFactory {
    private final Map<Class<?>, Object> beanCache = new HashMap<>();

    public <T> T getBean(Class<T> beanClass) {
        try {
            T bean = beanClass.getDeclaredConstructor().newInstance();
            Field[] fields = beanClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(NotSpringAutowired.class)) {
                    field.setAccessible(true);
                    if (beanCache.containsKey(field.getType())) {
                        field.set(bean, beanCache.get(field.getType()));
                    } else {
                        T cacheBean = (T) getBean(field.getType());
                        field.set(bean, cacheBean);
                        beanCache.put(field.getType(), cacheBean);
                    }
                }
            }
            return bean;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
