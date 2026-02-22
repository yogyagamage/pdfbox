package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

public class FDFDictionarymethod_LogFactorygetLogFikaTest {

    @Test
    public void testEntryPoint() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element element = document.createElement("test");
        
        COSDictionary cosDict = new COSDictionary();
        FDFDictionary fdfDict = new FDFDictionary(cosDict);
        
        // Trigger static initialization
        new FDFDictionary(element);
    }
}
