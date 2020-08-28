package com.jackbranch.pmanger.services.factory;

import com.jackbranch.pmanger.exception.InvalidServiceException;
import com.jackbranch.pmanger.services.*;
import com.jackbranch.pmanger.util.FileProcessor;

import static java.lang.String.format;

public final class ServiceFactory {

    private static DataService dataService = new DataServiceImpl();
    private static EncryptionService encryptionService =  new EncryptionServiceImpl(FileProcessor.create());
    private static StartupService startupService =  new StartupServiceImpl();
    private static RuntimeService runtimeService = new RuntimeServiceImpl();

    static DataService getDataService() {
        return dataService != null ? dataService :  new DataServiceImpl();
    }

    static EncryptionService getEncryptionService() {
        return encryptionService != null ? encryptionService : new EncryptionServiceImpl(FileProcessor.create());
    }

    static StartupService getStartupService() {
        return startupService != null ? startupService : new StartupServiceImpl();
    }

    static RuntimeService getRuntimeService() {
        return runtimeService != null ? runtimeService : new RuntimeServiceImpl();
    }

    public static ServiceInstance getService(Class<?> clazz) {
        if(clazz.isInstance(dataService)) {
            return new ServiceInstance<>(getDataService());
        }
        if(clazz.isInstance(encryptionService)) {
            return new ServiceInstance<>(getEncryptionService());
        }
        if(clazz.isInstance(startupService)) {
            return new ServiceInstance<>(getStartupService());
        }
        if(clazz.isInstance(runtimeService)) {
            return new ServiceInstance<>(getRuntimeService());
        }
        throw new InvalidServiceException(format("Service of %s is invalid", clazz.getName()));
    }
}
