package org.apache.pdfbox.pdmodel.fdf;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class FDFDictionary_FDFAnnotationStampmethod_LogFactorygetLogFikaTest {

    @Test
    public void testFDFDictionaryConstructorTriggersFDFAnnotationStampStaticInitializer() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        
        Element rootElement = document.createElement("xfdf");
        Element annotsElement = document.createElement("annots");
        Element stampElement = document.createElement("stamp");
        
        annotsElement.appendChild(stampElement);
        rootElement.appendChild(annotsElement);
        
        FDFDictionary fdfDictionary = new FDFDictionary(rootElement);
    }
}
