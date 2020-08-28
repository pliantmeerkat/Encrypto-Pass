package com.jackbranch.pmanger.util;

import com.jackbranch.pmanger.domain.BaseEntity;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessor {

    private FileProcessor() {

    }

    public static FileProcessor create() {
        return new FileProcessor();
    }

    public void write(BaseEntity objectToWrite) {

    }

    public <T extends BaseEntity> T read() {
        return null;
    }

    public boolean fileExists(Path filePath) {
        return Files.exists(filePath);
    }
}
