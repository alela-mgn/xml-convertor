package com.converter.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class FileConverterTest {
    FileConverter converter = new FileConverter();

    @Test
    public void convertXmlToJson() throws IOException {
        String fileContent = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<fsa:ResponseFsaType xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:tns=\"urn://x-artefact-rosaccreditation-ru/rdc/commons/1.0.2\" xmlns:fsa=\"urn://x-artefact-rosaccreditation-ru/rdc/1.0.2\">\n" +
                "    <fsa:RdcTr>\n" +
                "        <tns:Type>TrRf</tns:Type>\n" +
                "        <tns:Requisites>\n" +
                "        </tns:Requisites>\n" +
                "    </fsa:RdcTr>\n" +
                "</fsa:ResponseFsaType>";
        String actual ="{\"fsa:ResponseFsaType\":{\"xmlns:tns\":\"urn://x-artefact-rosaccreditation-ru/rdc/commons/1.0.2\",\"xmlns:xsi\":\"http://www.w3.org/2001/XMLSchema-instance\",\"fsa:RdcTr\":{\"tns:Type\":\"TrRf\",\"tns:Requisites\":\"\"},\"xmlns:fsa\":\"urn://x-artefact-rosaccreditation-ru/rdc/1.0.2\"}}";

        String expected = converter.convertXmlToJson(fileContent);

        assertEquals(expected, actual);
    }

    @Test
    public void convertJsonToYaml() throws JsonProcessingException {
    String fileContent ="{\"fsa:ResponseFsaType\":{\"xmlns:tns\":\"urn://x-artefact-rosaccreditation-ru/rdc/commons/1.0.2\",\"xmlns:xsi\":\"http://www.w3.org/2001/XMLSchema-instance\",\"fsa:RdcTr\":{\"tns:Type\":\"TrRf\",\"tns:Requisites\":\"\"},\"xmlns:fsa\":\"urn://x-artefact-rosaccreditation-ru/rdc/1.0.2\"}}";
    String actual = "---\n" +
            "fsa:ResponseFsaType:\n" +
            "  xmlns:tns: \"urn://x-artefact-rosaccreditation-ru/rdc/commons/1.0.2\"\n" +
            "  xmlns:xsi: \"http://www.w3.org/2001/XMLSchema-instance\"\n" +
            "  fsa:RdcTr:\n" +
            "    tns:Type: \"TrRf\"\n" +
            "    tns:Requisites: \"\"\n" +
            "  xmlns:fsa: \"urn://x-artefact-rosaccreditation-ru/rdc/1.0.2\"\n";

    String expected = converter.convertJsonToYaml(fileContent);

    assertEquals(expected, actual);

    }
}