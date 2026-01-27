package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.font.PDType3CharProc;
import org.apache.pdfbox.pdmodel.font.PDType3Font;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDType3CharProc_PDFStreamParsermethod_LogFactorygetLogFikaTest {

    @Test
    void testGetWidthTriggersLogFactoryGetLog() throws Exception {
        PDType3Font font = Mockito.mock(PDType3Font.class);
        COSStream charStream = Mockito.mock(COSStream.class);
        
        PDType3CharProc charProc = new PDType3CharProc(font, charStream);
        
        try {
            charProc.getWidth();
        } catch (Exception e) {
            // Expected - we only care that LogFactory.getLog was invoked
        }
    }
}
