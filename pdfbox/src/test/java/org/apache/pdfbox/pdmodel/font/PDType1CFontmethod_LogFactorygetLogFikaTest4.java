package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class PDType1CFontmethod_LogFactorygetLogFikaTest4 {

    @Test
    void testEntryPoint() throws IOException {
        COSDictionary fontDictionary = Mockito.mock(COSDictionary.class);
        
        // This will trigger the static initialization which calls LogFactory.getLog
        new PDType1CFont(fontDictionary);
    }
}
