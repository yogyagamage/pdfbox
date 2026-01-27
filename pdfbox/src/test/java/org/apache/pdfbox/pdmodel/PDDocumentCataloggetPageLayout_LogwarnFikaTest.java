package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PageLayout;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDDocumentCataloggetPageLayout_LogwarnFikaTest {

    @Test
    void testGetPageLayoutTriggersLogWarn() throws Exception {
        // Create a mock PDDocument to satisfy constructor dependency
        PDDocument mockDocument = Mockito.mock(PDDocument.class);
        
        // Create a COSDictionary that will be used as the root dictionary
        COSDictionary rootDict = new COSDictionary();
        
        // Set an invalid PageLayout value that will cause IllegalArgumentException
        // when PageLayout.fromString() is called
        rootDict.setName(COSName.PAGE_LAYOUT, "INVALID_LAYOUT");
        
        // Instantiate PDDocumentCatalog using the second constructor
        PDDocumentCatalog catalog = new PDDocumentCatalog(mockDocument, rootDict);
        
        // Call the entry point method - this should trigger the log warning
        // when it tries to parse "INVALID_LAYOUT" as a PageLayout
        catalog.getPageLayout();
    }
}
