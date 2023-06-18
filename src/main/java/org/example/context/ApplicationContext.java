package org.example.context;


import org.example.beanGetter.BeanGetter;
import org.example.factories.BeanFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationContext implements BeanGetter {
    private BeanFactory beanFactory;
    private final Map<Class<?>, Object> beanCache = new HashMap<>();

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public <T> List<T> getBeans(List<Class<? extends T>> beanClass) {
        List<T> beans = new ArrayList<>();
        for (Class<? extends T> clazz : beanClass) {
            beans.add(getBean(clazz));
        }
        return beans;
    }

    @Override
    public <T> T getBean(Class<T> beanClass) {
        if (beanCache.containsKey(beanClass)) {
            return (T) beanCache.get(beanClass);
        }
        T bean = beanFactory.getBean(beanClass);
        beanCache.put(beanClass, bean);
        return bean;
    }
}
