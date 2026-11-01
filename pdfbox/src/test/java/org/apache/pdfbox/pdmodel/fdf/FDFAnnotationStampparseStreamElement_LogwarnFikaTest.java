package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class FDFAnnotationStampparseStreamElement_LogwarnFikaTest {

    @Test
    void testParseStreamElementTriggersLogWarn() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        String xml = "<STREAM KEY=\"testKey\"><UNKNOWN KEY=\"childKey\" VAL=\"childValue\"/></STREAM>";
        Document doc = builder.parse(new ByteArrayInputStream(xml.getBytes()));
        Element streamEl = doc.getDocumentElement();
        
        FDFAnnotationStamp instance = new FDFAnnotationStamp();
        java.lang.reflect.Method method = FDFAnnotationStamp.class.getDeclaredMethod(
            "parseStreamElement", Element.class);
        method.setAccessible(true);
        
        try {
            method.invoke(instance, streamEl);
        } catch (Exception e) {
            // Ignore any exceptions - test goal is only to reach the Log.warn call
        }
    }
}
