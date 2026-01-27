package org.apache.pdfbox.pdmodel.graphics.state;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDSoftMaskmethod_LogFactorygetLogFikaTest {

    @Test
    void testCreateTriggersStaticInitializer() {
        COSDictionary mockDictionary = Mockito.mock(COSDictionary.class);
        PDSoftMask.create((COSBase) mockDictionary);
    }
}
