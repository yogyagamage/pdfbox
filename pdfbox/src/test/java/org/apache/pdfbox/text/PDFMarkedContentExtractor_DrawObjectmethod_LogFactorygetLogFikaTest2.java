package org.apache.pdfbox.text;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.contentstream.operator.DrawObject;
import org.apache.commons.logging.LogFactory;

public class PDFMarkedContentExtractor_DrawObjectmethod_LogFactorygetLogFikaTest2 {

    @Test
    public void testDrawObjectStaticInitializerTriggersLogFactoryGetLog() {
        // Instantiate using the constructor that matches the entry point
        PDFMarkedContentExtractor extractor = new PDFMarkedContentExtractor("UTF-8");
        
        // The constructor chain will trigger:
        // 1. PDFMarkedContentExtractor.<init>(String)
        // 2. LegacyPDFStreamEngine.<init>()
        // 3. DrawObject.<clinit>() during operator registration
        // 4. LogFactory.getLog(DrawObject.class) via static field initialization
        
        // No assertions or verifications needed
    }
}
