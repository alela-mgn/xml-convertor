package com.converter.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.json.XML;

public class FileConverter {
    public String convertXmlToJson(String xmlFile) {
        return XML.toJSONObject(xmlFile).toString();
    }

    public String convertJsonToYaml(String yamlFile) throws JsonProcessingException {
        JsonNode node = new ObjectMapper().readTree(yamlFile);
        cleanJson(node);
        return new YAMLMapper().writeValueAsString(node);
    }

    private void cleanJson(JsonNode jsonNodeTree) {
        JsonNode nodeParent = jsonNodeTree.get("Product");
        if (nodeParent == null || nodeParent.get("techRegs") == null) {
            return;
        }
        ((ObjectNode) nodeParent).remove("techRegs");
    }
}
