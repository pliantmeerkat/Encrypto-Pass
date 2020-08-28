package com.jackbranch.pmanger.services;

import com.jackbranch.pmanger.domain.PasswordKey;
import com.jackbranch.pmanger.util.FileProcessor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.crypto.keygen.KeyGenerators;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EncryptionServiceTest {

    private FileProcessor fileProcessor = mock(FileProcessor.class);

    private EncryptionServiceImpl encryptionService;

    PasswordKey passwordKey;

    @Before
    public void initialize() {
        passwordKey = new PasswordKey(KeyGenerators.string().generateKey(), "testPassword");
        when(fileProcessor.fileExists(any())).thenReturn(true);
        when(fileProcessor.read()).thenReturn(passwordKey);
        encryptionService = new EncryptionServiceImpl(fileProcessor);
    }

    @Test
    public void testEncryptEncryptsStringCorrectly() {
        final String input = "testInputString";
        assertNotEquals(encryptionService.encrypt(input), input);

    }

    @Test
    public void testDecryptDecryptsStringCorrectly() {
        final String input = "testInputString";
        String encrypted = encryptionService.encrypt(input);
        assertEquals(input, encryptionService.decrypt(encrypted));
    }

    @Test
    public void testGetOrCreateKeyReturnsExpectedAndSetsIfFileFound() {
        assertEquals(passwordKey, encryptionService.getOrCreateKey());
    }

    @Test
    public void testGetOrCreateKeyReturnsExpectedAndWritesIfFileFoundAndExpired() {
        passwordKey.setUpdated(Instant.now().minus(Period.ofDays(2)));

        assertNotEquals(passwordKey, encryptionService.getOrCreateKey());
    }

    @Test
    public void testGetOrCreateKeyReturnsExpectedAndWritesIfNoFileFound() {
        when(fileProcessor.fileExists(any())).thenReturn(false);
    }

    @Test
    public void testKeyHasExpiredReturnsTrueIfExpired() {
        passwordKey.setUpdated(Instant.now().minus(Period.ofDays(2)));
        assertTrue(encryptionService.keyHasExpired(passwordKey));
    }

    @Test
    public void testKeyHasExpiredReturnsFalseIfNotExpired() {
        passwordKey.setUpdated(Instant.now().minus(Duration.ofHours(6)));
        assertFalse(encryptionService.keyHasExpired(passwordKey));
    }
}
