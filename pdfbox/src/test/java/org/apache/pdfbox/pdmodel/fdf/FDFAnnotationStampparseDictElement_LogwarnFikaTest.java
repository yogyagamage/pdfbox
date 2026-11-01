package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;

class FDFAnnotationStampparseDictElement_LogwarnFikaTest {
    
    @Test
    void testParseDictElement_LogWarn() throws Exception {
        // Create XML document with an element that has null tagName
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                + "<root>"
                + "  <DICT KEY=\"parentKey\">"
                + "    <child KEY=\"childKey\" VAL=\"childValue\"/>"
                + "  </DICT>"
                + "</root>";
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        org.w3c.dom.Document document = builder.parse(new ByteArrayInputStream(xml.getBytes()));
        
        // Get the DICT element
        Element dictEl = (Element) document.getElementsByTagName("DICT").item(0);
        
        // Create a real FDFAnnotationStamp instance to test the private method
        FDFAnnotationStamp stamp = new FDFAnnotationStamp();
        
        // Use reflection to access the private method
        java.lang.reflect.Method method = FDFAnnotationStamp.class.getDeclaredMethod(
            "parseDictElement", Element.class);
        method.setAccessible(true);
        
        // Invoke the method - this should trigger LOG.warn when processing
        // the child element with null tagName
        COSDictionary result = (COSDictionary) method.invoke(stamp, dictEl);
    }
}
