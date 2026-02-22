package org.apache.pdfbox.text;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import java.io.ByteArrayOutputStream;

public class PDFTextStrippermethod_LogwarnFikaTest2 {

    @Test
    public void testSetStartPageTriggersStaticInitializer() throws Exception {
        PDFTextStripper stripper = new PDFTextStripper();
        
        // Set start page to 0 to trigger the warning log call
        stripper.setStartPage(0);
        
        // The static initializer that contains LOG.warn() will have already run
        // during class loading before this test method executes
    }
}
