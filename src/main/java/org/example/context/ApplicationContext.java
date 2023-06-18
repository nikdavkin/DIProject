package org.example.context;


import org.example.factories.BeanFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationContext {
    private BeanFactory beanFactory;
    private final Map<Class<?>, Object> cache = new HashMap<>();

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public <T> List<T> getBeans(List<Class<? extends T>> tClass) {
        List<T> newList = new ArrayList<>();
        for (Class<? extends T> clazz : tClass) {
            newList.add(getBean(clazz));
        }
        return newList;
    }

    public <T> T getBean(Class<T> tClass) {
        if (cache.containsKey(tClass)) {
            return (T) cache.get(tClass);
        }
        T bean = beanFactory.getBean(tClass);
        cache.put(tClass, bean);
        return bean;
    }
}
