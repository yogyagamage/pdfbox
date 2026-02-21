package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

class PDDocumentCatalogmethod_LogFactorygetLogFikaTest {

    @Test
    void testGetLogInvocation() throws Exception {
        COSDictionary dict = new COSDictionary();
        dict.setItem(COSName.TYPE, COSName.CATALOG);
        
        PDDocument document = new PDDocument();
        PDDocumentCatalog catalog = new PDDocumentCatalog(document, dict);
        
        // The static field LOG triggers LogFactory.getLog during class initialization
        // The constructor may also trigger logging
        catalog.getCOSObject();
    }
}
