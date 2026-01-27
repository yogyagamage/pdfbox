package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.common.filespecification.PDSimpleFileSpecification;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.junit.jupiter.api.Test;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class FDFDictionarymethod_LogwarnFikaTest {

    @Test
    public void testEntryPointToThirdPartyMethod() throws Exception {
        // Create an XML element that will trigger the warn() call
        // We need an "ids" element with invalid hex attributes to trigger IOException
        // which will cause LOG.warn() to be called
        String xmlContent = "<?xml version=\"1.0\"?><xfdf><ids original=\"INVALID_HEX\" modified=\"INVALID_HEX\"/></xfdf>";
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new ByteArrayInputStream(xmlContent.getBytes()));
        
        Element rootElement = document.getDocumentElement();
        
        // Create FDFDictionary with the XML element - this should trigger the warn() call
        // when it tries to parse the invalid hex strings
        FDFDictionary fdfDictionary = new FDFDictionary(rootElement);
    }
}
