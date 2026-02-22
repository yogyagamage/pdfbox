package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.pdmodel.fixup.PDDocumentFixup;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class PDDocumentCatalogmethod_LogFactorygetLogFikaTest3 {

    @Test
    public void testGetAcroFormTriggersStaticInitializer() throws Exception {
        // Create mocks for constructor dependencies
        org.apache.pdfbox.pdmodel.PDDocument document = mock(org.apache.pdfbox.pdmodel.PDDocument.class);
        org.apache.pdfbox.cos.COSDictionary rootDict = mock(org.apache.pdfbox.cos.COSDictionary.class);
        
        // Mock the COSName.ACRO_FORM access
        Mockito.when(rootDict.getCOSDictionary(org.apache.pdfbox.cos.COSName.ACRO_FORM))
               .thenReturn(null);
        
        // Create the catalog instance
        org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = 
            new org.apache.pdfbox.pdmodel.PDDocumentCatalog(document, rootDict);
        
        // Call the entry point method - this will trigger the static initializer
        // which calls LogFactory.getLog(PDDocumentCatalog.class)
        catalog.getAcroForm((PDDocumentFixup) null);
    }
}
