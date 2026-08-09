package org.apache.pdfbox.pdmodel.fdf;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class FDFDictionary_FDFAnnotationmethod_LogFactorygetLogFikaTest {

    @Test
    public void testEntryPointToThirdPartyMethod() throws Exception {
        // Create a minimal XML element that will trigger the "stamp" case
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        
        // Create root element
        Element root = document.createElement("root");
        
        // Create annots element
        Element annots = document.createElement("annots");
        root.appendChild(annots);
        
        // Create stamp annotation element
        Element stamp = document.createElement("stamp");
        annots.appendChild(stamp);
        
        // Create FDFDictionary with the root element
        // This will trigger the constructor chain that eventually calls LogFactory.getLog()
        FDFDictionary dictionary = new FDFDictionary(root);
    }
}
