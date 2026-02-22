package org.apache.pdfbox.pdmodel.common;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDObjectStream_PDStreammethod_LogFactorygetLogFikaTest {

    @Test
    void testCreateStreamTriggersStaticInitializer() throws Exception {
        PDDocument document = Mockito.mock(PDDocument.class);
        org.apache.pdfbox.cos.COSDocument cosDocument = Mockito.mock(org.apache.pdfbox.cos.COSDocument.class);
        org.apache.pdfbox.cos.COSStream cosStream = Mockito.mock(org.apache.pdfbox.cos.COSStream.class);
        
        Mockito.when(document.getDocument()).thenReturn(cosDocument);
        Mockito.when(cosDocument.createCOSStream()).thenReturn(cosStream);
        
        PDObjectStream.createStream(document);
    }
}
