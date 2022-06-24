package com.converter.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {
    public static String readFileXml(String xmlFile) throws IOException {
        return Files.readString(Path.of(xmlFile));
    }

    public static void writeFileYaml(String xmlFile, String yamlFile) throws IOException {
        Files.writeString(Path.of(yamlFile), xmlFile);
    }
}
