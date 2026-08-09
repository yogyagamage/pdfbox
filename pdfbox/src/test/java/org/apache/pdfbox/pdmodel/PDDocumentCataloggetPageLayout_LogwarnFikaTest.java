package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PageLayout;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class PDDocumentCataloggetPageLayout_LogwarnFikaTest {

    @Test
    void testGetPageLayoutTriggersLogWarn() {
        // Create a mock PDDocument to satisfy constructor dependency
        PDDocument mockDocument = mock(PDDocument.class);
        
        // Create a COSDictionary with an invalid PageLayout value
        COSDictionary rootDict = new COSDictionary();
        rootDict.setName(COSName.PAGE_LAYOUT, "INVALID_LAYOUT");
        
        // Instantiate PDDocumentCatalog using the constructor with root dictionary
        PDDocumentCatalog catalog = new PDDocumentCatalog(mockDocument, rootDict);
        
        // Call the entry point method - this should trigger the log warning
        catalog.getPageLayout();
    }
}
