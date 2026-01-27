package org.apache.pdfbox.text;

import org.apache.pdfbox.contentstream.operator.markedcontent.BeginMarkedContentSequence;
import org.apache.pdfbox.contentstream.operator.markedcontent.BeginMarkedContentSequenceWithProperties;
import org.apache.pdfbox.contentstream.operator.markedcontent.DrawObject;
import org.apache.pdfbox.contentstream.operator.markedcontent.EndMarkedContentSequence;
import org.apache.pdfbox.contentstream.operator.markedcontent.MarkedContentPoint;
import org.apache.pdfbox.contentstream.operator.markedcontent.MarkedContentPointWithProperties;
import org.junit.jupiter.api.Test;

class PDFMarkedContentExtractor_DrawObjectmethod_LogFactorygetLogFikaTest {

    @Test
    void testConstructorTriggersDrawObjectStaticInitializer() {
        PDFMarkedContentExtractor extractor = new PDFMarkedContentExtractor("UTF-8");
    }
}
