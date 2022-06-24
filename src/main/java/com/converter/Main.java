package com.converter;

import com.converter.service.FileConverter;
import com.converter.service.FileUtils;

import java.io.IOException;

public class Main {
    private static final String xmlFile = "src/main/resources/sample.xml";

    private static final String yamlFile = "src/main/resources/output.yaml";

    public static void main(String[] args) throws IOException {
        String fileContent = FileUtils.readFileXml(xmlFile);

        FileConverter fileConverter = new FileConverter();
        String json = fileConverter.convertXmlToJson(fileContent);
        String yaml = fileConverter.convertJsonToYaml(json);

        FileUtils.writeFileYaml(yaml, yamlFile);
    }
}
