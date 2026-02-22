package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PDDocumentCatalog_PDPageTreemethod_LogFactorygetLogFikaTest {

    @Test
    public void testGetPagesTriggersLogFactoryGetLog() throws Exception {
        COSDictionary mockRoot = Mockito.mock(COSDictionary.class);
        Mockito.when(mockRoot.getCOSDictionary(COSName.PAGES)).thenReturn(new COSDictionary());
        
        PDDocument mockDocument = Mockito.mock(PDDocument.class);
        
        PDDocumentCatalog catalog = new PDDocumentCatalog(mockDocument, mockRoot);
        catalog.getPages();
    }
}
