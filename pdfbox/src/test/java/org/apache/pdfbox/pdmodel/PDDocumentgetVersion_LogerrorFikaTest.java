package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.cos.COSDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

public class PDDocumentgetVersion_LogerrorFikaTest {

    @Test
    public void testGetVersionTriggersLogError() throws Exception {
        // Create real PDDocument
        PDDocument document = new PDDocument();
        
        // Create real COSDocument with version >= 1.4
        COSDocument cosDocument = new COSDocument();
        cosDocument.setVersion(1.4f);
        
        // Use reflection to set the COSDocument in PDDocument
        Field cosDocField = PDDocument.class.getDeclaredField("document");
        cosDocField.setAccessible(true);
        cosDocField.set(document, cosDocument);
        
        // Create mock PDDocumentCatalog that returns non-null but non-parsable version
        PDDocumentCatalog catalog = Mockito.mock(PDDocumentCatalog.class);
        Mockito.when(catalog.getVersion()).thenReturn("not-a-float");
        
        // Use reflection to set the catalog in PDDocument
        Field catalogField = PDDocument.class.getDeclaredField("documentCatalog");
        catalogField.setAccessible(true);
        catalogField.set(document, catalog);
        
        // Invoke the method - this should trigger the Log.error call
        document.getVersion();
    }
}
