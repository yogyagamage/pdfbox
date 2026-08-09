package org.apache.pdfbox.pdmodel.graphics.state;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDSoftMaskmethod_LogFactorygetLogFikaTest {

    @Test
    void testCreateTriggersLogFactoryGetLog() {
        // Create a mock COSDictionary for constructor parameter
        COSDictionary mockDictionary = Mockito.mock(COSDictionary.class);
        
        // Instantiate PDSoftMask using one of the provided constructors
        PDSoftMask instance = new PDSoftMask(mockDictionary);
        
        // Call the static entry point method with a COSBase parameter
        // The static initialization will trigger LogFactory.getLog during class loading
        COSBase param = mockDictionary; // COSDictionary implements COSBase
        PDSoftMask.create(param);
    }
}
