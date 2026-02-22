package org.apache.pdfbox.text;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;

class PDFMarkedContentExtractor_DrawObjectmethod_LogFactorygetLogFikaTest2 {

    @Test
    void testDrawObjectStaticInitializerTriggersLogFactoryGetLog() {
        // Create PDFMarkedContentExtractor instance which triggers the constructor chain
        // leading to DrawObject class initialization and LogFactory.getLog() call
        PDFMarkedContentExtractor extractor = new PDFMarkedContentExtractor("UTF-8");
    }
}
