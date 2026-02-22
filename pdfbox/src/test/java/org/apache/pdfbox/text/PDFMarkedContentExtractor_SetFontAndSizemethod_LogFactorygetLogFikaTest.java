package org.apache.pdfbox.text;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;

class PDFMarkedContentExtractor_SetFontAndSizemethod_LogFactorygetLogFikaTest {

    @Test
    void testConstructorTriggersLogFactoryGetLog() {
        PDFMarkedContentExtractor extractor = new PDFMarkedContentExtractor("UTF-8");
    }
}
