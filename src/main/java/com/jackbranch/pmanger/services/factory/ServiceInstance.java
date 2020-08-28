package com.jackbranch.pmanger.services.factory;

public class ServiceInstance<T> {

    private T instance;

    ServiceInstance(T instance) {
        this.instance = instance;
    }

    public T get() {
        return this.instance;
    }
}
