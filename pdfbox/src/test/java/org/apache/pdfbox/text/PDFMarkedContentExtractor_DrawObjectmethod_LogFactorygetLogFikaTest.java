package org.apache.pdfbox.text;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;

class PDFMarkedContentExtractor_DrawObjectmethod_LogFactorygetLogFikaTest {

    @Test
    void testDrawObjectStaticInitializerTriggersLogFactoryGetLog() {
        // Entry point: PDFMarkedContentExtractor constructor
        PDFMarkedContentExtractor extractor = new PDFMarkedContentExtractor("UTF-8");
        // Constructor adds DrawObject operator, triggering static initialization
        // which calls LogFactory.getLog(DrawObject.class)
    }
}
