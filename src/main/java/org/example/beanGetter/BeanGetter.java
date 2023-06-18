package org.example.beanGetter;

public interface BeanGetter {
    <T> T getBean(Class<T> beanClass);
}
