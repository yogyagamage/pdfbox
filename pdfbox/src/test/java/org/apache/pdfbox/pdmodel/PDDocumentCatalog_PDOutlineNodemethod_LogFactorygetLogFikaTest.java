package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDDocumentCatalog_PDOutlineNodemethod_LogFactorygetLogFikaTest {

    @Test
    void testGetDocumentOutlineTriggersPDOutlineNodeStaticInitializer() {
        // Create a mock PDDocument to satisfy constructor dependency
        PDDocument mockDocument = Mockito.mock(PDDocument.class);
        org.apache.pdfbox.cos.COSDocument mockCOSDocument = Mockito.mock(org.apache.pdfbox.cos.COSDocument.class);
        COSDictionary mockTrailer = Mockito.mock(COSDictionary.class);
        
        Mockito.when(mockDocument.getDocument()).thenReturn(mockCOSDocument);
        Mockito.when(mockCOSDocument.getTrailer()).thenReturn(mockTrailer);
        
        // Create a real COSDictionary for the root parameter
        COSDictionary rootDict = new COSDictionary();
        
        // Instantiate PDDocumentCatalog using the two-parameter constructor
        PDDocumentCatalog catalog = new PDDocumentCatalog(mockDocument, rootDict);
        
        // Set up the OUTLINES entry in the root dictionary to trigger 
        // PDDocumentOutline constructor which will load PDOutlineNode class
        COSDictionary outlineDict = new COSDictionary();
        rootDict.setItem(org.apache.pdfbox.cos.COSName.OUTLINES, outlineDict);
        
        // Call the entry point method - this will trigger PDOutlineNode class loading
        // which will execute its static initializer containing LogFactory.getLog()
        PDDocumentOutline result = catalog.getDocumentOutline();
        
        // No assertions - test passes if no exception is thrown
    }
}
