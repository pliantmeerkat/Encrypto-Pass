package com.jackbranch.pmanger.services.factory;

import com.jackbranch.pmanger.exception.InvalidServiceException;
import com.jackbranch.pmanger.services.DataService;
import com.jackbranch.pmanger.services.EncryptionService;
import com.jackbranch.pmanger.services.RuntimeService;
import com.jackbranch.pmanger.services.StartupService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ServiceFactoryTest {

    private DataService dataService;
    private EncryptionService encryptionService;
    private StartupService startupService;
    private RuntimeService runtimeService;

    @Before
    public void initialize() {
        dataService = ServiceFactory.getDataService();
        encryptionService = ServiceFactory.getEncryptionService();
        startupService = ServiceFactory.getStartupService();
        runtimeService = ServiceFactory.getRuntimeService();
    }

    @Test
    public void testGetInstanceReturnsNewInstanceOfEachService() {
        assertEquals(ServiceFactory.getService(DataService.class).get(), dataService);
        assertEquals(ServiceFactory.getService(EncryptionService.class).get(), encryptionService);
        assertEquals(ServiceFactory.getService(StartupService.class).get(), startupService);
        assertEquals(ServiceFactory.getService(RuntimeService.class).get(), runtimeService);
    }

    @Test
    public void testGetServiceThrowsWithBadService() {
        try {
            ServiceFactory.getService(String.class);
            fail("Exception should be thrown with invalid service");
        } catch(InvalidServiceException e) {
            assertEquals("Service of java.lang.String is invalid", e.getMessage());
        }
    }
}
