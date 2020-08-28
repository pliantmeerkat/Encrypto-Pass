package com.jackbranch.pmanger.services;

public interface EncryptionService {

    String encrypt(String toEncrypt);

    String decrypt(String toDecrypt);
}
