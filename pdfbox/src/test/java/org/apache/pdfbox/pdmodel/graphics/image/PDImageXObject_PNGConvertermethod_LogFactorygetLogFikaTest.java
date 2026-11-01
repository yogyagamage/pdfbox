package org.apache.pdfbox.pdmodel.graphics.image;

import org.junit.jupiter.api.Test;

public class PDImageXObject_PNGConvertermethod_LogFactorygetLogFikaTest {

    @Test
    void testPngConverterStaticInitializationInvokesLogFactoryGetLog() throws Exception {
        Class.forName("org.apache.pdfbox.pdmodel.graphics.image.PNGConverter");
    }
}
