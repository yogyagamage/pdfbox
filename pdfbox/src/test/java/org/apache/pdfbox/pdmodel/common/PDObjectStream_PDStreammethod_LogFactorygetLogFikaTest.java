package org.apache.pdfbox.pdmodel.common;

import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDObjectStream_PDStreammethod_LogFactorygetLogFikaTest {

    @Test
    void testCreateStreamTriggersLogFactoryGetLog() {
        // Create a mock PDDocument that can provide a mock COSDocument
        PDDocument mockDocument = Mockito.mock(PDDocument.class);
        org.apache.pdfbox.cos.COSDocument mockCosDocument = Mockito.mock(org.apache.pdfbox.cos.COSDocument.class);
        COSStream mockCosStream = Mockito.mock(COSStream.class);
        
        // Setup the chain: document.getDocument() -> mockCosDocument.createCOSStream() -> mockCosStream
        Mockito.when(mockDocument.getDocument()).thenReturn(mockCosDocument);
        Mockito.when(mockCosDocument.createCOSStream()).thenReturn(mockCosStream);
        
        // Create the PDObjectStream instance using the constructor
        PDObjectStream streamInstance = new PDObjectStream(mockCosStream);
        
        // Call the static entry point method
        PDObjectStream.createStream(mockDocument);
        
        // No assertions or verifications - test only needs to execute the chain
    }
}
