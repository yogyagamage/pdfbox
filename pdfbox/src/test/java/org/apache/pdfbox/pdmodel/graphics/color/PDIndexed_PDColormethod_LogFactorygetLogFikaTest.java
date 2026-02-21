package org.apache.pdfbox.pdmodel.graphics.color;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import java.io.IOException;

public class PDIndexed_PDColormethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDColorSpace colorSpace = PDDeviceRGB.INSTANCE;
            float[] components = {0.5f, 0.5f, 0.5f};
            PDColor color = new PDColor(components, colorSpace);
        }
    }
}
