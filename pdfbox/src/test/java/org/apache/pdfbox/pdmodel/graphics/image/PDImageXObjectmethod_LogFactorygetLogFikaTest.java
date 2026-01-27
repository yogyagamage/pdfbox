package org.apache.pdfbox.pdmodel.graphics.image;

import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class PDImageXObjectmethod_LogFactorygetLogFikaTest {

    @Test
    void testCreateThumbnailTriggersStaticInitializer() throws IOException {
        try (PDDocument document = new PDDocument()) {
            COSStream cosStream = document.getDocument().createCOSStream();
            PDImageXObject.createThumbnail(cosStream);
        }
    }
}
