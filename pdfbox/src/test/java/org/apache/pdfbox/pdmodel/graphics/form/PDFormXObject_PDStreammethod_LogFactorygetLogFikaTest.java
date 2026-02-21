package org.apache.pdfbox.pdmodel.graphics.form;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class PDFormXObject_PDStreammethod_LogFactorygetLogFikaTest {

    @Test
    public void testPDStreamConstructorTriggersLogFactoryGetLog() throws IOException {
        try (PDDocument document = new PDDocument()) {
            byte[] data = new byte[] { 1, 2, 3, 4 };
            ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
            new PDStream(document, inputStream);
        }
    }
}
