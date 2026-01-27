package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.fdf.FDFAnnotationLink;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.junit.jupiter.api.Test;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

public class FDFDictionary_FDFAnnotationLinkmethod_LogFactorygetLogFikaTest {

    @Test
    public void testEntryPointTriggersThirdPartyMethod() throws Exception {
        // Create a minimal XML element that will trigger the "link" annotation case
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        
        // Create root element
        Element rootElement = document.createElement("xfdf");
        
        // Create annots element
        Element annotsElement = document.createElement("annots");
        rootElement.appendChild(annotsElement);
        
        // Create link annotation element
        Element linkElement = document.createElement("link");
        annotsElement.appendChild(linkElement);
        
        // Instantiate FDFDictionary with the XML element
        // This will trigger the constructor that processes XML
        // and eventually cause FDFAnnotationLink class initialization
        // which will call LogFactory.getLog(FDFAnnotationLink.class)
        FDFDictionary dictionary = new FDFDictionary(rootElement);
    }
}
