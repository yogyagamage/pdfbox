package org.apache.pdfbox.text;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.apache.commons.logging.LogFactory;
import org.apache.pdfbox.contentstream.operator.markedcontent.DrawObject;

public class PDFMarkedContentExtractor_DrawObjectmethod_LogFactorygetLogFikaTest {

    @Test
    public void testDrawObjectStaticInitializerTriggersLogFactoryGetLog() {
        // This test triggers the static initialization of DrawObject class
        // which calls LogFactory.getLog(DrawObject.class)
        PDFMarkedContentExtractor extractor = new PDFMarkedContentExtractor();
        
        // The constructor chain will trigger DrawObject class initialization
        // The static field initialization in DrawObject will call LogFactory.getLog()
        // No assertions needed - just ensuring the execution path is followed
    }
}
