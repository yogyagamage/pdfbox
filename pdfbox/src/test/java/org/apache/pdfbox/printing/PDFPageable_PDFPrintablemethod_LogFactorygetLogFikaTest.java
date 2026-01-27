package org.apache.pdfbox.printing;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFPageable_PDFPrintablemethod_LogFactorygetLogFikaTest {

    @Test
    void testGetPrintableTriggersLogFactoryGetLog() throws Exception {
        PDDocument mockDocument = Mockito.mock(PDDocument.class);
        Mockito.when(mockDocument.getNumberOfPages()).thenReturn(1);
        
        PDFPageable pageable = new PDFPageable(mockDocument);
        pageable.getPrintable(0);
    }
}
