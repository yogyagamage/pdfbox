package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDDocumentCatalogmethod_LogFactorygetLogFikaTest {

    @Test
    void testGetPageModeTriggersStaticInitializer() {
        // Create a mock PDDocument to satisfy constructor dependency
        PDDocument mockDocument = Mockito.mock(PDDocument.class);
        COSDictionary mockRootDict = Mockito.mock(COSDictionary.class);
        
        // Create instance using the second constructor
        PDDocumentCatalog catalog = new PDDocumentCatalog(mockDocument, mockRootDict);
        
        // Call the entry point method - this will trigger static initialization
        // which calls LogFactory.getLog(PDDocumentCatalog.class)
        catalog.getPageMode();
    }
}
