package com.jackbranch.pmanger.services;

import com.jackbranch.pmanger.config.EncryptionConfig;
import com.jackbranch.pmanger.domain.PasswordKey;
import com.jackbranch.pmanger.util.FileProcessor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

import java.nio.file.Paths;
import java.time.Instant;
import java.time.Period;
import java.util.logging.Logger;

public class EncryptionServiceImpl implements EncryptionService {

    private static final Logger LOGGER = Logger.getLogger(EncryptionServiceImpl.class.getName());
    private final FileProcessor fileProcessor;

    private final PasswordKey passwordKey;
    private final TextEncryptor encryptor;

    public EncryptionServiceImpl(FileProcessor fileProcessor) {
        this.fileProcessor = fileProcessor;
        this.passwordKey = getOrCreateKey();
        this.encryptor = Encryptors.text(passwordKey.getValue(), passwordKey.getSalt());
    }

    @Override
    public String encrypt(String toEncrypt) {
        return encryptor.encrypt(toEncrypt);
    }

    @Override
    public String decrypt(String toDecrypt) {
        return encryptor.decrypt(toDecrypt);
    }

    PasswordKey getOrCreateKey() {
        PasswordKey key;
        if(fileProcessor.fileExists(Paths.get(EncryptionConfig.KEY_FILE_NAME, EncryptionConfig.KEY_FILE_PATH))) {
            key = this.fileProcessor.read();
            if(keyHasExpired(key)) {

            }
        } else {
            key = new PasswordKey(KeyGenerators.string().generateKey(),
                    KeyGenerators.string().generateKey());
            fileProcessor.write(key);
        }
        return key;
    }

    boolean keyHasExpired(PasswordKey passwordKey) {
        return passwordKey.getUpdated().plus(Period.ofDays(1)).isBefore(Instant.now());
    }
}
