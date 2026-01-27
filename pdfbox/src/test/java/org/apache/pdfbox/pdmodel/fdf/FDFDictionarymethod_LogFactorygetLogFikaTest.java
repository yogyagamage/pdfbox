package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSDictionary;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.junit.jupiter.api.Test;
import javax.xml.parsers.DocumentBuilderFactory;

public class FDFDictionarymethod_LogFactorygetLogFikaTest {

    @Test
    public void testEntryPoint() throws Exception {
        // Create a minimal XML element to pass to the constructor
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element element = document.createElement("test");
        
        // This constructor triggers static initialization which calls LogFactory.getLog()
        new FDFDictionary(element);
    }
}
